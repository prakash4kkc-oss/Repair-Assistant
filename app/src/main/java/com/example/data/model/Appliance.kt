package com.example.data.model

data class City(
    val id: String,
    val name: String,
    val state: String,
    val multiplier: Float
) {
    companion object {
        val ALL = listOf(
            City("lucknow", "Lucknow", "Uttar Pradesh", 1.0f),
            City("delhi", "Delhi NCR", "National Capital", 1.15f),
            City("mumbai", "Mumbai", "Maharashtra", 1.25f),
            City("bengaluru", "Bengaluru", "Karnataka", 1.20f),
            City("kolkata", "Kolkata", "West Bengal", 1.05f),
            City("tier2", "Chhota Shehar / Kasba", "Tier-2/3 Town", 0.90f)
        )
        val DEFAULT = ALL[0]
    }
}

data class Cause(
    val name: String,
    val minCost: Int,
    val maxCost: Int,
    val techRequired: Boolean,
    val tip: String,
    val partsEstimate: String = ""
) {
    fun calculateAdjustedMin(multiplier: Float): Int =
        if (minCost == 0) 0 else ((minCost * multiplier) / 10).toInt() * 10

    fun calculateAdjustedMax(multiplier: Float): Int =
        if (maxCost == 0) 0 else ((maxCost * multiplier + 9) / 10).toInt() * 10
}

data class Problem(
    val id: String,
    val title: String,
    val keywords: String,
    val urgent: Boolean = false,
    val causes: List<Cause>,
    val symptomDescription: String = ""
) {
    fun getOverallRange(multiplier: Float): Pair<Int, Int> {
        val lo = causes.minOfOrNull { it.calculateAdjustedMin(multiplier) } ?: 0
        val hi = causes.maxOfOrNull { it.calculateAdjustedMax(multiplier) } ?: 0
        return Pair(lo, hi)
    }

    val hasTechRequired: Boolean
        get() = causes.any { it.techRequired }
}

data class Appliance(
    val id: String,
    val name: String,
    val icon: String,
    val hindiName: String,
    val safetyNote: String,
    val problems: List<Problem>
)

data class SearchResult(
    val appliance: Appliance,
    val problem: Problem,
    val score: Int
)
