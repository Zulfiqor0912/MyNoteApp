package uz.gita.b5mynoteapp.presentation.screen.add

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import jp.wasabeef.richeditor.RichEditor
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenAddNoteBinding
import uz.gita.b5mynoteapp.presentation.adapter.HomeAdapter
import uz.gita.b5mynoteapp.presentation.dialog.ChangeColorDialog
import uz.gita.b5mynoteapp.presentation.screen.add.viewmodel.AddViewModel
import uz.gita.b5mynoteapp.presentation.screen.add.viewmodel.impl.AddViewModelImpl

class AddScreen : Fragment(R.layout.screen_add_note) {
    private val binding by viewBinding(ScreenAddNoteBinding::bind)
    private val viewModel: AddViewModel by viewModels<AddViewModelImpl>()
    private lateinit var editor: RichEditor
    private lateinit var adapter: HomeAdapter
    private var color = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.homeScreenLiveData.observe(this, homeScreenObserver)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openChangeColor.observe(viewLifecycleOwner, openChangeColorDialog)
        adapter = HomeAdapter()


        binding.apply {

            buttonSave.setOnClickListener {

                if (textNoteTitle.text.toString() != "" && editor.html.toString() != "") {
                    viewModel.clickSaveButton(
                        NoteEntity(
                            title = textNoteTitle.text.toString(),
                            content = editor.html,
                            noteColor = color
                        )
                    )
                }
            }

            changeColorAdd.setOnClickListener {
                viewModel.clickChangeColorButton()
            }

            buttonBack.setOnClickListener {
                viewModel.clickBackButton()
            }

            editor = richEditor
            editor.setPlaceholder("Type something...")
            editor.setPadding(0, 8, 0, 0)
            editor.setEditorFontSize(23)

            editor.setEditorFontColor(Color.WHITE)
            editor.focusEditor()

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

    private val homeScreenObserver = Observer<Unit> {
        findNavController().popBackStack()
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
            1 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_white)
            2 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_red)
            3 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_orange)
            4 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_yellow)
            5 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_green)
            6 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_blue)
            7 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_purple)
            8 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_500)
            9 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_purple12)
            10 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_purple2)
            11 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_2)
            12 -> binding.changeColorAdd.setBackgroundResource(R.drawable.bg_3)
        }
    }

}