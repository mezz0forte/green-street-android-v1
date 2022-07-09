package kr.hs.dgsw.stac.greenstreet.features.main

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {

    }

    override fun bindingViewEvent() {}
}