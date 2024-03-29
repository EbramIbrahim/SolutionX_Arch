package com.example.solutionxarch.features.login.presentation

sealed interface UserLoginEvent {

    object LoginWithEmail: UserLoginEvent
    object LoginWithPhone: UserLoginEvent
    object LoginWithSocial: UserLoginEvent
}