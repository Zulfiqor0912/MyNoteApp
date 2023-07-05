package uz.gita.b5mynoteapp.presentation.screen.splash.viewmodel

import androidx.lifecycle.LiveData

interface SplashViewModel {
    fun openHomeScreen()

    val openHomeLiveData: LiveData<Unit>
}