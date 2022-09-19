package kr.hs.dgsw.stac.greenstreet.features.post.resolved.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.solution.Solution

object SolutionDiffUtilCallback : DiffUtil.ItemCallback<Solution>() {

    override fun areItemsTheSame(oldItem: Solution, newItem: Solution): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Solution, newItem: Solution): Boolean {
        return oldItem.id == newItem.id
    }
}
