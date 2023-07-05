package uz.gita.b5mynoteapp.presentation.screen.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.databinding.ScreenSplashBinding
import uz.gita.b5mynoteapp.presentation.screen.splash.viewmodel.SplashViewModel
import uz.gita.b5mynoteapp.presentation.screen.splash.viewmodel.impl.SplashViewModelImpl


class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    private lateinit var h: Handler
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openHomeLiveData.observe(viewLifecycleOwner, openHomeScreenObserver)

        h = Handler(Looper.getMainLooper())
        h.postDelayed({
            viewModel.openHomeScreen()
        }, 1000)
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
    }
}