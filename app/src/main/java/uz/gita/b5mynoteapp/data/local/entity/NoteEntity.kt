package uz.gita.b5mynoteapp.data.local.entity

import androidx.room.*
import java.util.Date

@Entity(tableName = "Notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date = Date(),
    @ColumnInfo(name = "on_archive")
    val onArchive: Boolean = false,
    @ColumnInfo(name = "on_trash")
    val onTrash: Boolean = false,
    @ColumnInfo(name = "color")
    val noteColor: Int = 0
) : java.io.Serializable