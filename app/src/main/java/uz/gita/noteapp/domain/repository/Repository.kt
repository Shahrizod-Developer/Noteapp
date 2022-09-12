package uz.gita.noteapp.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.data.local.room.entity.NoteEntity


interface Repository {


    fun getAllNotes(): Flow<List<Note>>

    fun getAllTrashList(): Flow<List<Note>>

    fun getAllNote(): List<NoteEntity>

    suspend fun insert(note: Note)

    suspend fun insert(noteList: List<Note>)

    suspend fun insertToDoList(todoList: List<ToDo>)

    suspend fun insert(toDo: ToDo)

    suspend fun update(note: Note)

    suspend fun update(toDo: ToDo)

    suspend fun update(noteList: List<Note>)

    suspend fun updateToDoList(toDoList: List<ToDo>)

    suspend fun delete(note: Note)

    suspend fun delete(toDo: ToDo)

    suspend fun delete()

    suspend fun delete(noteList: List<Note>)

    suspend fun deleteToDoList(toDoList: List<ToDo>)

    suspend fun deleteAll()
}