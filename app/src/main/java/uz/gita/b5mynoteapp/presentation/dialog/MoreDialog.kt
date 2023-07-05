package uz.gita.b5mynoteapp.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.DialogMoreBinding


class MoreDialog(
    val note: NoteEntity
) :
    DialogFragment(R.layout.dialog_more) {
    private val binding by viewBinding(DialogMoreBinding::bind)

    private var clickDeleteButton: ((note: NoteEntity) -> Unit)? = null
    private var clickArchiveButton: ((note: NoteEntity) -> Unit)? = null
    private var clickChangeColor: ((note: NoteEntity) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            dialogDelete.setOnClickListener {
                dismiss()
                clickDeleteButton?.invoke(note)
            }

            dialogArchive.setOnClickListener {
                dismiss()
                clickArchiveButton?.invoke(note)
            }

            dialogColor.setOnClickListener {
                dismiss()
                clickChangeColor?.invoke(note)
            }
        }
    }

    fun setClickDeleteButton(block: (note: NoteEntity) -> Unit) {
        clickDeleteButton = block
    }

    fun setClickArchiveButton(block: (note: NoteEntity) -> Unit) {
        clickArchiveButton = block
    }

    fun setClickChangeColorButton(block: (note: NoteEntity) -> Unit) {
        clickChangeColor = block
    }

    override fun onPause() {
        super.onPause()
        dismiss()
    }
}