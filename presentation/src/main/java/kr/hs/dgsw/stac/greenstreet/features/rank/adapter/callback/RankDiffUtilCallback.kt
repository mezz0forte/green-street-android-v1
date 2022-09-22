package kr.hs.dgsw.stac.greenstreet.features.rank.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.rank.Rank

object RankDiffUtilCallback : DiffUtil.ItemCallback<Rank>() {
    override fun areItemsTheSame(oldItem: Rank, newItem: Rank): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Rank, newItem: Rank): Boolean {
        return oldItem == newItem
    }

}