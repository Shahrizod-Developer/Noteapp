package uz.gita.noteapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.domain.usecase.MainScreenUseCase
import uz.gita.noteapp.domain.usecase.impl.MainScreenUseCaseImpl
import uz.gita.noteapp.presentation.ui.viewmodel.MainScreenViewModel

class MainScreenViewModelImpl :
    MainScreenViewModel, ViewModel() {
    private val mainScreenUseCase = MainScreenUseCaseImpl()
    override val openAddScreenLiveData: LiveData<Unit> = MutableLiveData()
    override val openUpdateScreenLiveData: LiveData<Unit> = MutableLiveData()
    override val showDeleteDialogLiveData: LiveData<Unit> = MutableLiveData()
    override val onCLickPinLiveData: LiveData<Unit> = MutableLiveData()
    override val onClickShareLiveData: LiveData<Unit> = MutableLiveData()
    override val noteListLiveData: MutableLiveData<List<Note>> = MutableLiveData()


    init {
        viewModelScope.launch {
            mainScreenUseCase.getAllNotes().collectLatest {
                noteListLiveData.value = it
            }
        }
    }

    override fun delete(noteList: List<Note>) {
        viewModelScope.launch {
            mainScreenUseCase.delete(noteList)
        }
    }

    override fun delete(note: Note) {
        viewModelScope.launch {
            mainScreenUseCase.delete(note)
        }
    }

    override fun changePin(note: Note) {
        viewModelScope.launch {
            mainScreenUseCase.changePin(note)
        }
    }

    override fun changeTitleState(note: Note) {
        viewModelScope.launch {
            mainScreenUseCase.changeTitleState(note)
        }
    }
}