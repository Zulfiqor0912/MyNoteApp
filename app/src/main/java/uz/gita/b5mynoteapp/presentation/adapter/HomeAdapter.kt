package uz.gita.b5mynoteapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity

class HomeAdapter : ListAdapter<NoteEntity, HomeAdapter.Holder>(MyDiffUtil) {
    private var clickMoreButton: ((note: NoteEntity) -> Unit)? = null
    private var clickItem: ((note: NoteEntity) -> Unit)? = null

    inner class Holder(view: View) : ViewHolder(view) {
        private val titleText: AppCompatTextView = view.findViewById(R.id.text_title)
        private val date: AppCompatTextView = view.findViewById(R.id.text_date)
        private val itemNote: ConstraintLayout = view.findViewById(R.id.item_note)


        init {
            view.findViewById<AppCompatImageView>(R.id.image_more).setOnClickListener {
                clickMoreButton?.invoke(getItem(adapterPosition))
            }

            view.findViewById<ConstraintLayout>(R.id.item_note).setOnClickListener {
                clickItem?.invoke(getItem(adapterPosition))
            }
        }

        fun bind(noteEntity: NoteEntity) {
            titleText.text = noteEntity.title
            date.text = noteEntity.createdAt.toString()
            when (noteEntity.noteColor) {
                1 -> itemNote.setBackgroundResource(R.drawable.bg_white)
                2 -> itemNote.setBackgroundResource(R.drawable.bg_red)
                3 -> itemNote.setBackgroundResource(R.drawable.bg_orange)
                4 -> itemNote.setBackgroundResource(R.drawable.bg_yellow)
                5 -> itemNote.setBackgroundResource(R.drawable.bg_green)
                6 -> itemNote.setBackgroundResource(R.drawable.bg_blue)
                7 -> itemNote.setBackgroundResource(R.drawable.bg_purple)
                8 -> itemNote.setBackgroundResource(R.drawable.bg_500)
                9 -> itemNote.setBackgroundResource(R.drawable.bg_purple12)
                10 -> itemNote.setBackgroundResource(R.drawable.bg_purple2)
                11 -> itemNote.setBackgroundResource(R.drawable.bg_2)
                12 -> itemNote.setBackgroundResource(R.drawable.bg_3)
            }

        }
    }

    object MyDiffUtil : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity) =
            oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity) =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setClickMoreButton(block: (note: NoteEntity) -> Unit) {
        clickMoreButton = block
    }

    fun setClickItem(block: (note: NoteEntity) -> Unit) {
        clickItem = block
    }
}