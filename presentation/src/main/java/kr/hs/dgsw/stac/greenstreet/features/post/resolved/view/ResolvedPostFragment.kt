package kr.hs.dgsw.stac.greenstreet.features.post.resolved.view

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentResolvedPostBinding
import kr.hs.dgsw.stac.greenstreet.features.post.resolved.adapter.SolutionAdapter
import kr.hs.dgsw.stac.greenstreet.features.post.resolved.vm.ResolvedPostViewModel

@AndroidEntryPoint
class ResolvedPostFragment : BaseFragment<FragmentResolvedPostBinding, ResolvedPostViewModel>(R.layout.fragment_resolved_post), SolutionAdapter.SolutionItemAction {
    override val viewModel: ResolvedPostViewModel by viewModels()
    override val hasBottomNav: Boolean = true

    private lateinit var solutionAdapter: SolutionAdapter

    override fun start() {
        observeLiveData()
        setSolutionAdapter()
        viewModel.getLatestSolution()
    }

    private fun observeLiveData() = with(viewModel) {
        solutionList.observe(this@ResolvedPostFragment) {
            if (it.isNotEmpty())
                solutionAdapter.submitList(it)
        }
    }

    private fun setSolutionAdapter() {
        solutionAdapter = SolutionAdapter(this)
        binding.rvResolvedPost.adapter = solutionAdapter
    }

    override fun onClickContent(id: Long) {
        val action = ResolvedPostFragmentDirections.actionMainResolvedPostToDetailResolvedPostFragment(id)
        findNavController().navigate(action)
    }

    override fun onClickCider(id: Long) {
        Toast.makeText(requireContext(), "${id}번 사이다 클릭", Toast.LENGTH_SHORT).show()
    }
}
