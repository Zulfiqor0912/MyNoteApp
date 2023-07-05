package uz.gita.b5mynoteapp.presentation.screen.trash.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface TrashViewModel {

    fun clickTrashButton(noteEntity: NoteEntity)
    fun clickBackButton()
    fun clickClearButton()

    val clearLiveData: LiveData<Unit>
    val openHomeLiveData: LiveData<Unit>
    val getAllTrashNotesLiveData: LiveData<List<NoteEntity>>
}