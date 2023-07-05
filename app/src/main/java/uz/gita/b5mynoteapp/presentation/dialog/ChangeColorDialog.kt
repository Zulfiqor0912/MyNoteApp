package uz.gita.b5mynoteapp.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.databinding.DialogColorBinding


class ChangeColorDialog :
    DialogFragment(R.layout.dialog_color) {
    private val binding by viewBinding(DialogColorBinding::bind)
    private var clickColor1: ((color: Int) -> Unit)? = null
    private var clickColor2: ((color: Int) -> Unit)? = null
    private var clickColor3: ((color: Int) -> Unit)? = null
    private var clickColor4: ((color: Int) -> Unit)? = null
    private var clickColor5: ((color: Int) -> Unit)? = null
    private var clickColor6: ((color: Int) -> Unit)? = null
    private var clickColor7: ((color: Int) -> Unit)? = null
    private var clickColor8: ((color: Int) -> Unit)? = null
    private var clickColor9: ((color: Int) -> Unit)? = null
    private var clickColor10: ((color: Int) -> Unit)? = null
    private var clickColor11: ((color: Int) -> Unit)? = null
    private var clickColor12: ((color: Int) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogCh = super.onCreateDialog(savedInstanceState)
        dialogCh.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialogCh
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            colorWhite.setOnClickListener {
                clickColor1?.invoke(1)
                dismiss()
            }

            colorRed.setOnClickListener {
                clickColor2?.invoke(2)
                dismiss()
            }

            colorOrange.setOnClickListener {
                clickColor3?.invoke(3)
                dismiss()
            }

            colorYellow.setOnClickListener {
                clickColor4?.invoke(4)
                dismiss()
            }

            colorGreen.setOnClickListener {
                clickColor5?.invoke(5)
                dismiss()
            }

            colorBlue.setOnClickListener {
                clickColor6?.invoke(6)
                dismiss()
            }

            color3.setOnClickListener {
                clickColor12?.invoke(12)
                dismiss()
            }

            colorPurple.setOnClickListener {
                clickColor7?.invoke(7)
                dismiss()
            }

            color500.setOnClickListener {
                clickColor8?.invoke(8)
                dismiss()
            }

            colorPurple2.setOnClickListener {
                clickColor9?.invoke(9)
                dismiss()
            }

            color1.setOnClickListener {
                clickColor10?.invoke(10)
                dismiss()
            }

            color2.setOnClickListener {
                clickColor11?.invoke(11)
                dismiss()
            }
        }

    }


    fun setClickColor1(block: (color: Int) -> Unit) {
        clickColor1 = block
    }

    fun setClickColor2(block: (color: Int) -> Unit) {
        clickColor2 = block
    }

    fun setClickColor3(block: (color: Int) -> Unit) {
        clickColor3 = block
    }

    fun setClickColor4(block: (color: Int) -> Unit) {
        clickColor4 = block
    }

    fun setClickColor5(block: (color: Int) -> Unit) {
        clickColor5 = block
    }

    fun setClickColor6(block: (color: Int) -> Unit) {
        clickColor6 = block
    }

    fun setClickColor7(block: (color: Int) -> Unit) {
        clickColor7 = block
    }

    fun setClickColor8(block: (color: Int) -> Unit) {
        clickColor8 = block
    }

    fun setClickColor9(block: (color: Int) -> Unit) {
        clickColor9 = block
    }

    fun setClickColor10(block: (color: Int) -> Unit) {
        clickColor10 = block
    }

    fun setClickColor11(block: (color: Int) -> Unit) {
        clickColor11 = block
    }

    fun setClickColor12(block: (color: Int) -> Unit) {
        clickColor12 = block
    }

}