package uz.gita.noteapp.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.domain.repository.impl.RepositoryImpl
import uz.gita.noteapp.domain.usecase.MainScreenUseCase

class MainScreenUseCaseImpl : MainScreenUseCase {

    private val repository = RepositoryImpl.getInstance()
    override fun getAllNotes(): Flow<List<Note>> = repository.getAllNotes()

    override suspend fun changeTitleState(note: Note) {

        if (note.statusTitle == 0) {
            note.statusTitle = 1
        } else {
            note.statusTitle = 0
        }

        repository.update(note)
    }

    override suspend fun changePin(note: Note) {
        if (note.statusPin == 0) {
            note.statusPin = 1
        } else {
            note.statusPin = 0
        }

        repository.update(note)
    }

    override suspend fun delete(noteList: List<Note>) {

        noteList.forEach {
            if (it.statusDelete == 0) {
                it.statusDelete = 1
            } else {
                it.statusDelete = 0
            }
        }
        repository.update(noteList)
    }

    override suspend fun delete(note: Note) {

        if (note.statusDelete == 0) {
            note.statusDelete = 1
        } else {
            note.statusDelete = 0
        }

        repository.update(note)
    }
}