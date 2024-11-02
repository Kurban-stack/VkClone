package com.example.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object VkCloneTheme {
    val typography: VkCloneTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalVkCloneTypography.current

    val dimens: VkCloneDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalVkCloneDimens.current

    val shapes: VkCloneShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalVkCloneShapes.current

    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme
}
val LocalVkCloneTypography = staticCompositionLocalOf {
    VkCloneTypography()
}

val LocalVkCloneDimens = staticCompositionLocalOf {
    VkCloneDimens()
}

val LocalVkCloneShapes = staticCompositionLocalOf {
    VkCloneShapes()
}
