package uz.gita.noteapp.data.local.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.noteapp.data.local.model.Note


@Entity(tableName = "note")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val noteList: String,
    val desc: String,
    val time: Long,
    val statusDelete: Int,
    val statusPin: Int,
    val statusTitle: Int,
    val status: Int
) {
    fun toNote() =
        Note(id, title, noteList, desc, time, statusDelete, statusPin, statusTitle, status)
}