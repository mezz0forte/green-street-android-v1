package kr.hs.dgsw.stac.greenstreet.features.post.resolved.adapter

import kr.hs.dgsw.stac.domain.model.solution.Solution
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseListAdapter
import kr.hs.dgsw.stac.greenstreet.databinding.ItemResolvedPostBinding
import kr.hs.dgsw.stac.greenstreet.features.post.resolved.adapter.callback.SolutionDiffUtilCallback

class SolutionAdapter(private val solutionItemAction: SolutionItemAction) : BaseListAdapter<Solution, ItemResolvedPostBinding>(R.layout.item_resolved_post, SolutionDiffUtilCallback) {

    override fun action(item: Solution, binding: ItemResolvedPostBinding) {
        binding.solution = item
        binding.layoutSolutionFrame.setOnClickListener {
            solutionItemAction.onClickContent(item.id)
        }
    }

    interface SolutionItemAction {
        fun onClickContent(id: Int)
        fun onClickCider(id: Long)
    }
}
