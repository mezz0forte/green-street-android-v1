package kr.hs.dgsw.stac.greenstreet.features.post.comment

import kr.hs.dgsw.stac.domain.model.comment.Comment
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseListAdapter
import kr.hs.dgsw.stac.greenstreet.databinding.ItemCommentBinding

class CommentAdapter : BaseListAdapter<Comment, ItemCommentBinding>(R.layout.item_comment, CommentDiffUtilCallback) {

    override fun action(item: Comment, binding: ItemCommentBinding) {
        binding.comment = item
    }
}
