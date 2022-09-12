package uz.gita.noteapp.data.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.noteapp.data.local.room.dao.NoteDao
import uz.gita.noteapp.data.local.room.dao.ToDoDao
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.data.local.room.entity.ToDoEntity


@Database(entities = [NoteEntity::class, ToDoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun toDoDao(): ToDoDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun init(context: Context): AppDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return instance
            }
        }

        fun getInstance() = INSTANCE!!
    }
}