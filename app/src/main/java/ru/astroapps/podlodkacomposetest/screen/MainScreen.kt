package ru.astroapps.podlodkacomposetest.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.astroapps.podlodkacomposetest.MainViewModel
import ru.astroapps.podlodkacomposetest.screen.element.*

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
    val context = LocalContext.current

    val isFav by mainViewModel.isFavorite.observeAsState(initial = false)
    val sessionList by mainViewModel.sessionListUI.observeAsState(initial = emptyList())
    var lastDate by remember { mutableStateOf("") }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        item { SearchBar() }
        if (isFav)
            item {
                Column {
                    HeaderSection(title = "Избранное")
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow {
                        sessionList.forEach { session ->
                            if (session.isFavorite)
                                item {
                                    FavCard(
                                        session = session,
                                        onClick = {
                                            navController.navigate("speaker/${it.id}")
                                        }
                                    )
                                }
                        }
                    }
                }
            }
        item { HeaderSection(title = "Сессии") }

        sessionList.forEach { session ->
            if (lastDate != session.date) {
                item { HeaderDate(date = session.date) }
                lastDate = session.date
            }
            item {
                SessionCard(
                    session = session,
                    onClick = {
                        navController.navigate("speaker/${it.id}")
                    },
                    onFavClick = {
                        mainViewModel.toggle(it) {
                            Toast.makeText(
                                context,
                                "Превышен лимит избранных сессий - 3 сессии!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )
            }
        }
    }
}
