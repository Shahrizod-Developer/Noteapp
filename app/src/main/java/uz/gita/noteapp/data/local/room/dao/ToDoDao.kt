package uz.gita.noteapp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.data.local.room.entity.ToDoEntity


@Dao
interface ToDoDao : BaseDao<ToDoEntity> {

    @Query("Select * From todo Where todo.noteId = :noteId")
    fun getToDoList(noteId: Int): Flow<List<ToDoEntity>>

    @Query("Delete From todo")
    fun deleteAllToDo()
}