package uz.gita.b5mynoteapp.presentation.screen.archive.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl
import uz.gita.b5mynoteapp.presentation.screen.archive.viewmodel.ArchiveViewModel

class ArchiveViewModelImpl : ArchiveViewModel, ViewModel() {
    private val repository: Repository = RepositoryIMpl.instance()
    override fun clickUnArchive(noteEntity: NoteEntity) {
        repository.offArchive(noteEntity.id)
    }

    override fun clickBackButton() {
        openHomeScreenLiveData.value = Unit
    }

    override val openHomeScreenLiveData = MutableLiveData<Unit>()
    override val archiveNotesLiveData = repository.getAllOnArchive()

}