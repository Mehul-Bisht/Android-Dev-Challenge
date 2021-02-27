package com.example.androiddevchallenge

sealed class Screen(
    val route: String
){

    object PuppyListScreen: Screen("puppyList")

    object PuppyDetailScreen: Screen("puppyDetail")

}
