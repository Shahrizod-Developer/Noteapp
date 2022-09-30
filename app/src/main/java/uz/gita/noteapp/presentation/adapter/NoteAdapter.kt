package uz.gita.noteapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.noteapp.data.local.model.Note
import uz.gita.noteapp.databinding.ItemNoteBinding

class NoteAdapter : ListAdapter<Note, NoteAdapter.ViewHolder>(
    NoteDiffUtilCallback
) {

    private var deleteListener: ((Note) -> Unit)? = null
    private var itemOnclickListener: ((Note) -> Unit)? = null

    fun submitDelete(block: (Note) -> Unit) {
        deleteListener = block
    }

    fun submitItemOnClick(block: (Note) -> Unit) {
        itemOnclickListener = block
    }

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            binding.btnDelete.setOnClickListener {
                deleteListener?.invoke(getItem(absoluteAdapterPosition))
            }
            binding.item1.setOnClickListener {
                itemOnclickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun onBind() {
            val item = getItem(absoluteAdapterPosition)

            binding.textTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()
}

private val NoteDiffUtilCallback = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.statusTitle == newItem.statusTitle
                && oldItem.statusPin == newItem.statusPin
                && oldItem.statusDelete == newItem.statusDelete
                && oldItem.status == newItem.status
                && oldItem.title == newItem.title
                && oldItem.id == newItem.id
                && oldItem.noteList == newItem.noteList
                && oldItem.time == newItem.time
                && oldItem.desc == newItem.desc
    }

}