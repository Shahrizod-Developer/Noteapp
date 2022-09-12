package uz.gita.noteapp.presentation.ui.screen.fragment.main

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.noteapp.R
import uz.gita.noteapp.databinding.ScreenMainBinding


class MainScreen() : Fragment(R.layout.screen_main) {

    private val binding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private var fabOpen: Animation? = null
    private var fabClose: Animation? = null
    private var rotateForward: Animation? = null
    private var rotateBackward: Animation? = null
    var isOpen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        fabOpen = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_open)
        fabClose = AnimationUtils.loadAnimation(requireContext(), R.anim.fab_close)
        rotateForward = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_forward)
        rotateBackward = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_backward)

        binding.add.setOnClickListener {
            animateFab()
            binding.checkList.visibility = View.VISIBLE
            binding.checkListText.visibility = View.VISIBLE
            binding.note.visibility = View.VISIBLE
            binding.noteText.visibility = View.VISIBLE

            if(isOpen){
                binding.view.visibility = View.VISIBLE
            }
            else{
                binding.view.visibility = View.GONE
            }
        }

        binding.checkList.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "camera click", Toast.LENGTH_SHORT
            ).show()
        }
        binding.note.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "folder click", Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun animateFab() {
        isOpen = if (isOpen) {
            binding.add.startAnimation(rotateForward)
            binding.checkList.startAnimation(fabClose)
            binding.checkListText.startAnimation(fabClose)
            binding.note.startAnimation(fabClose)
//            binding.view.startAnimation(fabClose)
            binding.noteText.startAnimation(fabClose)
            binding.checkList.isClickable = false
            binding.note.isClickable = false
            false
        } else {
            binding.add.startAnimation(rotateBackward)
            binding.checkList.startAnimation(fabOpen)
            binding.checkListText.startAnimation(fabOpen)
            binding.note.startAnimation(fabOpen)
            binding.noteText.startAnimation(fabOpen)
//            binding.view.startAnimation(fabOpen)
            binding.checkList.isClickable = true
            binding.note.isClickable = true
            true
        }
    }

}