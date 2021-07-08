package ru.astroapps.podlodkacomposetest.screen.element

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection(title: String) {
    Text(
        modifier = Modifier
            .padding(0.dp, 16.dp, 0.dp, 8.dp),
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onSurface
    )
}
