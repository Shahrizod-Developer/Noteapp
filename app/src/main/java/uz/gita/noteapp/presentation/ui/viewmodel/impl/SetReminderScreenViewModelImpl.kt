package uz.gita.noteapp.presentation.ui.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.noteapp.presentation.ui.viewmodel.SetReminderScreenViewModel

class SetReminderScreenViewModelImpl:SetReminderScreenViewModel, ViewModel() {

    override val openAddScreenLiveData: MutableLiveData<Unit> = MutableLiveData()

}