package kr.hs.dgsw.stac.greenstreet.features.post

import androidx.fragment.app.viewModels
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentPostingBinding

class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>(R.layout.fragment_posting) {
    override val viewModel: PostingViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    override fun start() {

    }
}