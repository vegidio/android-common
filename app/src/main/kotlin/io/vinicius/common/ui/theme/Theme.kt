package io.vinicius.common.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = lipstickRed,
    onPrimary = white,
    primaryContainer = cosmos,
    onPrimaryContainer = darkMaroon,
    secondary = puce,
    onSecondary = white,
    secondaryContainer = cosmos,
    onSecondaryContainer = sealBrown,
    tertiary = yellowMetal,
    onTertiary = white,
    tertiaryContainer = navajoWhite,
    onTertiaryContainer = graphite,
    error = cornellRed,
    errorContainer = peachSchnapps,
    onError = white,
    onErrorContainer = deepBrown,
    background = milkWhite,
    onBackground = rangoonGreen,
    surface = milkWhite,
    onSurface = rangoonGreen,
    surfaceVariant = palePink,
    onSurfaceVariant = blackCow,
    outline = spicyPink,
    inverseOnSurface = linen,
    inverseSurface = thunder,
    inversePrimary = sundown,
    surfaceTint = lipstickRed
)

private val LightColorScheme = lightColorScheme(
    primary = sundown,
    onPrimary = claret,
    primaryContainer = paprika,
    onPrimaryContainer = cosmos,
    secondary = cavernPink,
    onSecondary = craterBrown,
    secondaryContainer = purpleBrown,
    onSecondaryContainer = cosmos,
    tertiary = brandy,
    onTertiary = deepBronze,
    tertiaryContainer = otterBrown,
    onTertiaryContainer = navajoWhite,
    error = cornflowerLilac,
    errorContainer = bloodRed,
    onError = rosewood,
    onErrorContainer = peachSchnapps,
    background = rangoonGreen,
    onBackground = lavenderPinocchio,
    surface = rangoonGreen,
    onSurface = lavenderPinocchio,
    surfaceVariant = blackCow,
    onSurfaceVariant = pinkFlare,
    outline = warmGrey,
    inverseOnSurface = rangoonGreen,
    inverseSurface = lavenderPinocchio,
    inversePrimary = lipstickRed,
    surfaceTint = sundown
)

@Composable
fun AndroidCommonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}