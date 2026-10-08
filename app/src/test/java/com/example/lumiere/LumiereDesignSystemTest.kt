package com.example.lumiere

import androidx.compose.ui.graphics.Color
import com.example.lumiere.ui.theme.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class LumiereDesignSystemTest {

    @Test
    fun verifyDesignColors_seraphicCalm() {
        // Assert color tokens match DESIGN.md
        assertEquals(Color(0xFFFFFCF0), BackgroundCanvas)
        assertEquals(Color(0xFFFFFFFF), SurfaceContainerLowest)
        assertEquals(Color(0xFF4F46E5), PrimaryContainer)
        assertEquals(Color(0xFF4338CA), PrimaryDark)
        assertEquals(Color(0xFFFDBA74), SunrisePeach)
        assertEquals(Color(0xFFFFEDD5), SunrisePeachWarm)
        assertEquals(Color(0xFFEEF2FF), SoftIrisSurface)
        assertEquals(Color(0xFF1A1C24), DeepSlate)
        assertEquals(Color(0xFF767680), MutedTypography)
        assertEquals(Color(0xFFE2E5EE), SubtleStroke)
    }

    @Test
    fun verifyTypography_hierarchy() {
        assertNotNull(LumiereTypography.displayLarge)
        assertNotNull(LumiereTypography.headlineLarge)
        assertNotNull(LumiereTypography.headlineMedium)
        assertNotNull(LumiereTypography.headlineSmall)
        assertNotNull(LumiereTypography.bodyLarge)
        assertNotNull(LumiereTypography.bodyMedium)
        assertNotNull(LumiereTypography.bodySmall)
        assertNotNull(LumiereTypography.labelLarge)
        assertNotNull(LumiereTypography.labelMedium)
        assertNotNull(LumiereTypography.labelSmall)
    }
}
