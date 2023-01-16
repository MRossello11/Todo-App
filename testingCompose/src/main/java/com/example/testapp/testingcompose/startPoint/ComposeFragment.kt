package com.example.testapp.testingcompose.startPoint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.testingcompose.feature_todos.presentation.todos.TodosScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testapp.testingcompose.common.Screen
import com.example.testapp.testingcompose.feature_todo.presentation.view.TodoScreen

class ComposeFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.TodosScreen.route
                ) {
                    composable(route = Screen.TodosScreen.route) {
                        TodosScreen(navController = navController)
                    }
                    composable(
                        route = Screen.TodoScreen.route +
                                "?id={id}",
                        arguments = listOf(
                            navArgument(
                                name = "id"
                            ) {
                                type = NavType.StringType
                                defaultValue = "a"
                            }
                        )
                    ){
                        val id = it.arguments?.getString("id") ?: "a"
                        TodoScreen(
                            navController = navController,
                            id = id
                        )
                    }
                }
            }
        }
    }
}