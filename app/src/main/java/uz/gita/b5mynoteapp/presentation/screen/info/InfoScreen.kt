package uz.gita.b5mynoteapp.presentation.screen.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.databinding.ScreenInfoBinding
import uz.gita.b5mynoteapp.presentation.screen.info.viewmodel.InfoViewModel
import uz.gita.b5mynoteapp.presentation.screen.info.viewmodel.impl.InfoViewModelImpl


class InfoScreen : Fragment(R.layout.screen_info) {
    private val binding by viewBinding(ScreenInfoBinding::bind)
    private val viewModel: InfoViewModel by viewModels<InfoViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openHomeScreenLiveData.observe(viewLifecycleOwner, openHomeScreenObserver)
        binding.buttonBackInfo.setOnClickListener {
            viewModel.clickBackButton()
        }
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}