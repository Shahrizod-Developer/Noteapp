package uz.gita.noteapp.presentation.ui.screen.fragment.update

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.chinalwb.are.AREditText
import com.chinalwb.are.styles.toolbar.ARE_ToolbarDefault
import com.chinalwb.are.styles.toolbar.IARE_Toolbar
import com.chinalwb.are.styles.toolitems.*
import uz.gita.noteapp.R
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.databinding.ScreenUpdateBinding
import uz.gita.noteapp.presentation.ui.viewmodel.UpdateScreenViewModel
import uz.gita.noteapp.presentation.ui.viewmodel.impl.UpdateScreenViewModelImpl

class UpdateScreen : Fragment(R.layout.screen_update) {

    private val binding: ScreenUpdateBinding by viewBinding(ScreenUpdateBinding::bind)
    private val viewModel: UpdateScreenViewModel by viewModels<UpdateScreenViewModelImpl>()

    private var fabOpen: Animation? = null
    private var fabClose: Animation? = null
    private var rotateForward: Animation? = null
    private var rotateBackward: Animation? = null
    var isOpen = false


    private lateinit var mToolbar: IARE_Toolbar
    private lateinit var mEditText: AREditText
    private var scrollerAtEnd = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val data = arguments?.getSerializable("note") as Note

        binding.description.setText(data.desc)
        binding.inputTitle.setText(data.title)

        binding.btnEdit.setOnClickListener {
            binding.btnSave.visibility = View.VISIBLE
            binding.btnEdit.visibility = View.GONE
        }

        binding.description.setOnClickListener {
            binding.btnSave.visibility = View.VISIBLE
            binding.btnEdit.visibility = View.GONE
        }

        binding.btnSave.setOnClickListener {
            viewModel.update(
                NoteEntity(
                    data.id,
                    binding.inputTitle.text.toString(),
                    "",
                    binding.description.text.toString(),
                    0,
                    0,
                    0,
                    0,
                    0
                )
            )
        }

        viewModel.openScreenLiveData.observe(this) {
            findNavController().popBackStack()
        }

        viewModel.messageLiveData.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }


        viewModel.messageLiveData.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        view.apply {


            mToolbar = binding.areToolbar

            val bold: IARE_ToolItem = ARE_ToolItem_Bold()
            val italic: IARE_ToolItem = ARE_ToolItem_Italic()
            val underline: IARE_ToolItem = ARE_ToolItem_Underline()
            val strikethrough: IARE_ToolItem = ARE_ToolItem_Strikethrough()
            val quote: IARE_ToolItem = ARE_ToolItem_Quote()
            val listNumber: IARE_ToolItem = ARE_ToolItem_ListNumber()
            val listBullet: IARE_ToolItem = ARE_ToolItem_ListBullet()
            val hr: IARE_ToolItem = ARE_ToolItem_Hr()
            val link: IARE_ToolItem = ARE_ToolItem_Link()
            val subscript: IARE_ToolItem = ARE_ToolItem_Subscript()
            val superscript: IARE_ToolItem = ARE_ToolItem_Superscript()
            val left: IARE_ToolItem = ARE_ToolItem_AlignmentLeft()
            val center: IARE_ToolItem = ARE_ToolItem_AlignmentCenter()
            val right: IARE_ToolItem = ARE_ToolItem_AlignmentRight()
            val image: IARE_ToolItem = ARE_ToolItem_Image()
            val video: IARE_ToolItem = ARE_ToolItem_Video()
            val at: IARE_ToolItem = ARE_ToolItem_At()
            val color: IARE_ToolItem = ARE_ToolItem_BackgroundColor()
            val color1: IARE_ToolItem = ARE_ToolItem_FontColor()
            mToolbar.addToolbarItem(bold)
            mToolbar.addToolbarItem(italic)
            mToolbar.addToolbarItem(underline)
            mToolbar.addToolbarItem(strikethrough)
            mToolbar.addToolbarItem(quote)
            mToolbar.addToolbarItem(listNumber)
            mToolbar.addToolbarItem(listBullet)
            mToolbar.addToolbarItem(hr)
            mToolbar.addToolbarItem(link)
            mToolbar.addToolbarItem(color)
            mToolbar.addToolbarItem(color1)
            mToolbar.addToolbarItem(subscript)
            mToolbar.addToolbarItem(superscript)
            mToolbar.addToolbarItem(left)
            mToolbar.addToolbarItem(center)
            mToolbar.addToolbarItem(right)
            mToolbar.addToolbarItem(at)
            mEditText = binding.description
            mEditText.setToolbar(mToolbar)
            val imageView: ImageView = findViewById(R.id.arrow)
            if (mToolbar is ARE_ToolbarDefault) {
                (mToolbar as ARE_ToolbarDefault).viewTreeObserver.addOnScrollChangedListener {
                    val scrollX = (mToolbar as ARE_ToolbarDefault).scrollX
                    val scrollWidth = (mToolbar as ARE_ToolbarDefault).width
                    val fullWidth = (mToolbar as ARE_ToolbarDefault).getChildAt(0).width
                    scrollerAtEnd = if (scrollX + scrollWidth < fullWidth) {
                        imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_left_24)
                        false
                    } else {
                        imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
                        true
                    }
                }
            }
            imageView.setOnClickListener {
                scrollerAtEnd = if (scrollerAtEnd) {
                    (mToolbar as ARE_ToolbarDefault?)!!.smoothScrollBy(-Int.MAX_VALUE, 0)
                    false
                } else {
                    val hsWidth = (mToolbar as ARE_ToolbarDefault?)!!.getChildAt(0).width
                    (mToolbar as ARE_ToolbarDefault?)!!.smoothScrollBy(hsWidth, 0)
                    true
                }
            }
        }

    }
}