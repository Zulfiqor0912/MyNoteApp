package uz.gita.b5mynoteapp.presentation.screen.home.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl
import uz.gita.b5mynoteapp.presentation.screen.home.viewmodel.HomeViewModel

class HomeViewModelImpl : HomeViewModel, ViewModel() {
    private val repository: Repository = RepositoryIMpl.instance()

    override val allNotesLiveData: LiveData<List<NoteEntity>> = repository.getNotes()
    override val addScreenLiveData = MutableLiveData<Unit>()
    override val moreDialogLiveData = MutableLiveData<NoteEntity>()
    override val menuLiveData = MutableLiveData<Unit>()
    override val openSampleScreenLiveData = MutableLiveData<NoteEntity>()


    override fun clickAddButton() {
        addScreenLiveData.value = Unit
    }

    override fun clickMenuButton() {
        menuLiveData.value = Unit
    }

    override fun clickMoreButton(noteEntity: NoteEntity) {
        moreDialogLiveData.value = noteEntity
    }

    override fun getNotes(): LiveData<List<NoteEntity>> {
        return repository.getNotes()
    }

    override fun deleteNote(noteEntity: NoteEntity) {
        repository.onTrash(noteEntity.id)
    }


    override fun archiveNote(noteEntity: NoteEntity) {
        repository.onArchive(noteEntity.id)
    }


    override fun changeColor(noteEntity: NoteEntity, color: Int) {
        repository.changeColor(noteEntity.id, color)
    }

    override fun clickItem(noteEntity: NoteEntity) {
        openSampleScreenLiveData.value = noteEntity
    }

}