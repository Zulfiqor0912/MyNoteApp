package uz.gita.b5mynoteapp.presentation.screen.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.navigation.NavigationView
import uz.gita.b5mynoteapp.R
import uz.gita.b5mynoteapp.data.local.entity.NoteEntity
import uz.gita.b5mynoteapp.databinding.ScreenHomeBinding
import uz.gita.b5mynoteapp.presentation.adapter.HomeAdapter
import uz.gita.b5mynoteapp.presentation.dialog.ChangeColorDialog
import uz.gita.b5mynoteapp.presentation.dialog.MoreDialog
import uz.gita.b5mynoteapp.presentation.screen.home.viewmodel.HomeViewModel
import uz.gita.b5mynoteapp.presentation.screen.home.viewmodel.impl.HomeViewModelImpl


class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private lateinit var adapter: HomeAdapter
    private lateinit var navController: NavController
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.addScreenLiveData.observe(this, openAddNoteScreenObserver)
        viewModel.openSampleScreenLiveData.observe(this, openSampleObserver)
        viewModel.moreDialogLiveData.observe(this, openMoreDialogObserver)
        viewModel.menuLiveData.observe(this, menuObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.allNotesLiveData.observe(viewLifecycleOwner, allNotesObserver)

        adapter = HomeAdapter()
        binding.apply {

            drawer = drawerLayout
            this@HomeScreen.navigationView = navigationView
            navigationView.itemIconTintList = null
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            NavigationUI.setupWithNavController(navigationView, navController)
            navigationView.setNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.rating -> {
                        val uri: Uri =
                            Uri.parse("market://details?id=${requireContext().packageName}")
                        val goToMarket: Intent = Intent(Intent.ACTION_VIEW, uri)
                        goToMarket.addFlags(
                            Intent.FLAG_ACTIVITY_NO_HISTORY or
                                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                        )
                        try {
                            startActivity(goToMarket)
                        } catch (e: ActivityNotFoundException) {
                            startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=${requireContext().packageName}")
                                )
                            )
                        }
                        true
                    }

                    R.id.exit -> {
                        requireActivity().finish()
                        true
                    }

                    R.id.trashScreen -> {
                        findNavController().navigate(R.id.action_homeScreen_to_trashScreen)
                        true
                    }

                    R.id.archiveScreen -> {
                        findNavController().navigate(R.id.action_homeScreen_to_archiveScreen)
                        true
                    }

                    R.id.infoScreen -> {
                        findNavController().navigate(R.id.action_homeScreen_to_infoScreen2)
                        true
                    }

                    else -> false

                }
            }



            recyclerV.adapter = adapter
            recyclerV.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            addNoteBtn.setOnClickListener {
                viewModel.clickAddButton()
            }

            buttonMenu.setOnClickListener {
                viewModel.clickMenuButton()
            }

            adapter.setClickMoreButton {
                viewModel.clickMoreButton(it)
            }

            adapter.setClickItem {
                viewModel.clickItem(it)
            }

        }
    }

    private val openAddNoteScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_homeScreen_to_addScreen)
    }

    private val openMoreDialogObserver = Observer<NoteEntity> { note ->
        val dialog = MoreDialog(note)
        dialog.setClickDeleteButton {
            viewModel.deleteNote(note)
            dialog.dismiss()
        }

        dialog.setClickArchiveButton {
            viewModel.archiveNote(note)
            dialog.dismiss()
        }

        dialog.setClickChangeColorButton {
            val colorDialog = ChangeColorDialog()
            colorDialog.setClickColor1 {
                Log.d("CR", "1")
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor2 {
                Log.d("CR", "2")
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor3 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor4 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor5 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor6 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor7 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor8 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor9 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor10 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor11 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.setClickColor12 {
                viewModel.changeColor(note, it)
                colorDialog.dismiss()
            }
            colorDialog.show(childFragmentManager, "Change Color")
        }
        dialog.show(childFragmentManager, "Click")
    }


    private val allNotesObserver = Observer<List<NoteEntity>> {
        adapter.submitList(it)
    }

    private val menuObserver = Observer<Unit> {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private val openSampleObserver = Observer<NoteEntity> {
        findNavController().navigate(HomeScreenDirections.actionHomeScreenToSampleScreen(it))
    }
}