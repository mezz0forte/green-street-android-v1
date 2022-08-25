package kr.hs.dgsw.stac.greenstreet.features.post.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentDetailPostBinding

class DetailPostFragment : BaseFragment<FragmentDetailPostBinding, DetailPostViewModel>(R.layout.fragment_detail_post) {
    override val viewModel: DetailPostViewModel by viewModels()

    override fun start() {
        val args: DetailPostFragmentArgs by navArgs()
        binding.tvId.text = args.postingId.toString()

        bindingViewEvent {
            when (it) {
                DetailPostViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }
}
