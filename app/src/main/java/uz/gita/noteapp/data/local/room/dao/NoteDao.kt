package uz.gita.noteapp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.ToDo
import uz.gita.noteapp.data.local.room.entity.NoteEntity

@Dao
interface NoteDao : BaseDao<NoteEntity> {

    @Query("Select * From note Where note.statusDelete = 0")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("Select * From note Where note.statusDelete = 1")
    fun getAllNotesTrash(): Flow<List<NoteEntity>>

    @Query("Select * From note")
    fun getAllNote(): List<NoteEntity>


    @Query("Delete From note")
    suspend fun delete()
}