package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.SafetyBanner
import com.example.ui.theme.AccentGold
import com.example.ui.theme.InkPrimary
import com.example.ui.theme.SafetyRed

@Composable
fun SafetyGuideScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBack() }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("safety_guide_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            SafetyBanner(
                title = "Gharelu Bijli Suraksha (Safety First Rules)",
                message = "Bijli ke upkaran ki jaanch karte waqt hamesha satark rahein. Chhoti si laparwahi se current lag sakta hai ya aag lag sakti hai.",
                isUrgent = true
            )
        }

        item {
            GuideCard(
                icon = "⚡",
                title = "1. Golden Rule: Switch & Plug",
                points = listOf(
                    "Kisi bhi upkaran ko kholne ya saaf karne se pehle uska main switch band karein aur socket se plug bahar nikaalein.",
                    "Sirf switch band karna kaafi nahi hota, kabhi-kabhi neutral switch me hone se phase taar me current bana rehta hai.",
                    "Stool ya chhat ke fan par kaam karte waqt MCB ya mains band kar lein."
                )
            )
        }

        item {
            GuideCard(
                icon = "💧",
                title = "2. Paani aur Bijli (Cooler, Geyser, RO)",
                points = listOf(
                    "Geele pair ya geele haathon se cooler ya kisi bhi metal machine ko na chhuyein.",
                    "Cooler mein 3-pin plug aur earthing zaroori hai. Body me current lage to cooler band karein aur tester se check karein.",
                    "Cooler me paani bharte waqt hamesha plug nikaal kar paani bharein."
                )
            )
        }

        item {
            GuideCard(
                icon = "🔋",
                title = "3. Mobile Battery Suraksha",
                points = listOf(
                    "Phooli hui (swollen) battery ko kabhi dabayein ya sui/blade se na chedein. Isme aag lag sakti hai.",
                    "Phone paani me gir jaye to use switch on ya charge me bilkul na lagayein.",
                    "Local saste charger se bachein jo over-voltage aur battery blast ka kaaran bante hain."
                )
            )
        }

        item {
            GuideCard(
                icon = "🧯",
                title = "4. Microwave aur Fan Capacitor",
                points = listOf(
                    "Microwave ke andar ka High Voltage capacitor band hone par bhi 2000+ volts charge rakhta hai. Khud kabhi na kholein.",
                    "Ceiling fan ka capacitor badalte waqt dono taaron ko aapas me chhua kar pehle discharge karein, fir haath lagayein.",
                    "Kharab capacitor fatne ya usme se liquid nikalne par saaf kapde se pakdein."
                )
            )
        }

        item {
            GuideCard(
                icon = "🚨",
                title = "5. MCB baar-baar girti ho to kya karein?",
                points = listOf(
                    "MCB tabhi girti hai jab koi taar short ho ya appliance me overload ho.",
                    "Zabardasti MCB ko upar na udayein. Pehle saare kamre ke bhari upkaran unplug karein aur ek-ek karke chalaakar check karein ki kaunsa appliance trip kara raha hai."
                )
            )
        }
    }
}

@Composable
private fun GuideCard(
    icon: String,
    title: String,
    points: List<String>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = icon, fontSize = 22.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            points.forEach { pt ->
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
                        text = pt,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}
