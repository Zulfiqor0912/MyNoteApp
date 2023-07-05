package uz.gita.b5mynoteapp.presentation.screen.add.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface AddViewModel {

    fun clickSaveButton(note: NoteEntity)

    fun clickBackButton()

    fun clickChangeColorButton()

    val homeScreenLiveData: LiveData<Unit>

    val openChangeColor: LiveData<Unit>
}