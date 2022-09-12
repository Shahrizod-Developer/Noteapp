package uz.gita.noteapp.presentation.ui.screen.fragment.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteapp.R
import uz.gita.noteapp.databinding.ScreenAddBinding

class AddScreen : Fragment(R.layout.screen_add) {

    private val binding: ScreenAddBinding by viewBinding(ScreenAddBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}