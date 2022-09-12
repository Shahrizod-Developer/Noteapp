package uz.gita.noteapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.Note

interface MainScreenUseCase {


    fun getAllNotes(): Flow<List<Note>>

    suspend fun delete(noteList: List<Note>)

    suspend fun delete(note: Note)

    suspend fun changePin(note: Note)

    suspend fun changeTitleState(note: Note)
}