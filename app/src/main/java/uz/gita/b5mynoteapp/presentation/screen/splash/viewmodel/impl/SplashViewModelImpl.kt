package uz.gita.b5mynoteapp.presentation.screen.splash.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.presentation.screen.splash.viewmodel.SplashViewModel

class SplashViewModelImpl : SplashViewModel, ViewModel() {
    override fun openHomeScreen() {
        openHomeLiveData.value = Unit
    }

    override val openHomeLiveData = MutableLiveData<Unit>()
}