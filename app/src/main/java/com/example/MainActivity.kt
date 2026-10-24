package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.AppTopBar
import com.example.ui.components.CitySelectorSheet
import com.example.ui.screens.DiagnosisDetailScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.RepairVsBuyCalculatorScreen
import com.example.ui.screens.SafetyGuideScreen
import com.example.ui.screens.SavedRepairsScreen
import com.example.ui.theme.RepairAssistantTheme
import com.example.ui.viewmodel.RepairAssistantViewModel
import com.example.ui.viewmodel.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepairAssistantTheme {
                RepairAssistantApp()
            }
        }
    }
}

@Composable
fun RepairAssistantApp(
    viewModel: RepairAssistantViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val savedReports by viewModel.savedReports.collectAsStateWithLifecycle()
    var isCitySheetOpen by remember { mutableStateOf(false) }

    if (isCitySheetOpen) {
        CitySelectorSheet(
            selectedCity = uiState.selectedCity,
            onCitySelected = { viewModel.selectCity(it) },
            onDismiss = { isCitySheetOpen = false }
        )
    }

    val title = when (uiState.currentScreen) {
        Screen.HOME -> "Repair Assistant"
        Screen.DIAGNOSIS_DETAIL -> uiState.selectedProblem?.title ?: "Diagnosis"
        Screen.SAVED -> "Saved Repairs (${savedReports.size})"
        Screen.SAFETY_GUIDE -> "Bijli Suraksha Niyam"
        Screen.CALCULATOR -> "Repair vs Naya Upkaran"
    }

    val subtitle = when (uiState.currentScreen) {
        Screen.HOME -> "Fan, cooler, mobile, fridge ki samasya aur kharcha"
        Screen.DIAGNOSIS_DETAIL -> "${uiState.selectedAppliance.name} • ${uiState.selectedCity.name}"
        Screen.SAVED -> "Ghar ke upkaran aur technician quotation notes"
        Screen.SAFETY_GUIDE -> "Electrical hazards & safe handling guide"
        Screen.CALCULATOR -> "50% rule: Theek karwayein ya naya lein?"
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(
                title = title,
                subtitle = subtitle,
                showBackButton = uiState.currentScreen != Screen.HOME,
                onBackClick = { viewModel.navigateBack() },
                savedCount = savedReports.size,
                onSavedClick = { viewModel.navigateTo(Screen.SAVED) },
                onSafetyGuideClick = { viewModel.navigateTo(Screen.SAFETY_GUIDE) },
                onCalculatorClick = { viewModel.navigateTo(Screen.CALCULATOR) },
                selectedCity = if (uiState.currentScreen == Screen.HOME) uiState.selectedCity else null,
                onCityClick = { isCitySheetOpen = true }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (uiState.currentScreen) {
                Screen.HOME -> {
                    HomeScreen(
                        selectedAppliance = uiState.selectedAppliance,
                        selectedCity = uiState.selectedCity,
                        searchQuery = uiState.searchQuery,
                        searchResults = uiState.searchResults,
                        isSearchActive = uiState.isSearchActive,
                        onApplianceSelected = { viewModel.selectAppliance(it) },
                        onProblemSelected = { appId, probId ->
                            viewModel.selectProblem(appId, probId)
                        },
                        onSearchQueryChanged = { viewModel.onSearchQueryChange(it) },
                        onClearSearch = { viewModel.clearSearch() }
                    )
                }

                Screen.DIAGNOSIS_DETAIL -> {
                    val problem = uiState.selectedProblem
                    if (problem != null) {
                        DiagnosisDetailScreen(
                            appliance = uiState.selectedAppliance,
                            problem = problem,
                            city = uiState.selectedCity,
                            currentSavedReport = uiState.currentSavedReport,
                            onBack = { viewModel.navigateBack() },
                            onToggleSave = { note -> viewModel.toggleSaveCurrentReport(note) },
                            onOpenCalculator = { viewModel.navigateTo(Screen.CALCULATOR) }
                        )
                    }
                }

                Screen.SAVED -> {
                    SavedRepairsScreen(
                        savedReports = savedReports,
                        onSelectReport = { appId, probId ->
                            viewModel.selectProblem(appId, probId)
                        },
                        onToggleResolved = { viewModel.toggleReportResolved(it) },
                        onDeleteReport = { viewModel.deleteSavedReport(it) },
                        onBack = { viewModel.navigateBack() }
                    )
                }

                Screen.SAFETY_GUIDE -> {
                    SafetyGuideScreen(
                        onBack = { viewModel.navigateBack() }
                    )
                }

                Screen.CALCULATOR -> {
                    val initialCost = uiState.selectedProblem?.getOverallRange(uiState.selectedCity.multiplier)?.second ?: 0
                    RepairVsBuyCalculatorScreen(
                        initialRepairCost = initialCost,
                        onBack = { viewModel.navigateBack() }
                    )
                }
            }
        }
    }
}
