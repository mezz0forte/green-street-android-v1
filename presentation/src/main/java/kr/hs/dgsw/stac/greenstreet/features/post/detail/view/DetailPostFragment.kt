package kr.hs.dgsw.stac.greenstreet.features.post.detail.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.comment.Comment
import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.domain.model.solution.SolutionType
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentDetailPostBinding
import kr.hs.dgsw.stac.greenstreet.features.post.detail.adapter.TrashImageAdapter
import kr.hs.dgsw.stac.greenstreet.features.post.detail.vm.DetailPostViewModel

@AndroidEntryPoint
class DetailPostFragment : BaseFragment<FragmentDetailPostBinding, DetailPostViewModel>(R.layout.fragment_detail_post) {
    override val viewModel: DetailPostViewModel by viewModels()

    private lateinit var trashImageAdapter: TrashImageAdapter

    override fun start() {
        val args: DetailPostFragmentArgs by navArgs()
        viewModel.getPostingById(args.postingId)
        observeLiveData()
        setTrashImageAdapter()


        bindingViewEvent {
            when (it) {
                DetailPostViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }

    private fun observeLiveData() = with(viewModel) {
        posting.observe(this@DetailPostFragment) { posting ->
            binding.posting = posting
            trashImageAdapter.submitList(posting.photoList)
            
            binding.solution = Solution(
                1,
                "",
                SolutionType.IMAGE,
                posting.user,
                posting,
                likeCount = 1,
                commentList = listOf(
                    Comment(1, "d", posting.user, createdAt = "2022-09-20T18:09:38")
                ),
                createdAt = "2022-09-20T18:09:38"
            )
        }
    }

    private fun setTrashImageAdapter() {
        trashImageAdapter = TrashImageAdapter()
        binding.vpTreshImage.adapter = trashImageAdapter
        binding.indicatorTrashImage.attachTo(binding.vpTreshImage)
    }

}
