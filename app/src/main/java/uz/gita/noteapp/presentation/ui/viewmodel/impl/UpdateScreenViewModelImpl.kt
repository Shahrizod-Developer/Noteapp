package uz.gita.noteapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.domain.usecase.impl.MainScreenUseCaseImpl
import uz.gita.noteapp.presentation.ui.viewmodel.MainScreenViewModel
import uz.gita.noteapp.presentation.ui.viewmodel.UpdateScreenViewModel

class UpdateScreenViewModelImpl : UpdateScreenViewModel, ViewModel() {

    override val messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val openScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val useCase = MainScreenUseCaseImpl()

    override fun update(noteDataEntity: NoteEntity) {

        if (noteDataEntity.desc.isNotEmpty()) {
            noteDataEntity.title = if (noteDataEntity.title.isNotEmpty()) {
                noteDataEntity.title
            } else "No Title"

            viewModelScope.launch {
                useCase.update(noteDataEntity.toNote())
                openScreenLiveData.value = Unit
            }
        } else {
            messageLiveData.value = "Maydon bo'sh"
        }
    }
}