package com.example.core.ui.icons.ic24

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.theme.VkCloneTheme
import com.example.core.ui.icons.Icons

private val iconSize = 24.dp

@Composable
fun Icons.Ic24.PainterTintedIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = VkCloneTheme.colors.primary,
    painter: @Composable Icons.Ic24.() -> Painter,
) {
    Icon(
        painter = painter.invoke(this),
        modifier = modifier.size(iconSize),
        tint = tint,
        contentDescription = contentDescription,
    )
}

val Icons.Ic24.Home: Painter
    @Composable get() = painterResource(R.drawable.ic_home_24)

val Icons.Ic24.Gear: Painter
    @Composable get() = painterResource(R.drawable.ic_gear_24)

val Icons.Ic24.Video: Painter
    @Composable get() = painterResource(R.drawable.ic_video_24)
