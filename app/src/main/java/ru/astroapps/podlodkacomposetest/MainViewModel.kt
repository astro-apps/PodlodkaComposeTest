package ru.astroapps.podlodkacomposetest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.astroapps.podlodkacomposetest.model.MockSessions
import ru.astroapps.podlodkacomposetest.model.Session
import ru.astroapps.podlodkacomposetest.model.SessionUI
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _sessionList: List<Session> = MockSessions
    private fun sessionList(favIds: List<String>): List<SessionUI> = _sessionList.map { session ->
        SessionUI(
            id = session.id,
            speaker = session.speaker,
            date = session.date,
            timeInterval = session.timeInterval,
            description = session.description,
            imageUrl = session.imageUrl,
            isFavorite = favIds.contains(session.id)
        )
    }

    private val favorites = mutableListOf<String>()

    private val _sessionListUI: MutableLiveData<List<SessionUI>> = MutableLiveData(sessionList(favorites))
    val sessionListUI: LiveData<List<SessionUI>> = _sessionListUI

    private val _isFavorite: MutableLiveData<Boolean> = MutableLiveData(false)
    val isFavorite: LiveData<Boolean> = _isFavorite

    private fun canAddToFavorite(): Boolean = favorites.size < 3

    fun toggle(session: SessionUI, limit: () -> Unit) {
        val contains = favorites.contains(session.id)

        if (contains) {
            favorites.remove(session.id)
            _sessionListUI.postValue(sessionList(favorites))
        } else {
            if (canAddToFavorite()) {
                favorites.add(session.id)
                _sessionListUI.postValue(sessionList(favorites))
            } else {
                limit()
            }
        }
        _isFavorite.postValue(favorites.size > 0)
    }

    fun getSession(id: String): Session = _sessionList.first { it.id == id }
}
