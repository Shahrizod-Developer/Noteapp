package uz.gita.noteapp.domain.usecase

import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo

interface UpdateScreenUseCase {


    suspend fun updateNote(note: Note)

    suspend fun updateToDo(toDo: ToDo)
}