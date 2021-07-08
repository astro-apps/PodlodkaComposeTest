package ru.astroapps.podlodkacomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.astroapps.podlodkacomposetest.screen.MainScreen
import ru.astroapps.podlodkacomposetest.screen.SpeakerScreen
import ru.astroapps.podlodkacomposetest.ui.theme.PodlodkaComposeTestTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodlodkaComposeTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController, mainViewModel)
                        }
                        composable("speaker/{id}") { backStackEntry ->
                            backStackEntry.arguments?.getString("id")?.let { id ->
                                SpeakerScreen(mainViewModel.getSession(id))
                            }
                        }
                    }
                }
            }
        }
    }
}
