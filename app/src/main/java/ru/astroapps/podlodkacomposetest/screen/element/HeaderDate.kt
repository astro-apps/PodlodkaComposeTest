package ru.astroapps.podlodkacomposetest.screen.element

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderDate(date: String) {
    Text(
        modifier = Modifier
            .padding(0.dp, 16.dp, 0.dp, 8.dp),
        text = date,
        fontSize = 20.sp,
        color = MaterialTheme.colors.onSurface
    )
}
