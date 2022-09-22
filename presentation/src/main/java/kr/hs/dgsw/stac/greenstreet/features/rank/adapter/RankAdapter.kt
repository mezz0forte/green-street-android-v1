package kr.hs.dgsw.stac.greenstreet.features.rank.adapter

import kr.hs.dgsw.stac.domain.model.rank.Rank
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseListAdapter
import kr.hs.dgsw.stac.greenstreet.databinding.ItemRankBinding
import kr.hs.dgsw.stac.greenstreet.features.rank.adapter.callback.RankDiffUtilCallback

class RankAdapter : BaseListAdapter<Rank, ItemRankBinding>(R.layout.item_rank, RankDiffUtilCallback) {
    override fun action(item: Rank, binding: ItemRankBinding) {
        binding.rank = item
    }
}