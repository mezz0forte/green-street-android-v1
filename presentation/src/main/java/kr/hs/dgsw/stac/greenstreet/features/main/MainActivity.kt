package kr.hs.dgsw.stac.greenstreet.features.main

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        binding.bnvMain.background = null

    }

    override fun bindingViewEvent() {}
}