package kr.hs.dgsw.stac.greenstreet.features.post.add

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentAddPostBinding

class AddPostFragment : BaseFragment<FragmentAddPostBinding, AddPostViewModel>(R.layout.fragment_add_post) {
    override val viewModel: AddPostViewModel by viewModels()

    override fun start() {

        bindingViewEvent { event ->
            when (event) {
                AddPostViewModel.EVENT_ON_CLICK_BACK -> {
                    findNavController().popBackStack()
                }
            }
        }
    }
}
