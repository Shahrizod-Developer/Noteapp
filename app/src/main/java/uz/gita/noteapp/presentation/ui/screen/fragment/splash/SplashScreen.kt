package uz.gita.noteapp.presentation.ui.screen.fragment.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteapp.R
import uz.gita.noteapp.databinding.ScreenSplashBinding
import uz.gita.noteapp.presentation.ui.viewmodel.SplashScreenViewModel
import uz.gita.noteapp.presentation.ui.viewmodel.impl.SplashScreenViewModelImpl

class SplashScreen : Fragment(R.layout.screen_splash) {

    private val binding: ScreenSplashBinding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openMainScreenLiveData.observe(this, openScreenObserver)
    }

    private val openScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_mainScreen)
    }
}