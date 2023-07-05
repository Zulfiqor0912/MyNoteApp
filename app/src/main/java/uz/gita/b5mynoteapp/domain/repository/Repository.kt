package uz.gita.b5mynoteapp.domain.repository

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

interface Repository {

    fun addNote(note: NoteEntity)

    fun updateNote(note: NoteEntity)

    fun deleteNote(note: NoteEntity)

    fun getNotes(): LiveData<List<NoteEntity>>

    fun getNote(id:Int): LiveData<NoteEntity>

    fun onTrash(noteInt: Int)

    fun onArchive(noteInt: Int)

    fun offTrash(noteInt: Int)

    fun offArchive(noteInt: Int)

    fun getAllOnTrash(): LiveData<List<NoteEntity>>

    fun getAllOnArchive(): LiveData<List<NoteEntity>>

    fun changeColor(id: Int, color: Int)

    fun clearInTrash()
}