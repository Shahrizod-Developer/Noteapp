package uz.gita.noteapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.domain.usecase.impl.AddScreenUseCaseImpl
import uz.gita.noteapp.presentation.ui.viewmodel.AddScreenViewModel


class AddScreenViewModelImpl : AddScreenViewModel, ViewModel() {

    override val messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val openScreenLiveData: MutableLiveData<Unit> = MutableLiveData()
    private val useCase = AddScreenUseCaseImpl()

    override fun add(noteDataEntity: NoteEntity) {

        if (noteDataEntity.desc.isNotEmpty()) {
            noteDataEntity.title = if (noteDataEntity.title.isNotEmpty()) {
                noteDataEntity.title
            } else "No Title"

            viewModelScope.launch {
                useCase.addNote(noteDataEntity.toNote())
                openScreenLiveData.value = Unit
            }
        } else {
            messageLiveData.value = "Maydon bo'sh"
        }
    }
}