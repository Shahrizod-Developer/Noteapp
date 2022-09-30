package uz.gita.noteapp.data.local.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.data.local.room.entity.ToDoEntity
import java.io.Serializable

data class Note(
    val id: Int,
    val title: String,
    val noteList: String,
    val desc: String,
    val time: Long,
    var statusDelete: Int,
    var statusPin: Int,
    var statusTitle: Int,
    val status: Int
) : Serializable {
    fun toNoteEntity() =
        NoteEntity(id, title, noteList, desc, time, statusDelete, statusPin, statusTitle, status)
}