package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.SavedReportEntity
import com.example.data.model.Appliance
import com.example.data.model.City
import com.example.data.model.Problem
import com.example.data.model.RepairDatabase
import com.example.data.model.SearchResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class Screen {
    HOME,
    DIAGNOSIS_DETAIL,
    SAVED,
    SAFETY_GUIDE,
    CALCULATOR
}

data class UiState(
    val currentScreen: Screen = Screen.HOME,
    val selectedAppliance: Appliance = RepairDatabase.appliances[0],
    val selectedProblem: Problem? = null,
    val selectedCity: City = City.DEFAULT,
    val searchQuery: String = "",
    val searchResults: List<SearchResult> = emptyList(),
    val isSearchActive: Boolean = false,
    val isBookmarkSheetVisible: Boolean = false,
    val currentSavedReport: SavedReportEntity? = null
)

class RepairAssistantViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val dao = db.savedReportDao()

    val savedReports: StateFlow<List<SavedReportEntity>> = dao.getAllSavedReports()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun selectAppliance(applianceId: String) {
        val app = RepairDatabase.getApplianceById(applianceId) ?: return
        _uiState.value = _uiState.value.copy(
            selectedAppliance = app,
            selectedProblem = null,
            searchQuery = "",
            isSearchActive = false,
            searchResults = emptyList()
        )
    }

    fun selectProblem(applianceId: String, problemId: String) {
        val pair = RepairDatabase.getProblemById(applianceId, problemId) ?: return
        _uiState.value = _uiState.value.copy(
            selectedAppliance = pair.first,
            selectedProblem = pair.second,
            currentScreen = Screen.DIAGNOSIS_DETAIL,
            isSearchActive = false
        )
        checkIfCurrentProblemSaved(applianceId, problemId)
    }

    fun selectCity(city: City) {
        _uiState.value = _uiState.value.copy(selectedCity = city)
    }

    fun onSearchQueryChange(query: String) {
        val trimmed = query
        val results = if (trimmed.isBlank()) emptyList() else RepairDatabase.searchProblems(trimmed)
        _uiState.value = _uiState.value.copy(
            searchQuery = trimmed,
            searchResults = results,
            isSearchActive = trimmed.isNotBlank()
        )
    }

    fun clearSearch() {
        _uiState.value = _uiState.value.copy(
            searchQuery = "",
            searchResults = emptyList(),
            isSearchActive = false
        )
    }

    fun navigateTo(screen: Screen) {
        _uiState.value = _uiState.value.copy(currentScreen = screen)
    }

    fun navigateBack(): Boolean {
        return when (_uiState.value.currentScreen) {
            Screen.DIAGNOSIS_DETAIL -> {
                _uiState.value = _uiState.value.copy(
                    currentScreen = Screen.HOME,
                    selectedProblem = null
                )
                true
            }
            Screen.SAVED, Screen.SAFETY_GUIDE, Screen.CALCULATOR -> {
                _uiState.value = _uiState.value.copy(currentScreen = Screen.HOME)
                true
            }
            Screen.HOME -> false
        }
    }

    private fun checkIfCurrentProblemSaved(applianceId: String, problemId: String) {
        viewModelScope.launch {
            dao.getSavedReport(applianceId, problemId).collect { report ->
                _uiState.value = _uiState.value.copy(currentSavedReport = report)
            }
        }
    }

    fun toggleSaveCurrentReport(userNotes: String = "") {
        val problem = _uiState.value.selectedProblem ?: return
        val appliance = _uiState.value.selectedAppliance
        val city = _uiState.value.selectedCity
        val existing = _uiState.value.currentSavedReport

        viewModelScope.launch {
            if (existing != null) {
                dao.delete(existing)
                _uiState.value = _uiState.value.copy(currentSavedReport = null)
            } else {
                val range = problem.getOverallRange(city.multiplier)
                val rangeText = if (range.second == 0) "Muft" else "₹${range.first} - ₹${range.second}"
                val newReport = SavedReportEntity(
                    applianceId = appliance.id,
                    applianceName = appliance.name,
                    applianceIcon = appliance.icon,
                    problemId = problem.id,
                    problemTitle = problem.title,
                    cityName = city.name,
                    estimatedRangeText = rangeText,
                    userNotes = userNotes
                )
                dao.insert(newReport)
            }
        }
    }

    fun deleteSavedReport(report: SavedReportEntity) {
        viewModelScope.launch {
            dao.delete(report)
            if (_uiState.value.currentSavedReport?.id == report.id) {
                _uiState.value = _uiState.value.copy(currentSavedReport = null)
            }
        }
    }

    fun toggleReportResolved(report: SavedReportEntity) {
        viewModelScope.launch {
            dao.update(report.copy(isResolved = !report.isResolved))
        }
    }
}
