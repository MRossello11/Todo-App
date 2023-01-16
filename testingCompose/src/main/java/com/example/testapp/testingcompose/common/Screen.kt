package com.example.testapp.testingcompose.common

sealed class Screen(val route: String){
    object TodosScreen: Screen("todos_screen")
    object TodoScreen: Screen("todo_screen")
}