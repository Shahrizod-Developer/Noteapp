package uz.gita.noteapp.data.local.room.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update
    suspend fun update(t: T)

    @Update
    suspend fun update(data: List<T>)

    @Delete
    suspend fun delete(t: T)

    @Delete
    suspend fun delete(data: List<T>)
}