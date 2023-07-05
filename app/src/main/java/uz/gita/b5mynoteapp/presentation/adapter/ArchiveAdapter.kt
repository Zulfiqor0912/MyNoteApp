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

class ArchiveAdapter : ListAdapter<NoteEntity, ArchiveAdapter.Holder>(MyDiffUtil) {
    private var clickArchive: ((note: NoteEntity) -> Unit)? = null

    inner class Holder(view: View) : ViewHolder(view) {
        private val titleText: AppCompatTextView = view.findViewById(R.id.text_title_archive)
        private val date: AppCompatTextView = view.findViewById(R.id.text_date_archive)

        init {
            view.findViewById<AppCompatImageView>(R.id.image_archive).setOnClickListener {
                clickArchive?.invoke(getItem(adapterPosition))
            }
        }

        fun bind(noteEntity: NoteEntity) {
            titleText.text = noteEntity.title
            date.text = noteEntity.createdAt.toString()
        }

    }

    object MyDiffUtil : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note_archive, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setClickArchive(block: (note: NoteEntity) -> Unit) {
        clickArchive = block
    }
}