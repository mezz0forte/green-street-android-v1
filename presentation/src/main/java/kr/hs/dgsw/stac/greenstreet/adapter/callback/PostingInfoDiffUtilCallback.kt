package kr.hs.dgsw.stac.greenstreet.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.post.PostingInfo

object PostingInfoDiffUtilCallback : DiffUtil.ItemCallback<PostingInfo>() {
    override fun areItemsTheSame(oldItem: PostingInfo, newItem: PostingInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostingInfo, newItem: PostingInfo): Boolean {
        return oldItem == newItem
    }
}