package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AccentGold
import com.example.ui.theme.DiyGreen
import com.example.ui.theme.DiyGreenContainer
import com.example.ui.theme.InkPrimary
import com.example.ui.theme.SafetyRed
import com.example.ui.theme.SafetyRedContainer

@Composable
fun RepairVsBuyCalculatorScreen(
    initialRepairCost: Int = 0,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    var repairCostInput by remember { mutableStateOf(if (initialRepairCost > 0) "$initialRepairCost" else "800") }
    var newPriceInput by remember { mutableStateOf("2500") }
    var applianceAgeYears by remember { mutableStateOf("3") }

    val repairCost = repairCostInput.toIntOrNull() ?: 0
    val newPrice = newPriceInput.toIntOrNull() ?: 0
    val age = applianceAgeYears.toIntOrNull() ?: 0

    val costRatioPercent = if (newPrice > 0) ((repairCost.toFloat() / newPrice.toFloat()) * 100).toInt() else 0

    val recommendation = when {
        newPrice == 0 || repairCost == 0 -> "Donon keemat daalein"
        costRatioPercent > 50 -> "Naya khareedna samajhdari hai"
        costRatioPercent > 35 && age >= 5 -> "Naya lene par vichar karein (purani machine hai)"
        else -> "Repair karwana faydemand hai"
    }

    val isRepairRecommended = costRatioPercent <= 50 && !(costRatioPercent > 35 && age >= 5)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("repair_calculator_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = InkPrimary)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = null,
                            tint = AccentGold,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Repair vs Naya Upkaran Calculator",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = androidx.compose.ui.graphics.Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "50% Niyam (The 50% Rule): Agar repair ka kharcha naye upkaran ke 50% se zyada ho, ya machine bahut purani ho, to theek karwane ke bajaye naya lena sasta padta hai.",
                        style = MaterialTheme.typography.bodySmall,
                        color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.85f),
                        lineHeight = 18.sp
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Aapka Andaaza Likhein:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = repairCostInput,
                        onValueChange = { repairCostInput = it },
                        label = { Text("Repair ka kharcha (₹)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("calc_repair_cost_input"),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = newPriceInput,
                        onValueChange = { newPriceInput = it },
                        label = { Text("Naye upkaran ka daam (₹)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("calc_new_price_input"),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = applianceAgeYears,
                        onValueChange = { applianceAgeYears = it },
                        label = { Text("Aapka upkaran kitna purana hai (Saal / Years)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("calc_age_input"),
                        singleLine = true,
                        shape = RoundedCornerShape(8.dp)
                    )
                }
            }
        }

        // Result Card
        item {
            val statusColor = if (isRepairRecommended) DiyGreen else SafetyRed
            val statusBg = if (isRepairRecommended) DiyGreenContainer else SafetyRedContainer

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("calculator_result_card"),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = statusBg),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, statusColor.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isRepairRecommended) Icons.Default.CheckCircle else Icons.Default.Warning,
                            contentDescription = null,
                            tint = statusColor,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Salah (Recommendation)",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = statusColor
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = recommendation,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = statusColor
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Repair cost naye upkaran ka $costRatioPercent% hai (Umr: $age saal).",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (isRepairRecommended) {
                            "Kharcha naye upkaran ke 50% se kafi kam hai. Isliye mistri se theek karwana zyada kifayati rahega."
                        } else {
                            "Zyada purana appliance theek karwane ke baad doosra part kharab hone ka khatra rehta hai. Naye upkaran me energy efficiency aur 2-5 saal ki brand warranty bhi milegi."
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}
