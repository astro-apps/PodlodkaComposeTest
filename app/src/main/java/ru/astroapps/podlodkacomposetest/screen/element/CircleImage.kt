package ru.astroapps.podlodkacomposetest.screen.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun CircleImage(url: String, size: Dp) {
    Image(
        painter = rememberCoilPainter(request = url),
        contentDescription = "Image",
        modifier = Modifier
            .size(size)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}
