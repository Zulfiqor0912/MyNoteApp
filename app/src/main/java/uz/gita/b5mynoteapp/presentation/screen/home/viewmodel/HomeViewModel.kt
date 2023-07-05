package uz.gita.b5mynoteapp.presentation.screen.home.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface HomeViewModel {
    fun clickAddButton()
    fun clickMenuButton()
    fun clickMoreButton(noteEntity: NoteEntity)
    fun getNotes(): LiveData<List<NoteEntity>>


    fun deleteNote(noteEntity: NoteEntity)
    fun archiveNote(noteEntity: NoteEntity)
    fun changeColor(noteEntity: NoteEntity, color: Int)
    fun clickItem(noteEntity: NoteEntity)

    val allNotesLiveData: LiveData<List<NoteEntity>>
    val addScreenLiveData: LiveData<Unit>
    val moreDialogLiveData: LiveData<NoteEntity>
    val menuLiveData: LiveData<Unit>
    val openSampleScreenLiveData: LiveData<NoteEntity>


}