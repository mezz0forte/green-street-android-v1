package kr.hs.dgsw.stac.greenstreet.features.post.detail.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.photo.Photo

object TrashImageDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }


}