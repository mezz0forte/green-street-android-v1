package kr.hs.dgsw.stac.greenstreet.features.main

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun start() {
        setNav()
        defineViewEvent()
    }

    private fun setNav() {
        binding.bnvMain.background = null
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain
            .setupWithNavController(navController)
    }

    fun setNavVisible(demand: Boolean) {
        val viewState = if (demand) View.GONE else View.VISIBLE
        binding.bnvMain.visibility = viewState
        binding.tvWrite.visibility = viewState
    }

    private fun defineViewEvent() {
        bindingViewEvent { event ->
            when (event) {
                MainViewModel.EVENT_ON_CLICK_ADD_POST -> {
                    navController.navigate(R.id.addPostFragment)
                }
                MainViewModel.EVENT_ON_CLICK_USER -> {
                }
            }
        }
    }
}
