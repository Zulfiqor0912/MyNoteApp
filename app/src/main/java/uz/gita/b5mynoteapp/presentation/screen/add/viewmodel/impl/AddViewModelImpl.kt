package uz.gita.b5mynoteapp.presentation.screen.add.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl
import uz.gita.b5mynoteapp.presentation.screen.add.viewmodel.AddViewModel

class AddViewModelImpl : AddViewModel, ViewModel() {
    private val repository: Repository = RepositoryIMpl.instance()

    override fun clickSaveButton(note: NoteEntity) {
        repository.addNote(note)
        homeScreenLiveData.value = Unit
    }

    override fun clickBackButton() {
        homeScreenLiveData.value = Unit
    }

    override fun clickChangeColorButton() {
        openChangeColor.value = Unit
    }


    override val homeScreenLiveData = MutableLiveData<Unit>()

    override val openChangeColor = MutableLiveData<Unit>()

}