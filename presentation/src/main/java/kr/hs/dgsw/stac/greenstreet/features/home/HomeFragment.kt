package kr.hs.dgsw.stac.greenstreet.features.home

import androidx.fragment.app.viewModels
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    override fun start() {

    }

    override fun bindingViewEvent() {

    }
}