package kr.hs.dgsw.stac.greenstreet.features.myinfo.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.post.Posting

object MyPostingDiffUtilCallback : DiffUtil.ItemCallback<Posting>() {
    override fun areItemsTheSame(oldItem: Posting, newItem: Posting): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Posting, newItem: Posting): Boolean {
        return oldItem.id == newItem.id
    }
}
