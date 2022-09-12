package uz.gita.noteapp.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.noteapp.data.local.model.Note

interface MainScreenViewModel {

    val noteListLiveData: LiveData<List<Note>>
    val openAddScreenLiveData: LiveData<Unit>
    val openUpdateScreenLiveData: LiveData<Unit>
    val showDeleteDialogLiveData: LiveData<Unit>
    val onCLickPinLiveData: LiveData<Unit>
    val onClickShareLiveData: LiveData<Unit>

    fun delete(noteList: List<Note>)

    fun delete(note: Note)

    fun changePin(note: Note)

    fun changeTitleState(note: Note)

}