package com.example.lumiere.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lumiere.ui.components.*
import com.example.lumiere.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class ShowcaseMessage(
    val id: String,
    val sender: MessageSender,
    val text: String,
    val timestamp: String
)

enum class MessageSender {
    USER,
    LUMIERE
}

@Composable
fun LumiereCompanionScreen(
    onNavigateSettings: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var inputText by remember { mutableStateOf("") }
    var isListening by remember { mutableStateOf(false) }
    var selectedMood by remember { mutableStateOf("Calm") }

    val messages = remember {
        mutableStateListOf(
            ShowcaseMessage(
                id = "1",
                sender = MessageSender.LUMIERE,
                text = "Welcome to your sanctuary. I am here with you. How does your heart feel today?",
                timestamp = "Lumière · 9:41 AM"
            )
        )
    }

    val listState = rememberLazyListState()

    fun sendEmpathicMessage(text: String) {
        if (text.isBlank()) return
        val userMsg = ShowcaseMessage(
            id = System.currentTimeMillis().toString(),
            sender = MessageSender.USER,
            text = text.trim(),
            timestamp = "Just now"
        )
        messages.add(userMsg)
        inputText = ""

        coroutineScope.launch {
            listState.animateScrollToItem(messages.size - 1)
            // Empathic response delay
            delay(1000)
            val replyText = when (selectedMood) {
                "Calm" -> "Breathe deeply. Notice the stillness beneath the movement of thoughts. You are safe here."
                "Ideas" -> "Every thought is a luminous spark. Let's unfold this gently without rushing to certainty."
                "Languages" -> "Words carry emotion and history. How would you like to explore expressing this?"
                "Reflect" -> "Looking backward with kindness gives clarity for moving forward. What stands out most?"
                else -> "I hear you deeply. What does this bring up for you right now?"
            }
            messages.add(
                ShowcaseMessage(
                    id = (System.currentTimeMillis() + 1).toString(),
                    sender = MessageSender.LUMIERE,
                    text = replyText,
                    timestamp = "Lumière · Just now"
                )
            )
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Scaffold(
        containerColor = BackgroundCanvas,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Subtle Persona Indicator with Seraphic beacon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .shadow(2.dp, CircleShape, spotColor = Color(0x14191B23))
                            .background(SurfaceContainerLowest, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .background(
                                    if (isListening) SunrisePeach else PrimaryContainer,
                                    CircleShape
                                )
                        )
                    }
                    Column {
                        Text(
                            text = "Lumière",
                            style = MaterialTheme.typography.labelLarge,
                            color = DeepSlate
                        )
                        Text(
                            text = if (isListening) "Listening intently" else "Seraphic Presence",
                            style = MaterialTheme.typography.labelSmall,
                            color = MutedTypography
                        )
                    }
                }

                // Settings / Info Action
                IconButton(
                    onClick = onNavigateSettings,
                    modifier = Modifier
                        .size(40.dp)
                        .background(SurfaceContainerLowest, CircleShape)
                        .shadow(2.dp, CircleShape, spotColor = Color(0x0A191B23))
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Showcase Settings",
                        tint = OnSurfaceVariant
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Center Stage: Scrollable conversation with Radiant Orb hero header
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    // Center Stage: Radiant Ambient Orb
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RadiantAmbientOrb(
                            isListening = isListening,
                            mood = selectedMood
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Breathing Resonance Wave
                        ResonanceWave(
                            isListening = isListening,
                            cadenceSpeed = if (isListening) 1.5f else 1.0f,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = if (isListening) "Lumière is listening..." else "Lumière is in tranquil resonance",
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurfaceVariant
                        )
                    }
                }

                // Messages stream
                items(messages, key = { it.id }) { msg ->
                    if (msg.sender == MessageSender.USER) {
                        UserBubble(
                            message = msg.text,
                            timestamp = msg.timestamp
                        )
                    } else {
                        LumiereBubble(
                            message = msg.text,
                            timestamp = msg.timestamp
                        )
                    }
                }
            }

            // Bottom Section: Mood Selectors and Floating Input Dock
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                // Interactive Mood Selector Chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
                ) {
                    listOf("Calm", "Ideas", "Languages", "Reflect").forEach { mood ->
                        LumiereChip(
                            text = mood,
                            isSelected = selectedMood == mood,
                            onClick = {
                                selectedMood = mood
                                if (mood != "Calm") {
                                    sendEmpathicMessage("Switching to $mood space.")
                                }
                            }
                        )
                    }
                }

                // Level 2 Floating Input Dock
                InputDock(
                    value = inputText,
                    onValueChange = { inputText = it },
                    onSend = { sendEmpathicMessage(inputText) },
                    isListening = isListening,
                    onToggleListen = { isListening = !isListening },
                    onAttach = {
                        sendEmpathicMessage("I am sharing a gentle contemplation photo.")
                    }
                )
            }
        }
    }
}
