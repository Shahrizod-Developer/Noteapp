package uz.gita.noteapp.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.room.entity.NoteEntity

interface UpdateScreenViewModel {

    val messageLiveData: LiveData<String>

    val openScreenLiveData: LiveData<Unit>

    fun update(noteDataEntity: NoteEntity)
}