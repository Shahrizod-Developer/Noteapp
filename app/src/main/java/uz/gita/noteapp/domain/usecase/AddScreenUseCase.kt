package uz.gita.noteapp.domain.usecase

import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo

interface AddScreenUseCase {

    suspend fun addNote(note: Note)

    suspend fun addToDo(toDo: ToDo)

    suspend fun deleteToDo(toDo: ToDo)
}