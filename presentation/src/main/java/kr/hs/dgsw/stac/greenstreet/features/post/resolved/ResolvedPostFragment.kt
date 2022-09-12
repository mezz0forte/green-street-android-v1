package kr.hs.dgsw.stac.greenstreet.features.post.resolved

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentResolvedPostBinding

class ResolvedPostFragment : BaseFragment<FragmentResolvedPostBinding, ResolvedPostViewModel>(R.layout.fragment_resolved_post) {
    override val viewModel: ResolvedPostViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    override fun start() {

    }
}
