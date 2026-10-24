package com.example

import com.example.data.model.City
import com.example.data.model.RepairDatabase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun testRepairDatabaseAppliancesCount() {
        assertTrue(RepairDatabase.appliances.size >= 4)
        assertNotNull(RepairDatabase.getApplianceById("fan"))
        assertNotNull(RepairDatabase.getApplianceById("cooler"))
        assertNotNull(RepairDatabase.getApplianceById("mobile"))
        assertNotNull(RepairDatabase.getApplianceById("fridge"))
    }

    @Test
    fun testSearchProblems() {
        val hitsFan = RepairDatabase.searchProblems("fan awaaz")
        assertTrue("Expected search results for fan awaaz", hitsFan.isNotEmpty())
        assertEquals("fan", hitsFan.first().appliance.id)

        val hitsCurrent = RepairDatabase.searchProblems("current jhatka")
        assertTrue("Expected search results for current", hitsCurrent.isNotEmpty())
        assertEquals("cooler", hitsCurrent.first().appliance.id)
    }

    @Test
    fun testCityMultiplierCalculation() {
        val pair = RepairDatabase.getProblemById("fan", "fan1")
        assertNotNull(pair)
        val problem = pair!!.second

        val baseRange = problem.getOverallRange(1.0f)
        val mumbaiRange = problem.getOverallRange(1.25f)

        assertTrue(mumbaiRange.second >= baseRange.second)
    }
}
