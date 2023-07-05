package uz.gita.b5mynoteapp.presentation.screen.sample.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface SampleViewModel {

    fun clickEditButton(noteEntity: NoteEntity)
    fun clickBackButton()


    val homeScreenLiveData: LiveData<Unit>
    val editScreenLiveData: LiveData<NoteEntity>

}