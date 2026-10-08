package com.example.lumiere.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.lumiere.ui.components.EmpathicModalSheet
import com.example.lumiere.ui.components.LumierePrimaryButton
import com.example.lumiere.ui.components.LumiereSecondaryButton
import com.example.lumiere.ui.theme.*

enum class ShowcaseTab(
    val title: String,
    val icon: ImageVector
) {
    COMPANION("Companion", Icons.Default.Spa),
    COMPONENTS("Components", Icons.Default.Widgets),
    DESIGN_SYSTEM("Design Tokens", Icons.Default.Palette)
}

@Composable
fun MainShowcaseApp() {
    var currentTab by remember { mutableStateOf(ShowcaseTab.COMPANION) }
    var isModalSheetVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCanvas)
    ) {
        // Main Screen Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 76.dp) // Leave space for floating navigation capsule
        ) {
            when (currentTab) {
                ShowcaseTab.COMPANION -> {
                    LumiereCompanionScreen(
                        onNavigateSettings = { isModalSheetVisible = true }
                    )
                }
                ShowcaseTab.COMPONENTS -> {
                    ComponentsShowcaseScreen(
                        onOpenModalSheet = { isModalSheetVisible = true }
                    )
                }
                ShowcaseTab.DESIGN_SYSTEM -> {
                    DesignSystemScreen()
                }
            }
        }

        // Floating Seraphic Navigation Capsule Dock (Level 2 Elevation)
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp, vertical = 14.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .shadow(
                        elevation = 12.dp,
                        shape = CircleShape,
                        spotColor = Color(0x144F46E5) // Level 2 indigo-tinted shadow
                    ),
                color = SurfaceContainerLowest,
                shape = CircleShape,
                border = BorderStroke(1.dp, SubtleStroke)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ShowcaseTab.entries.forEach { tab ->
                        val isSelected = currentTab == tab
                        Surface(
                            modifier = Modifier
                                .clickable { currentTab = tab },
                            color = if (isSelected) SoftIrisSurface else Color.Transparent,
                            shape = CircleShape
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = tab.title,
                                    tint = if (isSelected) PrimaryContainer else MutedTypography,
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = tab.title,
                                    style = MaterialTheme.typography.labelLarge,
                                    color = if (isSelected) PrimaryContainer else MutedTypography
                                )
                            }
                        }
                    }
                }
            }
        }

        // Level 3 Empathic Modal Sheet Overlay
        EmpathicModalSheet(
            visible = isModalSheetVisible,
            onDismiss = { isModalSheetVisible = false },
            title = "Lumière Experience Sanctuary"
        ) {
            Text(
                text = "Warm Seraphic Minimalism",
                style = MaterialTheme.typography.headlineSmall,
                color = DeepSlate
            )
            Text(
                text = "This application expresses quiet intelligence, luminous warmth, and non-judgmental presence. Designed as an empathic AI companion for Android, the interface rejects cold, hyper-analytical computational motifs in favor of an ethereal, calm, and deeply human sanctuary.",
                style = MaterialTheme.typography.bodyLarge,
                color = OnSurfaceVariant
            )

            Surface(
                color = SoftIrisSurface,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "DESIGN.md Compliance Checklist",
                        style = MaterialTheme.typography.labelLarge,
                        color = DeepSlate
                    )
                    Text("✓ Background Canvas: Warm Ivory (#FFFCF0)", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    Text("✓ Accent Gradients: Electric Indigo (#4F46E5) & Sunrise Peach (#FDBA74)", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    Text("✓ Radii: 24dp card curvature, 9999px pill interactive elements", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    Text("✓ Card Rule: Strictly no internal dividers (16dp vertical spacing steps)", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    Text("✓ Voice Wave: 0.25Hz serene breathing cadence with 30% cubic beziers", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    Text("✓ Typography: Plus Jakarta Sans hierarchy with expanded line heights", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                }
            }

            LumierePrimaryButton(
                text = "Return to Companion",
                onClick = { isModalSheetVisible = false },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
