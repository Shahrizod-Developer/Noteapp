package uz.gita.noteapp.domain.usecase.impl

import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.domain.repository.impl.RepositoryImpl
import uz.gita.noteapp.domain.usecase.AddScreenUseCase

class AddScreenUseCaseImpl : AddScreenUseCase {

    private val repository = RepositoryImpl.getInstance()


    override suspend fun addNote(note: Note) {
        repository.insert(note)
    }

    override suspend fun addToDo(toDo: ToDo) {
        repository.insert(toDo)
    }

    override suspend fun deleteToDo(toDo: ToDo) {
        repository.delete(toDo)
    }
}