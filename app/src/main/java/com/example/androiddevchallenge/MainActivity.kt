package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "puppyList",
                builder = {
                    composable(
                        route = Screen.PuppyListScreen.route
                    ) { navBackStackEntry ->

                        val viewModel: MainViewModel = viewModel("MainVM")

                        PuppyListScreen(
                            navFunction = {
                                navController.navigate(it)
                            },
                            list = viewModel.puppyList.value
                        )
                    }

                    composable(
                        route = Screen.PuppyDetailScreen.route + "/{brawlerId}",
                        arguments = listOf(navArgument("brawlerId"){
                            type = NavType.IntType
                        })
                    ) { navBackStackEntry ->
                        PuppyDetailScreen(
                            puppyId = navBackStackEntry.arguments?.getInt("brawlerId")
                        )
                    }
                }
            )

        }
    }
}