package uz.gita.b5mynoteapp.data.local

import android.content.Context
import androidx.room.*
import uz.gita.b5mynoteapp.data.local.converter.DateConverter
import uz.gita.b5mynoteapp.data.local.dao.NoteDao
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private lateinit var database: MyDatabase

        fun init(context: Context) {
            if (!::database.isInitialized) {
                database =
                    Room.databaseBuilder(context, MyDatabase::class.java, "NOTES")
                        .allowMainThreadQueries().build()
            }
        }

        fun instance() = database
    }
}