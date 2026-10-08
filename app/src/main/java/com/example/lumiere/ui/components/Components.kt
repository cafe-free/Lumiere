package com.example.lumiere.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumiere.ui.theme.*
import kotlin.math.sin

/**
 * Baseline tokens and shapes according to Seraphic Calm (DESIGN.md)
 */
val PillShape = CircleShape
val CardShape = RoundedCornerShape(24.dp)
val SheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)

// Bubble shapes with directional tails
val UserBubbleShape = RoundedCornerShape(
    topStart = 24.dp,
    topEnd = 24.dp,
    bottomStart = 24.dp,
    bottomEnd = 8.dp
)

val LumiereBubbleShape = RoundedCornerShape(
    topStart = 24.dp,
    topEnd = 24.dp,
    bottomStart = 8.dp,
    bottomEnd = 24.dp
)

// ==========================================
// BUTTONS
// ==========================================

/**
 * Primary Button
 * Filled Electric Indigo (#4F46E5), text #FFFFFF, fully rounded pill,
 * height 52dp, padding 0 24dp. Interactive spring scale feedback (0.98x).
 */
@Composable
fun LumierePrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1.0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "primaryButtonScale"
    )
    val backgroundColor = if (isPressed) PrimaryDark else PrimaryContainer

    Surface(
        modifier = modifier
            .height(52.dp)
            .scale(scale)
            .pointerInput(enabled) {
                if (enabled) {
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            tryAwaitRelease()
                            isPressed = false
                            onClick()
                        }
                    )
                }
            },
        color = if (enabled) backgroundColor else PrimaryFixedDim,
        shape = PillShape,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = OnPrimary,
                    modifier = Modifier
                        .size(18.dp)
                        .padding(end = 6.dp)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = OnPrimary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/**
 * Secondary / Soft Button
 * Soft Iris background (#EEF2FF), text #4F46E5, zero border, same pill silhouette (52dp).
 */
@Composable
fun LumiereSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1.0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "secondaryButtonScale"
    )

    Surface(
        modifier = modifier
            .height(52.dp)
            .scale(scale)
            .pointerInput(enabled) {
                if (enabled) {
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            tryAwaitRelease()
                            isPressed = false
                            onClick()
                        }
                    )
                }
            },
        color = if (isPressed) PrimaryFixed else SoftIrisSurface,
        shape = PillShape,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = PrimaryContainer,
                    modifier = Modifier
                        .size(18.dp)
                        .padding(end = 6.dp)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = PrimaryContainer,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/**
 * Ghost / Tertiary Button
 * Transparent fill, muted text #767680, active highlight in warm ivory tint.
 */
@Composable
fun LumiereGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    var isPressed by remember { mutableStateOf(false) }
    val backgroundColor = if (isPressed) BackgroundCanvas else Color.Transparent

    Surface(
        modifier = modifier
            .height(52.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                        onClick()
                    }
                )
            },
        color = backgroundColor,
        shape = PillShape
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MutedTypography,
                    modifier = Modifier
                        .size(18.dp)
                        .padding(end = 6.dp)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = MutedTypography
            )
        }
    }
}

/**
 * Floating Audio Pill / Button
 */
@Composable
fun LumiereFloatingAudioButton(
    isListening: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val brush = if (isListening) {
        Brush.linearGradient(listOf(SunrisePeach, SecondaryContainer))
    } else {
        Brush.linearGradient(listOf(PrimaryContainer, PrimaryDark))
    }

    Box(
        modifier = modifier
            .size(52.dp)
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                spotColor = if (isListening) Color(0x33FDBA74) else Color(0x294F46E5)
            )
            .background(brush, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isListening) Icons.Default.GraphicEq else Icons.Default.Mic,
            contentDescription = if (isListening) "Listening" else "Voice Input",
            tint = if (isListening) DeepSlate else OnPrimary,
            modifier = Modifier.size(24.dp)
        )
    }
}

// ==========================================
// CHIPS & MOOD SELECTORS
// ==========================================

/**
 * Lumière Chip & Mood Selector
 * Compact pills (36dp height).
 * Unselected: #FFFFFF with 1px solid #E2E5EE border and #767680 text.
 * Selected: warm sunrise tint (#FFEDD5) with #1A1C24 text and subtle #FDBA74 edge glow.
 */
@Composable
fun LumiereChip(
    text: String,
    isSelected: Boolean = false,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    val animatedBackgroundColor by animateColorAsState(
        targetValue = if (isSelected) SunrisePeachWarm else SurfaceContainerLowest,
        label = "chipBg"
    )
    val animatedBorderColor by animateColorAsState(
        targetValue = if (isSelected) SunrisePeach else SubtleStroke,
        label = "chipBorder"
    )
    val animatedTextColor by animateColorAsState(
        targetValue = if (isSelected) DeepSlate else MutedTypography,
        label = "chipText"
    )

    Surface(
        modifier = Modifier
            .height(36.dp)
            .shadow(
                elevation = if (isSelected) 3.dp else 1.dp,
                shape = PillShape,
                spotColor = if (isSelected) Color(0x22FDBA74) else Color(0x0A191B23)
            )
            .clickable(onClick = onClick),
        color = animatedBackgroundColor,
        shape = PillShape,
        border = BorderStroke(1.dp, animatedBorderColor)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = animatedTextColor,
                    modifier = Modifier.size(14.dp)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium,
                color = animatedTextColor,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
            )
        }
    }
}

/**
 * Backward compatibility alias
 */
@Composable
fun lumiereChip(
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    LumiereChip(
        text = text,
        isSelected = false,
        icon = icon,
        onClick = onClick
    )
}

// ==========================================
// CONVERSATION BUBBLES
// ==========================================

/**
 * User Bubble
 * Background #4F46E5, text #FFFFFF, rounded 24dp with trailing bottom corner slightly reduced to 8dp.
 */
@Composable
fun UserBubble(
    message: String,
    modifier: Modifier = Modifier,
    timestamp: String = "Just now"
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Surface(
            modifier = Modifier
                .widthIn(max = 290.dp)
                .shadow(2.dp, UserBubbleShape, spotColor = Color(0x1A4F46E5)),
            color = PrimaryContainer,
            shape = UserBubbleShape
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = OnPrimary,
                modifier = Modifier.padding(horizontal = 18.dp, vertical = 14.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = timestamp,
            style = MaterialTheme.typography.labelSmall,
            color = MutedTypography,
            modifier = Modifier.padding(end = 4.dp)
        )
    }
}

/**
 * Lumière (AI) Bubble
 * Background #FFFFFF, border 1px solid #E2E5EE, text #1A1C24, rounded 24dp
 * with leading bottom corner softened to 8dp. Accompanied by a glowing Sunrise Peach accent line or avatar beacon.
 */
@Composable
fun LumiereBubble(
    message: String,
    modifier: Modifier = Modifier,
    timestamp: String = "Lumière · Just now",
    showBeacon: Boolean = true
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            if (showBeacon) {
                // Empathic Beacon Avatar / Indicator
                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .size(28.dp)
                        .shadow(4.dp, CircleShape, spotColor = Color(0x33FDBA74))
                        .background(
                            brush = Brush.radialGradient(
                                listOf(SunrisePeach, SunrisePeachWarm, SurfaceContainerLowest)
                            ),
                            shape = CircleShape
                        )
                        .border(1.dp, SunrisePeach, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(PrimaryContainer, CircleShape)
                    )
                }
            }

            Column(modifier = Modifier.weight(1f, fill = false)) {
                Surface(
                    modifier = Modifier
                        .widthIn(max = 310.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = LumiereBubbleShape,
                            spotColor = Color(0x0A1A1C24)
                        ),
                    color = SurfaceContainerLowest,
                    shape = LumiereBubbleShape,
                    border = BorderStroke(1.dp, SubtleStroke)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 14.dp)
                    ) {
                        // 2dp glowing Sunrise Peach accent line atop the response
                        Box(
                            modifier = Modifier
                                .width(36.dp)
                                .height(2.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(SunrisePeach, PrimaryContainer.copy(alpha = 0.5f))
                                    ),
                                    shape = CircleShape
                                )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = message,
                            style = MaterialTheme.typography.bodyLarge,
                            color = DeepSlate
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = timestamp,
                    style = MaterialTheme.typography.labelSmall,
                    color = MutedTypography,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

// ==========================================
// INPUT DOCK
// ==========================================

/**
 * Floating Input Dock
 * Capsule resting above bottom navigation. Background #FFFFFF with Level 2 elevation shadow and 1px solid #E2E5EE.
 * Integrated microphone icon button anchored with a warm sunrise micro-gradient when listening.
 */
@Composable
fun InputDock(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onSend: () -> Unit = {},
    isListening: Boolean = false,
    onToggleListen: () -> Unit = {},
    onAttach: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val micBrush = if (isListening) {
        Brush.linearGradient(listOf(SunrisePeach, SecondaryContainer))
    } else {
        Brush.linearGradient(listOf(PrimaryContainer, PrimaryContainer))
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(
                elevation = 12.dp,
                shape = CircleShape,
                spotColor = Color(0x144F46E5) // Level 2 shadow: trace of tinted indigo warmth
            ),
        color = SurfaceContainerLowest,
        shape = CircleShape,
        border = BorderStroke(1.dp, SubtleStroke)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Attachment Icon
            IconButton(
                onClick = onAttach,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Attach Media",
                    tint = OnSurfaceVariant,
                    modifier = Modifier.size(22.dp)
                )
            }

            // Text Input Field
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = if (isListening) "Lumière is listening intently..." else "Talk to Lumière...",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isListening) SunrisePeach else MutedTypography
                    )
                }
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    textStyle = MaterialTheme.typography.bodyMedium.copy(color = DeepSlate),
                    singleLine = true,
                    cursorBrush = SolidColor(PrimaryContainer),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(onSend = { onSend() }),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Right action: Send button if text present, or Mic Button
            if (value.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(PrimaryContainer, CircleShape)
                        .clickable(onClick = onSend),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send",
                        tint = OnPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .shadow(
                            elevation = if (isListening) 4.dp else 0.dp,
                            shape = CircleShape,
                            spotColor = Color(0x40FDBA74)
                        )
                        .background(micBrush, CircleShape)
                        .clickable(onClick = onToggleListen),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isListening) Icons.Default.GraphicEq else Icons.Default.Mic,
                        contentDescription = if (isListening) "Listening" else "Microphone",
                        tint = if (isListening) DeepSlate else OnPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

/**
 * Backward compatibility alias for inputDock
 */
@Composable
fun inputDock() {
    InputDock()
}

// ==========================================
// CARDS & SURFACES
// ==========================================

/**
 * Lumière Card
 * Surfaces rendered in #FFFFFF, 24dp corner radius, 20dp internal padding.
 * Dividers within cards are strictly avoided; spatial separation is achieved purely via 16dp vertical gap steps.
 */
@Composable
fun LumiereCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = CardShape,
                spotColor = Color(0x0A1A1C24) // Level 1 ambient veil
            ),
        color = SurfaceContainerLowest,
        shape = CardShape,
        border = BorderStroke(1.dp, SubtleStroke)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Strictly 16dp spatial separation
        ) {
            content()
        }
    }
}

// ==========================================
// VOICE & RESONANCE WAVE
// ==========================================

/**
 * Resonance Wave
 * Audio visualization modulating between Electric Indigo (#4F46E5) and
 * Sunrise Peach (#FDBA74) at 30% opacity overlays, pulsing in a calm breathing cadence (approx 0.25Hz).
 */
@Composable
fun ResonanceWave(
    isListening: Boolean = true,
    cadenceSpeed: Float = 1.0f,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "resonanceBreathing")
    // 0.25 Hz cadence = 4000ms duration per breathing phase
    val duration = (4000 / cadenceSpeed.coerceAtLeast(0.2f)).toInt()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (2 * Math.PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "phase"
    )
    val amplitudeMultiplier by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = (duration / 2).coerceAtLeast(500), easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "amplitude"
    )

    Canvas(modifier = modifier.fillMaxWidth().height(64.dp)) {
        val width = size.width
        val height = size.height
        val midY = height / 2f
        val points = 80
        val step = width / points

        // Primary Wave: Electric Indigo (#4F46E5) with 30% opacity
        val indigoPath = Path()
        indigoPath.moveTo(0f, midY)
        for (i in 0..points) {
            val x = i * step
            val normalizedX = x / width
            val envelope = sin(normalizedX * Math.PI).toFloat()
            val wave = sin((normalizedX * 4 * Math.PI) + phase).toFloat()
            val y = midY + (wave * 20f * amplitudeMultiplier * envelope * (if (isListening) 1.2f else 0.5f))
            indigoPath.lineTo(x, y)
        }
        drawPath(
            path = indigoPath,
            color = PrimaryContainer.copy(alpha = 0.30f),
            style = Stroke(width = 3.dp.toPx())
        )

        // Secondary Counter-Wave: Sunrise Peach (#FDBA74) with 30% opacity
        val peachPath = Path()
        peachPath.moveTo(0f, midY)
        for (i in 0..points) {
            val x = i * step
            val normalizedX = x / width
            val envelope = sin(normalizedX * Math.PI).toFloat()
            val wave = sin((normalizedX * 3.5 * Math.PI) - phase + 1.2f).toFloat()
            val y = midY + (wave * 16f * amplitudeMultiplier * envelope * (if (isListening) 1.1f else 0.4f))
            peachPath.lineTo(x, y)
        }
        drawPath(
            path = peachPath,
            color = SunrisePeach.copy(alpha = 0.35f),
            style = Stroke(width = 2.5.dp.toPx())
        )
    }
}

/**
 * Radiant Ambient Orb
 * Center Stage visual anchor with translucent tactile layering and breathing pulse
 */
@Composable
fun RadiantAmbientOrb(
    isListening: Boolean = false,
    mood: String = "Calm",
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "orbPulse")
    val breathingScale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "breathingScale"
    )
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.45f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .scale(if (isListening) breathingScale * 1.04f else breathingScale),
        contentAlignment = Alignment.Center
    ) {
        // Outer halo: PrimaryFixed with soft blur
        Box(
            modifier = Modifier
                .size(288.dp)
                .blur(40.dp)
                .background(PrimaryFixed.copy(alpha = glowAlpha), CircleShape)
        )
        // Mid aura: Sunrise Peach with soft blur
        Box(
            modifier = Modifier
                .size(240.dp)
                .blur(24.dp)
                .background(SecondaryFixedDim.copy(alpha = glowAlpha + 0.05f), CircleShape)
        )
        // Layered core pill
        Box(
            modifier = Modifier
                .size(224.dp)
                .shadow(
                    elevation = 24.dp,
                    shape = CircleShape,
                    spotColor = Color(0x1F4F46E5)
                )
                .background(SurfaceContainerLowest.copy(alpha = 0.85f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Heart of Lumière
            Box(
                modifier = Modifier
                    .size(214.dp)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                PrimaryContainer,
                                PrimaryContainer.copy(alpha = 0.95f),
                                PrimaryDark
                            )
                        ),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                // Subtle concentric inner glow
                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    SunrisePeach.copy(alpha = 0.35f),
                                    Color.Transparent
                                )
                            ),
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

// ==========================================
// LEVEL 3: MODAL SHEET OVERLAY
// ==========================================

/**
 * Level 3 Modal Sheet (Empathic Overlay)
 * Deep ambient scrim paired with soft rounded 24dp sheet container
 */
@Composable
fun EmpathicModalSheet(
    visible: Boolean,
    onDismiss: () -> Unit,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    if (visible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepSlate.copy(alpha = 0.35f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onDismiss
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { /* consume click */ }
                    )
                    .shadow(
                        elevation = 24.dp,
                        shape = SheetShape,
                        spotColor = Color(0x291A1C24)
                    ),
                color = SurfaceContainerLowest,
                shape = SheetShape,
                border = BorderStroke(1.dp, SubtleStroke)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Pull Pill Drag Handle
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(36.dp)
                            .height(4.dp)
                            .background(SubtleStroke, CircleShape)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.headlineSmall,
                            color = DeepSlate
                        )
                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .background(SoftIrisSurface, CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = OnSurfaceVariant,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    content()
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
