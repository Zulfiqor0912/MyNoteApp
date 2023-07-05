package uz.gita.b5mynoteapp.presentation.screen.edit.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface EditViewModel {
    val openHomeScreenLiveData: LiveData<Unit>
    val openChangeColor: LiveData<Unit>

    fun clickSaveButton(note:NoteEntity)
    fun clickBackButton()
    fun clickChangeColorButton()
}