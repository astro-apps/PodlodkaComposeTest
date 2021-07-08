package ru.astroapps.podlodkacomposetest.screen.element

import androidx.compose.foundation.Image
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import ru.astroapps.podlodkacomposetest.R
import ru.astroapps.podlodkacomposetest.model.SessionUI

@Composable
fun FavoriteButton(session: SessionUI, onFavClick: (SessionUI) -> Unit) {
    IconButton(onClick = {
        onFavClick(session)
    }) {
        Image(
            painterResource(id = if (session.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border),
            contentDescription = "Favorite",
            colorFilter = ColorFilter.tint(if (session.isFavorite) Color.Red else Color.Gray)
        )
    }
}
