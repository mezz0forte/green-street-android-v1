package kr.hs.dgsw.stac.greenstreet.features.post.resolve

import androidx.fragment.app.viewModels
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentResolvePostBinding

class ResolvePostFragment : BaseFragment<FragmentResolvePostBinding, ResolvePostViewModel>(R.layout.fragment_resolve_post) {
    override val viewModel: ResolvePostViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    override fun start() {

    }
}