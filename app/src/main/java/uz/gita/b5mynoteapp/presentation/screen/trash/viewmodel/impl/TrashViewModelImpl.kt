package uz.gita.b5mynoteapp.presentation.screen.trash.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl
import uz.gita.b5mynoteapp.presentation.screen.trash.viewmodel.TrashViewModel

class TrashViewModelImpl : TrashViewModel, ViewModel() {
    private val repository: Repository = RepositoryIMpl.instance()

    override fun clickTrashButton(noteEntity: NoteEntity) {
        repository.offTrash(noteEntity.id)
    }

    override fun clickBackButton() {
        openHomeLiveData.value = Unit
    }

    override fun clickClearButton() {
        repository.clearInTrash()
        clearLiveData.value = Unit
    }

    override val clearLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val getAllTrashNotesLiveData = repository.getAllOnTrash()
}