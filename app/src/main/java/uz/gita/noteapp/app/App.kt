package uz.gita.noteapp.app

import android.app.Application
import uz.gita.noteapp.data.local.room.database.AppDatabase
import uz.gita.noteapp.data.local.shp.MySharedPreference

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)
        MySharedPreference.init(this)
    }
}