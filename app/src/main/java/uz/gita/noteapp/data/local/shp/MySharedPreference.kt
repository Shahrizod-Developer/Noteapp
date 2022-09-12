package uz.gita.noteapp.data.local.shp

import android.content.Context
import android.content.SharedPreferences


class MySharedPreference private constructor(context: Context) {

    var toDoId: String
        get() = sharedPreferences.getString("to_do_id", "").toString()
        set(toDoId) {
            editor.putString("to_do_id", toDoId).apply()
        }


    companion object {
        var mySharedPreference: MySharedPreference? = null
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
        fun init(context: Context): MySharedPreference? {
            if (mySharedPreference == null) {
                mySharedPreference = MySharedPreference(context)
            }
            return mySharedPreference
        }

        fun getInstance() = mySharedPreference!!
    }

    init {
        sharedPreferences = context.getSharedPreferences("app_name", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
}
