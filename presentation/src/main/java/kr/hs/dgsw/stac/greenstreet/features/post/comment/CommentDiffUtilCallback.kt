package kr.hs.dgsw.stac.greenstreet.features.post.comment

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.comment.Comment

object CommentDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {

    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }
}
