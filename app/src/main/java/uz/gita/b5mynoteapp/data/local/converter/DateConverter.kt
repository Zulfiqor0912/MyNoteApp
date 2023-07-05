package uz.gita.b5mynoteapp.data.local.converter

import androidx.room.TypeConverter
import java.util.*

object DateConverter {
    @TypeConverter
    fun fromDateToTimeStamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromTimeStampToDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }
}