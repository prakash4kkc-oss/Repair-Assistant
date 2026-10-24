package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedReportDao {
    @Query("SELECT * FROM saved_reports ORDER BY savedTimestamp DESC")
    fun getAllSavedReports(): Flow<List<SavedReportEntity>>

    @Query("SELECT * FROM saved_reports WHERE applianceId = :applianceId AND problemId = :problemId LIMIT 1")
    fun getSavedReport(applianceId: String, problemId: String): Flow<SavedReportEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(report: SavedReportEntity): Long

    @Update
    suspend fun update(report: SavedReportEntity)

    @Delete
    suspend fun delete(report: SavedReportEntity)

    @Query("DELETE FROM saved_reports WHERE id = :id")
    suspend fun deleteById(id: Long)
}
