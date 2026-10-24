package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_reports")
data class SavedReportEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val applianceId: String,
    val applianceName: String,
    val applianceIcon: String,
    val problemId: String,
    val problemTitle: String,
    val cityName: String,
    val estimatedRangeText: String,
    val userNotes: String = "",
    val savedTimestamp: Long = System.currentTimeMillis(),
    val isResolved: Boolean = false
)
