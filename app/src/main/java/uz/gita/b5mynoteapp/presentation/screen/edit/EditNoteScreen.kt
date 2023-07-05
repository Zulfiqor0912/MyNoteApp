package uz.gita.b5mynoteapp.presentation.screen.edit

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import jp.wasabeef.richeditor.RichEditor
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenEditBinding

import uz.gita.b5mynoteapp.presentation.dialog.ChangeColorDialog
import uz.gita.b5mynoteapp.presentation.screen.edit.viewmodel.EditViewModel
import uz.gita.b5mynoteapp.presentation.screen.edit.viewmodel.impl.EditViewModelImpl

class EditNoteScreen : Fragment(R.layout.screen_edit) {
    private val binding by viewBinding(ScreenEditBinding::bind)
    private val viewModel: EditViewModel by viewModels<EditViewModelImpl>()
    private val args by navArgs<EditNoteScreenArgs>()
    private lateinit var editor: RichEditor
    private var color = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openHomeScreenLiveData.observe(viewLifecycleOwner, openHomeScreenLiveData)
        viewModel.openChangeColor.observe(viewLifecycleOwner, openChangeColorDialog)
        color = args.note.noteColor
        changeColor(args.note.noteColor)
        binding.apply {
            buttonBackEdit.setOnClickListener {
                viewModel.clickBackButton()
            }

            buttonSaveEdit.setOnClickListener {
                viewModel.clickSaveButton(
                    NoteEntity(
                        id = args.note.id,
                        title = textNoteTitleEdit.text.toString(),
                        content = editor.html,
                        noteColor = color
                    )
                )
            }

            changeColorEdit.setOnClickListener {
                viewModel.clickChangeColorButton()
            }

            textNoteTitleEdit.setText(args.note.title)

            editor = richEditorEdit
            editor.html = args.note.content
            editor.setPadding(0, 8, 0, 0)
            editor.setEditorFontSize(18)
            editor.setEditorFontColor(Color.WHITE)



            actionBold.setOnClickListener {
                editor.setBold()
            }

            actionItalic.setOnClickListener {
                editor.setItalic()
            }

            actionHeading1.setOnClickListener {
                editor.setHeading(1)
            }

            actionHeading2.setOnClickListener {
                editor.setHeading(2)
            }

            actionHeading3.setOnClickListener {
                editor.setHeading(3)
            }

            actionHeading4.setOnClickListener {
                editor.setHeading(4)
            }

            actionHeading5.setOnClickListener {
                editor.setHeading(5)
            }

            actionHeading6.setOnClickListener {
                editor.setHeading(6)
            }


            actionIndent.setOnClickListener {
                editor.setIndent()
            }

            actionOutdent.setOnClickListener {
                editor.setOutdent()
            }

            actionUnderline.setOnClickListener {
                editor.setUnderline()
            }

            actionStrikethrough.setOnClickListener {
                editor.setStrikeThrough()
            }

            actionAlignLeft.setOnClickListener {
                editor.setAlignLeft()
            }

            actionAlignCenter.setOnClickListener {
                editor.setAlignCenter()
            }

            actionAlignRight.setOnClickListener {
                editor.setAlignRight()
            }

            actionBlockquote.setOnClickListener {
                editor.setBullets()
            }

            actionInsertNumbers.setOnClickListener {
                editor.setNumbers()
            }

            actionInsertCheckbox.setOnClickListener {
                editor.insertTodo()
            }

        }
    }

    private val openHomeScreenLiveData = Observer<Unit> {
        findNavController().navigate(R.id.action_editNoteScreen_to_homeScreen)
    }

    private val openChangeColorDialog = Observer<Unit> {
        val colorDialog = ChangeColorDialog()
        colorDialog.setClickColor1 {
            color = it
            changeColor(it)

        }
        colorDialog.setClickColor2 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor3 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor4 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor5 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor6 {
            color = it
            changeColor(it)

        }
        colorDialog.setClickColor7 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor8 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor9 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor10 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor11 {
            color = it
            changeColor(it)
        }
        colorDialog.setClickColor12 {
            color = it
            changeColor(it)
        }
        colorDialog.show(childFragmentManager, "Change Color")
    }

    private fun changeColor(num: Int) {
        when (num) {
            1 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_white)
            2 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_red)
            3 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_orange)
            4 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_yellow)
            5 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_green)
            6 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_blue)
            7 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_purple)
            8 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_500)
            9 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_purple12)
            10 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_purple2)
            11 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_2)
            12 -> binding.changeColorEdit.setBackgroundResource(R.drawable.bg_3)
        }
    }
}