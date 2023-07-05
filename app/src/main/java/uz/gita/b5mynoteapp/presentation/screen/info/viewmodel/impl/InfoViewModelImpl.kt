package uz.gita.b5mynoteapp.presentation.screen.info.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.presentation.screen.info.viewmodel.InfoViewModel

class InfoViewModelImpl : InfoViewModel, ViewModel() {
    override val openHomeScreenLiveData = MutableLiveData<Unit>()

    override fun clickBackButton() {
        openHomeScreenLiveData.value = Unit
    }
}