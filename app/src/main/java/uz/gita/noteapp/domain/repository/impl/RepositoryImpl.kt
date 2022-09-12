package uz.gita.noteapp.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.data.local.room.database.AppDatabase
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.domain.repository.Repository

class RepositoryImpl : Repository {

    private val noteDao = AppDatabase.getInstance().noteDao()
    private val toDoDao = AppDatabase.getInstance().toDoDao()

    companion object {
        private lateinit var instance: Repository

        fun getInstance(): Repository {
            if (!Companion::instance.isInitialized) {
                instance = RepositoryImpl()
            }
            return instance
        }
    }

    override fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes().map { flowElement ->
        flowElement.map { listElement -> listElement.toNote() }
    }.flowOn(Dispatchers.IO)

    override fun getAllTrashList(): Flow<List<Note>> =
        noteDao.getAllNotesTrash().map { flowElement ->
            flowElement.map { flowElement -> flowElement.toNote() }
        }.flowOn(Dispatchers.IO)

    override fun getAllNote(): List<NoteEntity> = noteDao.getAllNote()

    override suspend fun insert(note: Note) {
        noteDao.insert(note.toNoteEntity())
    }

    override suspend fun insert(noteList: List<Note>) {
        noteDao.insert(noteList.map { it -> it.toNoteEntity() })
    }

    override suspend fun insert(toDo: ToDo) {
        toDoDao.insert(toDo.toToDoEntity())
    }

    override suspend fun insertToDoList(todoList: List<ToDo>) {
        toDoDao.insert(todoList.map { it.toToDoEntity() })
    }

    override suspend fun update(note: Note) {
        noteDao.update(note.toNoteEntity())
    }

    override suspend fun update(toDo: ToDo) {
        toDoDao.update(toDo.toToDoEntity())
    }

    override suspend fun update(noteList: List<Note>) {
        noteDao.update(noteList.map { it.toNoteEntity() })
    }

    override suspend fun updateToDoList(toDoList: List<ToDo>) {
        toDoDao.update(toDoList.map { it.toToDoEntity() })
    }

    override suspend fun delete(note: Note) {
        noteDao.delete(note.toNoteEntity())
    }

    override suspend fun delete(toDo: ToDo) {
        toDoDao.delete(toDo.toToDoEntity())
    }

    override suspend fun delete() {
        toDoDao.deleteAllToDo()
    }

    override suspend fun delete(noteList: List<Note>) {
        noteDao.delete(noteList.map { it.toNoteEntity() })
    }

    override suspend fun deleteToDoList(toDoList: List<ToDo>) {
        toDoDao.delete(toDoList.map { it.toToDoEntity() })
    }

    override suspend fun deleteAll() {
        noteDao.delete()
    }
}