package ru.astroapps.podlodkacomposetest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SessionUI(
    val id: String,
    val speaker: String,
    val date: String,
    val timeInterval: String,
    val description: String,
    val imageUrl: String,
    var isFavorite: Boolean
) : Parcelable
