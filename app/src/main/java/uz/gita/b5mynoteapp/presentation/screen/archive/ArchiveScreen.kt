package uz.gita.b5mynoteapp.presentation.screen.archive

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenArchiveBinding
import uz.gita.b5mynoteapp.presentation.adapter.ArchiveAdapter
import uz.gita.b5mynoteapp.presentation.screen.archive.viewmodel.ArchiveViewModel
import uz.gita.b5mynoteapp.presentation.screen.archive.viewmodel.impl.ArchiveViewModelImpl



class ArchiveScreen : Fragment(R.layout.screen_archive) {
    private val binding by viewBinding(ScreenArchiveBinding::bind)
    private val viewModel: ArchiveViewModel by viewModels<ArchiveViewModelImpl>()
    private lateinit var adapter: ArchiveAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.archiveNotesLiveData.observe(viewLifecycleOwner, archiveAllNotesObserver)
        viewModel.openHomeScreenLiveData.observe(viewLifecycleOwner, openHomeScreenObserver)
        adapter = ArchiveAdapter()

        binding.apply {
            recyclerArchive.adapter = adapter
            recyclerArchive.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            adapter.setClickArchive {
                viewModel.clickUnArchive(it)
            }

            buttonBackArchive.setOnClickListener {
                viewModel.clickBackButton()
            }

        }
    }


    private val archiveAllNotesObserver = Observer<List<NoteEntity>> {
        adapter.submitList(it)
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}