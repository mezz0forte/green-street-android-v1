package kr.hs.dgsw.stac.greenstreet.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.post.Posting

object PostingDiffUtilCallback : DiffUtil.ItemCallback<Posting>() {
    override fun areItemsTheSame(oldItem: Posting, newItem: Posting): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Posting, newItem: Posting): Boolean {
        return oldItem == newItem
    }
}