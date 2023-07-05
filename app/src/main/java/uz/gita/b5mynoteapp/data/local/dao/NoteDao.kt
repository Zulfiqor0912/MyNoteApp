package uz.gita.b5mynoteapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

@Dao
interface NoteDao {
    @Insert
    fun add(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)

    @Query("SELECT * FROM Notes WHERE Notes.on_trash=0 AND Notes.on_archive=0")
    fun getNotes(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM Notes WHERE Notes.id =:id")
    fun getNote(id: Int): LiveData<NoteEntity>

    @Query("UPDATE Notes SET on_trash = 1 WHERE Notes.id=:noteId")
    fun onTrash(noteId: Int)

    @Query("UPDATE Notes SET on_archive = 1 WHERE Notes.id=:noteId")
    fun onArchive(noteId: Int)

    @Query("UPDATE Notes SET on_trash = 0 WHERE Notes.id=:noteId")
    fun offTrash(noteId: Int)

    @Query("UPDATE Notes SET on_archive = 0 WHERE Notes.id=:noteId")
    fun offArchive(noteId: Int)

    @Query("SELECT * FROM Notes WHERE Notes.on_trash = 1")
    fun getNotesInTrash(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM Notes WHERE Notes.on_archive = 1")
    fun getNotesInArchive(): LiveData<List<NoteEntity>>

    @Query("DELETE FROM Notes WHERE on_trash = 1")
    fun clearInTrash()

    @Query("UPDATE Notes SET color = :color WHERE Notes.id=:id")
    fun changeColor(id: Int, color: Int)

}