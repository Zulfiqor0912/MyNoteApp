package uz.gita.b5mynoteapp.presentation.screen.archive.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface ArchiveViewModel {

    fun clickUnArchive(noteEntity: NoteEntity)
    fun clickBackButton()

    val openHomeScreenLiveData: LiveData<Unit>
    val archiveNotesLiveData: LiveData<List<NoteEntity>>
}