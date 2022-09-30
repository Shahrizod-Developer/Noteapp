package uz.gita.noteapp.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.noteapp.data.local.room.entity.NoteEntity

interface AddScreenViewModel {

    val messageLiveData: LiveData<String>

    val openScreenLiveData: LiveData<Unit>

    fun add(noteDataEntity: NoteEntity)
}