package com.example.ui.screens

import android.content.Context
import android.content.Intent
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.local.SavedReportEntity
import com.example.data.model.Appliance
import com.example.data.model.City
import com.example.data.model.Problem
import com.example.ui.components.CauseItemCard
import com.example.ui.components.SafetyBanner
import com.example.ui.theme.AccentGold
import com.example.ui.theme.InkPrimary
import com.example.ui.theme.SafetyRed
import com.example.ui.theme.SafetyRedContainer

@Composable
fun DiagnosisDetailScreen(
    appliance: Appliance,
    problem: Problem,
    city: City,
    currentSavedReport: SavedReportEntity?,
    onBack: () -> Unit,
    onToggleSave: (String) -> Unit,
    onOpenCalculator: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }
    val context = LocalContext.current
    var showNoteDialog by remember { mutableStateOf(false) }
    var noteText by remember { mutableStateOf(currentSavedReport?.userNotes ?: "") }

    val range = problem.getOverallRange(city.multiplier)
    val totalCostText = if (range.second == 0) "Muft" else "₹${range.first} se ₹${range.second}"

    if (showNoteDialog) {
        AlertDialog(
            onDismissRequest = { showNoteDialog = false },
            title = {
                Text(
                    text = "Save Diagnosis & Note",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column {
                    Text(
                        text = "Mistri ka quote, dukaan ka naam ya tarikh likhein:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = noteText,
                        onValueChange = { noteText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("save_note_input"),
                        placeholder = { Text("Jaise: Raju electrician se poocha, bola ₹350 lega") },
                        minLines = 3,
                        maxLines = 5
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onToggleSave(noteText)
                        showNoteDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = InkPrimary),
                    modifier = Modifier.testTag("confirm_save_button")
                ) {
                    Text("Save Karein")
                }
            },
            dismissButton = {
                TextButton(onClick = { showNoteDialog = false }) {
                    Text("Radd Karein")
                }
            }
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("diagnosis_detail_screen"),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        // Appliance & Problem Title Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = InkPrimary),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = AccentGold.copy(alpha = 0.2f)
                        ) {
                            Text(
                                text = "${appliance.icon} ${appliance.name} • ${city.name}",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = AccentGold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Row {
                            IconButton(
                                onClick = {
                                    val isSaved = currentSavedReport != null
                                    if (isSaved) {
                                        onToggleSave("")
                                    } else {
                                        showNoteDialog = true
                                    }
                                },
                                modifier = Modifier.testTag("bookmark_toggle_button")
                            ) {
                                Icon(
                                    imageVector = if (currentSavedReport != null) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                    contentDescription = "Save Report",
                                    tint = AccentGold
                                )
                            }

                            IconButton(
                                onClick = {
                                    shareProblemDiagnosis(context, appliance, problem, city, totalCostText)
                                },
                                modifier = Modifier.testTag("share_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "Share Diagnosis",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = problem.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )

                    if (problem.symptomDescription.isNotBlank()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = problem.symptomDescription,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }

        // Safety Precaution
        item {
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                SafetyBanner(
                    title = "Suraksha Niyam (Safety):",
                    message = appliance.safetyNote
                )
            }
        }

        // Urgent Alert if applicable
        if (problem.urgent) {
            item {
                Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                    SafetyBanner(
                        title = "Zaroori Chetawani (Urgent Alert):",
                        message = "Yeh samasya gambhir ya khatarnak ho sakti hai (current ya short circuit ka khatra). Upkaran ko turant band rakhein aur seedha trained technician se sampark karein.",
                        isUrgent = true
                    )
                }
            }
        }

        // Section Title: Sambhavit Kharabiyan
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Sambhavit Kharabiyan (Probable Causes)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Pehle wali zyada aam hain. Har kaaran ki jaanch karke dekhein:",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Causes List
        items(problem.causes) { cause ->
            Box(modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)) {
                CauseItemCard(
                    cause = cause,
                    cityMultiplier = city.multiplier
                )
            }
        }

        // Summary Card (Matching HTML sum box)
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .testTag("cost_summary_card"),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = InkPrimary)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Andaazee Kharcha (${city.name}):",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = totalCostText,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = AccentGold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (problem.hasTechRequired || problem.urgent) {
                            "Agar aasaan jaanch se theek na ho, to technician bulayein."
                        } else {
                            "Zyada tar yeh aap khud ghar par theek kar sakte hain bina kisi kharche ke."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.9f)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = onOpenCalculator,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("compare_buy_button"),
                            colors = ButtonDefaults.buttonColors(containerColor = AccentGold),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Calculate,
                                contentDescription = null,
                                tint = InkPrimary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Repair vs Naya?",
                                fontWeight = FontWeight.Bold,
                                color = InkPrimary
                            )
                        }
                    }
                }
            }
        }

        // Section: Technician kab bulayein?
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Technician Kab Bulayein?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    val points = listOf(
                        "Jalne ki gandh, dhuan ya chingaari dikhai de.",
                        "Body chhoone par current/jhatka lage ya MCB baar-baar gire.",
                        "Ek baar ki simple jaanch ke baad bhi samasya bani rahe.",
                        "Repair ka kharcha naye upkaran ke 50% se zyada ho."
                    )

                    points.forEach { point ->
                        Row(
                            modifier = Modifier.padding(vertical = 4.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "• ",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = point,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 20.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "📌 Technician kaise dhoondhein aur sawal poochhein:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Warranty ho to brand ke authorised service centre jayein, warna Urban Company jaise app ya reputed dukaan. Kaam shuru hone se pehle likhit mein inspection charge aur parts ka andaaza zaroor lein. Kharab part wapas maangein.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun shareProblemDiagnosis(
    context: Context,
    appliance: Appliance,
    problem: Problem,
    city: City,
    costText: String
) {
    val text = """
        🛠️ Repair Assistant Diagnosis
        Upkaran: ${appliance.icon} ${appliance.name}
        Samasya: ${problem.title}
        Shehar: ${city.name}
        Andaazee Kharcha: $costText
        
        Kharabi ke sambhavit kaaran:
        ${problem.causes.mapIndexed { i, c -> "${i + 1}. ${c.name} (${if (c.techRequired) "Technician Zaroori" else "DIY"})" }.joinToString("\n")}
        
        Suraksha: ${appliance.safetyNote}
    """.trimIndent()

    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Repair Assistant - ${problem.title}")
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(Intent.createChooser(intent, "Share Diagnosis via"))
}
