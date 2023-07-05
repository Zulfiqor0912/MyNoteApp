package uz.gita.b5mynoteapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

class TrashAdapter : ListAdapter<NoteEntity, TrashAdapter.Holder>(TrashDiffUtil) {
    private var clickTrashButton: ((note: NoteEntity) -> Unit)? = null


    inner class Holder(view: View) : ViewHolder(view) {
        private val textTitle: AppCompatTextView = view.findViewById(R.id.text_title_trash)
        private val date: AppCompatTextView = view.findViewById(R.id.text_date_trash)

        init {
            view.findViewById<AppCompatImageView>(R.id.image_trash).setOnClickListener {
                clickTrashButton?.invoke(getItem(adapterPosition))
            }
        }

        fun bind(item: NoteEntity) {
            textTitle.text = item.title
            date.text = item.createdAt.toString()
        }

    }

    object TrashDiffUtil : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_note_trash, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setClickTrashButton(block: (note: NoteEntity) -> Unit) {
        clickTrashButton = block
    }
}