package uz.gita.b5mynoteapp.presentation.screen.sample.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.presentation.screen.edit.EditNoteScreen
import uz.gita.b5mynoteapp.presentation.screen.sample.viewmodel.SampleViewModel

class SampleViewModelImpl : SampleViewModel, ViewModel() {

    override fun clickEditButton(noteEntity: NoteEntity) {
        EditNoteScreen().arguments?.putSerializable("NOTES", noteEntity)
        editScreenLiveData.value = noteEntity
    }

    override fun clickBackButton() {
        homeScreenLiveData.value = Unit
    }



    override val homeScreenLiveData = MutableLiveData<Unit>()
    override val editScreenLiveData = MutableLiveData<NoteEntity>()

}