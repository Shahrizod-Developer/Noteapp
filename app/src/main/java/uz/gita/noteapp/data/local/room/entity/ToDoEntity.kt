package uz.gita.noteapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.noteapp.data.local.model.ToDo


@Entity(tableName = "todo")
data class ToDoEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteId: Int,
    val desc: String,
    val status: String
) {
    fun toToDo() =
        ToDo(id, noteId, desc, status)
}