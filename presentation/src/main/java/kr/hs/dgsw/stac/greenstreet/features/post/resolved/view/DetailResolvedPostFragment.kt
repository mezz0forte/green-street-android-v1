package kr.hs.dgsw.stac.greenstreet.features.post.resolved.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentDetailResolvedPostBinding
import kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm.DetailResolvedPostViewModel

class DetailResolvedPostFragment : BaseFragment<FragmentDetailResolvedPostBinding, DetailResolvedPostViewModel>(
    R.layout.fragment_detail_resolved_post
) {
    override val viewModel: DetailResolvedPostViewModel by viewModels()
    private val navArgs: DetailResolvedPostFragmentArgs by navArgs()

    override fun start() {

        bindingViewEvent { event ->
            when(event) {
                DetailResolvedPostViewModel.ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }

}