package uz.gita.b5mynoteapp.presentation.screen.trash

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenTrashBinding
import uz.gita.b5mynoteapp.presentation.adapter.TrashAdapter
import uz.gita.b5mynoteapp.presentation.screen.trash.viewmodel.TrashViewModel
import uz.gita.b5mynoteapp.presentation.screen.trash.viewmodel.impl.TrashViewModelImpl

class TrashScreen : Fragment(R.layout.screen_trash) {
    private val binding by viewBinding(ScreenTrashBinding::bind)
    private val viewModel: TrashViewModel by viewModels<TrashViewModelImpl>()
    private lateinit var adapter: TrashAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openHomeLiveData.observe(viewLifecycleOwner, openHomeScreenObserver)
        viewModel.getAllTrashNotesLiveData.observe(viewLifecycleOwner, allTrashNotesObserver)
        viewModel.clearLiveData.observe(viewLifecycleOwner, clearObserver)
        adapter = TrashAdapter()

        binding.apply {
            recyclerTrash.adapter = adapter
            recyclerTrash.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter.setClickTrashButton {
                viewModel.clickTrashButton(it)
            }

            buttonBackTrash.setOnClickListener {
                viewModel.clickBackButton()
            }

            imageClear.setOnClickListener {
                viewModel.clickClearButton()
            }
        }
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigateUp()
    }

    private val allTrashNotesObserver = Observer<List<NoteEntity>> {
        adapter.submitList(it)

    }

    private val clearObserver = Observer<Unit> {
        Toast.makeText(requireContext(), "Cleared", Toast.LENGTH_SHORT)
    }
}