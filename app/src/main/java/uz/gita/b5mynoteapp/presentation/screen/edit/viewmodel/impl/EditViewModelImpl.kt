package uz.gita.b5mynoteapp.presentation.screen.edit.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl
import uz.gita.b5mynoteapp.presentation.screen.edit.viewmodel.EditViewModel

class EditViewModelImpl : EditViewModel, ViewModel() {
    private val repository: Repository = RepositoryIMpl.instance()
    override val openHomeScreenLiveData = MutableLiveData<Unit>()
    override val openChangeColor = MutableLiveData<Unit>()

    override fun clickSaveButton(note: NoteEntity) {
        repository.updateNote(note)
        openHomeScreenLiveData.value = Unit
    }

    override fun clickBackButton() {
        openHomeScreenLiveData.value = Unit
    }

    override fun clickChangeColorButton() {
        openChangeColor.value = Unit
    }
}