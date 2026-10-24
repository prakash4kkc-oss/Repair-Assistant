package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AccentGold,
    onPrimary = InkPrimaryDark,
    primaryContainer = InkSurfaceVariant,
    onPrimaryContainer = AccentGoldLight,
    secondary = AccentGoldLight,
    onSecondary = InkPrimaryDark,
    secondaryContainer = InkSurface,
    onSecondaryContainer = TextLight,
    tertiary = DiyGreenLight,
    onTertiary = InkPrimaryDark,
    error = SafetyRedLight,
    onError = Color.Black,
    errorContainer = Color(0xFF4E1614),
    onErrorContainer = SafetyRedLight,
    background = BackgroundDark,
    onBackground = TextLight,
    surface = PaperDark,
    onSurface = TextLight,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextMutedDark,
    outline = OutlineDark,
    outlineVariant = Color(0xFF385058)
)

private val LightColorScheme = lightColorScheme(
    primary = InkPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD6E4E2),
    onPrimaryContainer = InkPrimary,
    secondary = AccentGold,
    onSecondary = InkPrimary,
    secondaryContainer = Color(0xFFFFF4D1),
    onSecondaryContainer = Color(0xFF6B4E00),
    tertiary = DiyGreen,
    onTertiary = Color.White,
    error = SafetyRed,
    onError = Color.White,
    errorContainer = SafetyRedContainer,
    onErrorContainer = SafetyRed,
    background = BackgroundLight,
    onBackground = TextDark,
    surface = PaperLight,
    onSurface = TextDark,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = TextMutedLight,
    outline = OutlineLight,
    outlineVariant = Color(0xFFB0C0BD)
)

@Composable
fun RepairAssistantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
