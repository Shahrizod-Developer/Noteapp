package uz.gita.noteapp.data.local.model

import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.data.local.room.entity.ToDoEntity

data class ToDo(
    val id: Int,
    val noteId: Int,
    val desc: String,
    val status: String
) {
    fun toToDoEntity() = ToDoEntity(id, noteId, desc, status)
}