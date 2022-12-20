package podbook.core.ui.designsystem

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun PodbookTheme(
    useDarkColors: Boolean = isSystemInDarkTheme(),
    disableDynamicTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (!disableDynamicTheme && supportsDynamicTheming()) {
        val context = LocalContext.current
        if (useDarkColors) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (useDarkColors) PodbookDarkColors else PodbookLightColors
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
