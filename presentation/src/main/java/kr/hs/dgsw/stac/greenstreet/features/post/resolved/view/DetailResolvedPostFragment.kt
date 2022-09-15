package kr.hs.dgsw.stac.greenstreet.features.post.resolved.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentDetailResolvedPostBinding
import kr.hs.dgsw.stac.greenstreet.features.post.comment.CommentAdapter
import kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm.DetailResolvedPostViewModel

@AndroidEntryPoint
class DetailResolvedPostFragment : BaseFragment<FragmentDetailResolvedPostBinding, DetailResolvedPostViewModel>(
    R.layout.fragment_detail_resolved_post
) {
    override val viewModel: DetailResolvedPostViewModel by viewModels()
    private val navArgs: DetailResolvedPostFragmentArgs by navArgs()
    private lateinit var commentAdapter: CommentAdapter

    override fun start() {
        observeLiveData()
        setCommentAdapter()
        viewModel.getSolutionById(navArgs.id)

        bindingViewEvent { event ->
            when (event) {
                DetailResolvedPostViewModel.ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }

    private fun observeLiveData() = with(viewModel) {
        solution.observe(this@DetailResolvedPostFragment) {
            binding.solution = it
        }
    }

    private fun setCommentAdapter() {
        commentAdapter = CommentAdapter()
        binding.rvComments.adapter = commentAdapter
    }
}
