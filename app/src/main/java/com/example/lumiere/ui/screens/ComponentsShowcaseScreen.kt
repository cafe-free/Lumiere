package com.example.lumiere.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lumiere.ui.components.*
import com.example.lumiere.ui.theme.*

@Composable
fun ComponentsShowcaseScreen(
    onOpenModalSheet: () -> Unit
) {
    var buttonFeedback by remember { mutableStateOf("Tap any button to test tactile feedback") }
    var selectedMoods by remember { mutableStateOf(setOf("Serene", "Reflective")) }
    var isAudioActive by remember { mutableStateOf(false) }
    var customBubbleText by remember { mutableStateOf("Holding space for your thoughts.") }
    var cadenceSpeed by remember { mutableFloatStateOf(1.0f) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCanvas),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        // Section: Header
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "Seraphic Components",
                    style = MaterialTheme.typography.headlineLarge,
                    color = DeepSlate
                )
                Text(
                    text = "A tactile catalog of warm, non-judgmental Android UI elements adhering strictly to DESIGN.md.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MutedTypography
                )
            }
        }

        // Section 1: Buttons
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "1. Buttons & Tactile Actions",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Pill silhouettes (height 52dp) with spring scale physics (0.98x) on touch.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                // Primary Button
                LumierePrimaryButton(
                    text = "Primary Indigo Action",
                    icon = Icons.Default.Spa,
                    onClick = {
                        buttonFeedback = "Primary Button triggered with 0.98x spring feedback!"
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Secondary / Soft Button
                LumiereSecondaryButton(
                    text = "Secondary Soft Iris Action",
                    icon = Icons.Default.FavoriteBorder,
                    onClick = {
                        buttonFeedback = "Secondary Soft Iris Button triggered (Zero border, #EEF2FF fill)."
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Ghost Button
                LumiereGhostButton(
                    text = "Ghost / Tertiary Action",
                    icon = Icons.AutoMirrored.Filled.ArrowForward,
                    onClick = {
                        buttonFeedback = "Ghost Button tapped (Transparent fill, muted slate typography)."
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Floating Audio Button Demo
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Floating Audio Pill",
                            style = MaterialTheme.typography.labelLarge,
                            color = DeepSlate
                        )
                        Text(
                            text = if (isAudioActive) "Active: Sunrise micro-gradient" else "Idle: Electric Indigo",
                            style = MaterialTheme.typography.bodySmall,
                            color = MutedTypography
                        )
                    }
                    LumiereFloatingAudioButton(
                        isListening = isAudioActive,
                        onClick = {
                            isAudioActive = !isAudioActive
                            buttonFeedback = if (isAudioActive) "Audio mode activated" else "Audio mode in standby"
                        }
                    )
                }

                // Feedback Banner
                Surface(
                    color = SoftIrisSurface,
                    shape = CircleShape,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = buttonFeedback,
                        style = MaterialTheme.typography.labelMedium,
                        color = PrimaryContainer,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                    )
                }
            }
        }

        // Section 2: Conversation Bubbles
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "2. Conversation Bubbles",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Asymmetrical corner radii (24dp base with 8dp directional origin corners). AI responses feature the Sunrise Peach accent line and glowing beacon.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                // User Bubble Demo
                UserBubble(
                    message = "Can we slow down and find peace right here?",
                    timestamp = "User · Just now"
                )

                // Lumière Bubble Demo
                LumiereBubble(
                    message = customBubbleText,
                    timestamp = "Lumière · 9:42 AM",
                    showBeacon = true
                )

                // Secondary variation
                LumiereBubble(
                    message = "Every sensation is welcome. Take one slow breath in, and let your shoulders drop.",
                    timestamp = "Lumière · 9:43 AM",
                    showBeacon = true
                )
            }
        }

        // Section 3: Chips & Mood Selectors
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "3. Chips & Mood Selectors",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Compact 36dp pills. Resting: #FFFFFF + #E2E5EE border. Selected: #FFEDD5 warm sunrise tint with #FDBA74 edge glow.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                val allMoods = listOf(
                    "Serene", "Mindful", "Reflective",
                    "Inspired", "Grateful", "Anxious",
                    "Fatigued", "Creative", "Clarity"
                )

                // Wrapped mood chips grid
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    allMoods.chunked(3).forEach { rowMoods ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowMoods.forEach { mood ->
                                LumiereChip(
                                    text = mood,
                                    isSelected = selectedMoods.contains(mood),
                                    onClick = {
                                        selectedMoods = if (selectedMoods.contains(mood)) {
                                            selectedMoods - mood
                                        } else {
                                            selectedMoods + mood
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                Text(
                    text = "Active selections: ${selectedMoods.joinToString(", ")}",
                    style = MaterialTheme.typography.labelSmall,
                    color = PrimaryContainer
                )
            }
        }

        // Section 4: Voice & Resonance Waves
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "4. Voice & Resonance Wave",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Audio visualization modulating between Electric Indigo (#4F46E5) and Sunrise Peach (#FDBA74) at 30% opacity, pulsing in a calm 0.25Hz breathing cadence.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                // Animated Resonance Wave
                ResonanceWave(
                    isListening = isAudioActive,
                    cadenceSpeed = cadenceSpeed
                )

                // Cadence Speed Controller
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Breathing Cadence: ${String.format("%.2f", 0.25f * cadenceSpeed)} Hz",
                        style = MaterialTheme.typography.labelLarge,
                        color = DeepSlate
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        LumiereChip(
                            text = "Calm (0.25Hz)",
                            isSelected = cadenceSpeed == 1.0f,
                            onClick = { cadenceSpeed = 1.0f }
                        )
                        LumiereChip(
                            text = "Active (0.5Hz)",
                            isSelected = cadenceSpeed == 2.0f,
                            onClick = { cadenceSpeed = 2.0f }
                        )
                    }
                }
            }
        }

        // Section 5: Cards & Elevation Levels
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "5. Cards & Elevation Matrix",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Strict rule from DESIGN.md: Dividers within cards are strictly avoided; spatial separation is achieved purely via 16dp vertical gap steps.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                // Level 0 description
                Surface(
                    color = BackgroundCanvas,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 0 · Canvas", style = MaterialTheme.typography.labelLarge, color = DeepSlate)
                        Text("Non-emissive warm ivory cream (#FFFCF0) eliminating harsh glare.", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    }
                }

                // Level 1 description
                Surface(
                    color = SurfaceContainerLowest,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, SubtleStroke),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 1 · Veiled Resting Cards", style = MaterialTheme.typography.labelLarge, color = DeepSlate)
                        Text("Ambient veil shadow with hairline boundary accent #E2E5EE.", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    }
                }

                // Level 2 trigger
                LumierePrimaryButton(
                    text = "Launch Level 3 Modal Sheet",
                    icon = Icons.Default.Layers,
                    onClick = onOpenModalSheet,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Bottom breathing room
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
