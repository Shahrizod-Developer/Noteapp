package uz.gita.noteapp.domain.usecase.impl

import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.domain.repository.impl.RepositoryImpl
import uz.gita.noteapp.domain.usecase.UpdateScreenUseCase

class UpdateScreenUseCaseImpl : UpdateScreenUseCase {

    private val repository = RepositoryImpl.getInstance()

    override suspend fun updateNote(note: Note) {
        repository.update(note)
    }

    override suspend fun updateToDo(toDo: ToDo) {
        repository.update(toDo)
    }
}