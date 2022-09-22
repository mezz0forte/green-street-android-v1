package kr.hs.dgsw.stac.greenstreet.features.post.detail.view

import android.opengl.Visibility
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
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

                DetailPostViewModel.EVENT_ON_CLICK_SOLUTION -> {
                    viewModel.postingId.value?.let { postingId ->
                        findNavController().navigate(DetailPostFragmentDirections.actionDetailPostFragmentToDetailResolvedPostFragment(postingId))
                    }
                }

                DetailPostViewModel.EVENT_ADD_SOLUTION -> {
                    viewModel.postingId.value?.let { postingId ->
                        findNavController().navigate(DetailPostFragmentDirections.actionDetailPostFragmentToAddSolutionFragment(postingId))
                    }
                }
            }
        }
    }

    private fun observeLiveData() = with(viewModel) {
        posting.observe(this@DetailPostFragment) { posting ->
            getSolutionByPostingId(posting.id.toInt())
            binding.posting = posting
            postingId.value = posting.id
            trashImageAdapter.submitList(posting.photoList)
        }

        solution.observe(this@DetailPostFragment) { solution ->
            binding.solution = solution
            binding.layoutSolutionFrame.visibility = View.VISIBLE
            binding.btnAddSolution.visibility = View.GONE
        }

        onError.observe(this@DetailPostFragment) {
            binding.layoutSolutionFrame.visibility = View.GONE
            binding.btnAddSolution.visibility = View.VISIBLE
        }
    }

    private fun setTrashImageAdapter() {
        trashImageAdapter = TrashImageAdapter()
        binding.vpTreshImage.adapter = trashImageAdapter
        binding.indicatorTrashImage.attachTo(binding.vpTreshImage)
    }
}
