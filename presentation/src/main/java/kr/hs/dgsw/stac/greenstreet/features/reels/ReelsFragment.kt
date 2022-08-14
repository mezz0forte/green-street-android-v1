package kr.hs.dgsw.stac.greenstreet.features.reels

import androidx.fragment.app.viewModels
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentReelsBinding

class ReelsFragment : BaseFragment<FragmentReelsBinding, ReelsViewModel>(R.layout.fragment_reels) {
    override val viewModel: ReelsViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    override fun start() {

    }
}