package uz.gita.b5mynoteapp.presentation.screen.sample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenNoteBinding
import uz.gita.b5mynoteapp.presentation.screen.sample.viewmodel.SampleViewModel
import uz.gita.b5mynoteapp.presentation.screen.sample.viewmodel.impl.SampleViewModelImpl


class SampleScreen : Fragment(R.layout.screen_note) {
    private val binding by viewBinding(ScreenNoteBinding::bind)
    private val viewModel: SampleViewModel by viewModels<SampleViewModelImpl>()
    private val args by navArgs<SampleScreenArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.editScreenLiveData.observe(viewLifecycleOwner, openEditScreenObserver)
        viewModel.homeScreenLiveData.observe(viewLifecycleOwner, openHomeScreenObserver)

        binding.apply {
            textTitleSample.text = args.note.title
            textContentSample.text = args.note.content

            buttonBackSample.setOnClickListener {
                viewModel.clickBackButton()
            }

            imageEdit.setOnClickListener {
                viewModel.clickEditButton(
                    NoteEntity(
                        id = args.note.id,
                        title = textTitleSample.text.toString(),
                        content = textContentSample.text.toString(),
                        noteColor = args.note.noteColor
                    )
                )
            }
        }
    }

    private val openEditScreenObserver = Observer<NoteEntity> {
        findNavController().navigate(SampleScreenDirections.actionSampleScreenToEditNoteScreen(it))
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}