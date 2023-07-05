package uz.gita.b5mynoteapp.domain.repository.impl

import androidx.lifecycle.LiveData
import uz.gita.b5mynoteapp.data.local.MyDatabase
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.domain.repository.Repository

class RepositoryIMpl : Repository {

    private val database = MyDatabase.instance()

    companion object {
        private lateinit var repository: Repository


        fun init() {
            if (!::repository.isInitialized) repository = RepositoryIMpl()
        }

        fun instance() = repository
    }

    override fun addNote(note: NoteEntity) {
        database.getNoteDao().add(note)
    }

    override fun updateNote(note: NoteEntity) {
        database.getNoteDao().update(note)
    }

    override fun deleteNote(note: NoteEntity) {
        database.getNoteDao().delete(note)
    }

    override fun getNotes(): LiveData<List<NoteEntity>> {
        return database.getNoteDao().getNotes()
    }

    override fun getNote(id: Int): LiveData<NoteEntity> {
        return database.getNoteDao().getNote(id)
    }

    override fun onTrash(noteInt: Int) {
        database.getNoteDao().onTrash(noteInt)
    }

    override fun onArchive(noteInt: Int) {
        database.getNoteDao().onArchive(noteInt)
    }

    override fun offTrash(noteInt: Int) {
        database.getNoteDao().offTrash(noteInt)
    }

    override fun offArchive(noteInt: Int) {
        database.getNoteDao().offArchive(noteInt)
    }

    override fun getAllOnTrash(): LiveData<List<NoteEntity>> {
        return database.getNoteDao().getNotesInTrash()
    }

    override fun getAllOnArchive(): LiveData<List<NoteEntity>> {
        return database.getNoteDao().getNotesInArchive()
    }

    override fun changeColor(id: Int, color: Int) {
        return database.getNoteDao().changeColor(id, color)
    }

    override fun clearInTrash() {
        database.getNoteDao().clearInTrash()
    }
}