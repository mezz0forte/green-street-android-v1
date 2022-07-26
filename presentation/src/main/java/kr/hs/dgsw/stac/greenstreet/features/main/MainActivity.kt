package kr.hs.dgsw.stac.greenstreet.features.main

import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun start() {
        setNav()
    }

    private fun setNav() {
        binding.bnvMain.background = null
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain
            .setupWithNavController(navController)
    }

    fun setNavVisible(demand: Boolean) {
        binding.fabAddPost.isInvisible = demand
        binding.baMain.isInvisible = demand
        binding.bnvMain.isInvisible = demand
    }

    override fun bindingViewEvent() {
        with(viewModel) {
            viewEvent.observe(this@MainActivity) {
                it.getContentIfNotHandled()?.let { event ->
                    when (event) {
                        MainViewModel.EVENT_ON_CLICK_ADD_POST -> {
                            navController.navigate(R.id.addPostFragment)
                        }
                    }
                }
            }
        }
    }
}