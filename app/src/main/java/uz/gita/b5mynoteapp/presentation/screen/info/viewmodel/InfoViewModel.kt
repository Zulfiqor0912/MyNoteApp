package uz.gita.b5mynoteapp.presentation.screen.info.viewmodel

import androidx.lifecycle.LiveData

interface InfoViewModel {
    val openHomeScreenLiveData: LiveData<Unit>

    fun clickBackButton()
}