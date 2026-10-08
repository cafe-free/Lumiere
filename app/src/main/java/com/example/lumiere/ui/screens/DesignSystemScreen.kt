package com.example.lumiere.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.lumiere.ui.components.LumiereCard
import com.example.lumiere.ui.theme.*

data class ColorTokenItem(
    val name: String,
    val hex: String,
    val color: Color,
    val role: String,
    val isLight: Boolean = true
)

@Composable
fun DesignSystemScreen() {
    val colorTokens = listOf(
        ColorTokenItem("Background Canvas", "#FFFCF0", BackgroundCanvas, "Ivory backdrop, non-emissive comfort", true),
        ColorTokenItem("Surface Layer", "#FFFFFF", SurfaceContainerLowest, "Pure optic white for cards & bubbles", true),
        ColorTokenItem("Primary Container", "#4F46E5", PrimaryContainer, "Electric Indigo: cognitive clarity & primary CTAs", false),
        ColorTokenItem("Primary Dark", "#4338CA", PrimaryDark, "Interactive press state for primary CTAs", false),
        ColorTokenItem("Sunrise Peach", "#FDBA74", SunrisePeach, "Empathic warmth, voice waves & beacons", true),
        ColorTokenItem("Sunrise Warm Tint", "#FFEDD5", SunrisePeachWarm, "Selected mood chip surface", true),
        ColorTokenItem("Soft Iris Surface", "#EEF2FF", SoftIrisSurface, "Tinted neutral for secondary actions & chips", true),
        ColorTokenItem("Deep Slate", "#1A1C24", DeepSlate, "Primary typography: softens black glare", false),
        ColorTokenItem("Muted Slate", "#767680", MutedTypography, "Timestamps, metadata, placeholder copy", false),
        ColorTokenItem("Subtle Stroke", "#E2E5EE", SubtleStroke, "Hairline 1dp boundary accents", true),
        ColorTokenItem("Primary Fixed Halo", "#E2DFFF", PrimaryFixed, "Radiant orb outer ambient veil", true),
        ColorTokenItem("Secondary Fixed Dim", "#FCB973", SecondaryFixedDim, "Radiant orb mid emotional aura", true)
    )

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
                    text = "Design Tokens",
                    style = MaterialTheme.typography.headlineLarge,
                    color = DeepSlate
                )
                Text(
                    text = "Seraphic Calm specifications according to DESIGN.md. Quiet intelligence, luminous warmth, and non-judgmental presence.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MutedTypography
                )
            }
        }

        // Section 1: Color Palette
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "1. Color Tokens & Emotional Gradients",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Luminous cream and warm ivory backdrops balanced by Electric Indigo and Sunrise Peach.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    colorTokens.forEach { token ->
                        Surface(
                            color = SurfaceContainerLowest,
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(1.dp, SubtleStroke),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                            ) {
                                // Color swatch
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(token.color)
                                        .border(1.dp, SubtleStroke, RoundedCornerShape(12.dp))
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = token.name,
                                            style = MaterialTheme.typography.labelLarge,
                                            color = DeepSlate
                                        )
                                        Text(
                                            text = token.hex,
                                            style = MaterialTheme.typography.labelMedium,
                                            color = PrimaryContainer
                                        )
                                    }
                                    Text(
                                        text = token.role,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MutedTypography
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Section 2: Typography Scale
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "2. Typography Scale (Plus Jakarta Sans)",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Tuned for unhurried reflective rhythm during intimate AI conversations with expanded line heights.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                val typeItems = listOf(
                    Triple("Display Large", "40sp · 48sp LH · -0.02em", MaterialTheme.typography.displayLarge),
                    Triple("Headline Large", "32sp · 40sp LH · -0.015em", MaterialTheme.typography.headlineLarge),
                    Triple("Headline Large Mobile", "26sp · 34sp LH · -0.01em", HeadlineLgMobile),
                    Triple("Headline Medium", "22sp · 28sp LH · -0.01em", MaterialTheme.typography.headlineMedium),
                    Triple("Headline Small", "18sp · 24sp LH", MaterialTheme.typography.headlineSmall),
                    Triple("Body Large", "16sp · 26sp LH · Reflective rhythm", MaterialTheme.typography.bodyLarge),
                    Triple("Body Medium", "15sp · 24sp LH · Core copy", MaterialTheme.typography.bodyMedium),
                    Triple("Body Small", "13sp · 20sp LH · Captions", MaterialTheme.typography.bodySmall),
                    Triple("Label Large", "14sp · 20sp LH · Buttons & Tabs", MaterialTheme.typography.labelLarge),
                    Triple("Label Medium", "12sp · 16sp LH · Chips", MaterialTheme.typography.labelMedium),
                    Triple("Label Small", "11sp · 14sp LH · Metadata", MaterialTheme.typography.labelSmall)
                )

                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    typeItems.forEach { (name, meta, style) ->
                        Surface(
                            color = SoftIrisSurface.copy(alpha = 0.4f),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = meta,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MutedTypography
                                )
                                Text(
                                    text = name,
                                    style = style,
                                    color = DeepSlate
                                )
                            }
                        }
                    }
                }
            }
        }

        // Section 3: Elevation & Depth Architecture
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "3. Elevation & Depth Architecture",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Rejects harsh drop shadows in favor of soft luminance differences and ambient dispersion.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                // Level 0
                Surface(
                    color = BackgroundCanvas,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, SubtleStroke),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 0: Canvas", style = MaterialTheme.typography.labelLarge, color = DeepSlate)
                        Text("Background ivory tint (#FFFCF0). Non-emissive, eye-soothing.", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    }
                }

                // Level 1
                Surface(
                    color = SurfaceContainerLowest,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, SubtleStroke),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, RoundedCornerShape(16.dp), spotColor = Color(0x0A1A1C24))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 1: Resting Cards & Bubbles", style = MaterialTheme.typography.labelLarge, color = DeepSlate)
                        Text("Elevated optic white (#FFFFFF) with ambient veil and 1dp #E2E5EE stroke.", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    }
                }

                // Level 2
                Surface(
                    color = SurfaceContainerLowest,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, SubtleStroke),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(12.dp, RoundedCornerShape(16.dp), spotColor = Color(0x144F46E5))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 2: Floating Action Docks & Menus", style = MaterialTheme.typography.labelLarge, color = DeepSlate)
                        Text("Elevated capsule with tinted indigo warmth shadow (rgba(79, 70, 229, 0.08)).", style = MaterialTheme.typography.bodySmall, color = MutedTypography)
                    }
                }

                // Level 3
                Surface(
                    color = DeepSlate,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Level 3: Modal Sheets & Empathic Overlays", style = MaterialTheme.typography.labelLarge, color = OnPrimary)
                        Text("Deep ambient scrim with soft blurred backdrops preserving meditative context.", style = MaterialTheme.typography.bodySmall, color = OnPrimaryContainer)
                    }
                }
            }
        }

        // Section 4: Shape & Spacing Guidelines
        item {
            LumiereCard {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "4. Spatial & Concentric Shape Rules",
                        style = MaterialTheme.typography.headlineSmall,
                        color = DeepSlate
                    )
                    Text(
                        text = "Organic, protective, human geometry aligned to an 8dp baseline grid.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MutedTypography
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Mobile Baseline Margin", style = MaterialTheme.typography.bodyMedium, color = DeepSlate)
                        Text("20dp (1.25rem)", style = MaterialTheme.typography.labelLarge, color = PrimaryContainer)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Card Corner Radius", style = MaterialTheme.typography.bodyMedium, color = DeepSlate)
                        Text("24dp (1.5rem)", style = MaterialTheme.typography.labelLarge, color = PrimaryContainer)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Inner Sub-Elements Radius", style = MaterialTheme.typography.bodyMedium, color = DeepSlate)
                        Text("16dp / 12dp concentric", style = MaterialTheme.typography.labelLarge, color = PrimaryContainer)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Interactive Full Pills", style = MaterialTheme.typography.bodyMedium, color = DeepSlate)
                        Text("9999px (CircleShape)", style = MaterialTheme.typography.labelLarge, color = PrimaryContainer)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Internal Card Dividers", style = MaterialTheme.typography.bodyMedium, color = DeepSlate)
                        Text("Strictly avoided (16dp gaps)", style = MaterialTheme.typography.labelLarge, color = PrimaryContainer)
                    }
                }
            }
        }

        // Bottom space
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
