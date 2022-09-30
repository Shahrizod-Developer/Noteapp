package uz.gita.noteapp.presentation.ui.screen.fragment.add

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
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
import uz.gita.noteapp.data.local.room.entity.NoteEntity
import uz.gita.noteapp.databinding.ScreenAddBinding
import uz.gita.noteapp.presentation.ui.viewmodel.AddScreenViewModel
import uz.gita.noteapp.presentation.ui.viewmodel.impl.AddScreenViewModelImpl

class AddScreen : Fragment(R.layout.screen_add) {

    private val viewBinding: ScreenAddBinding by viewBinding(ScreenAddBinding::bind)
    private val viewModel: AddScreenViewModel by viewModels<AddScreenViewModelImpl>()
    private val navigation by lazy { findNavController() }
    private lateinit var mToolbar: IARE_Toolbar
    private lateinit var mEditText: AREditText
    private var scrollerAtEnd = false


    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnSave.setOnClickListener {
            viewModel.add(
                NoteEntity(
                    0,
                    viewBinding.inputTitle.text.toString(),
                    "",
                    viewBinding.description.text.toString(),
                    0,
                    0,
                    0,
                    0,
                    0
                )
            )
        }

        viewModel.openScreenLiveData.observe(this) {
            navigation.popBackStack()
        }

        viewModel.messageLiveData.observe(this) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        init()
    }

    private fun init() {

        view.apply {


            mToolbar = viewBinding.areToolbar

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
//            mToolbar.addToolbarItem(hr)
            mToolbar.addToolbarItem(link)
            mToolbar.addToolbarItem(color)
            mToolbar.addToolbarItem(color1)
            mToolbar.addToolbarItem(subscript)
            mToolbar.addToolbarItem(superscript)
            mToolbar.addToolbarItem(left)
            mToolbar.addToolbarItem(center)
            mToolbar.addToolbarItem(right)
            mToolbar.addToolbarItem(at)
            mEditText = viewBinding.description
            mEditText.setToolbar(mToolbar)
            val imageView: ImageView = viewBinding.arrow
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