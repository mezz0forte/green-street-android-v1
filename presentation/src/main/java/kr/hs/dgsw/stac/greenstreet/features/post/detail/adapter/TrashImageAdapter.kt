package kr.hs.dgsw.stac.greenstreet.features.post.detail.adapter

import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.domain.model.photo.Photo
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseListAdapter
import kr.hs.dgsw.stac.greenstreet.databinding.ItemTrashImageBinding
import kr.hs.dgsw.stac.greenstreet.features.post.detail.adapter.callback.TrashImageDiffUtilCallback

class TrashImageAdapter : BaseListAdapter<Photo, ItemTrashImageBinding>(R.layout.item_trash_image, TrashImageDiffUtilCallback) {

    override fun action(item: Photo, binding: ItemTrashImageBinding) {
        Glide.with(binding.ivTrash.context)
            .load(item.imageUrl)
            .centerCrop()
            .error(R.drawable.img_no_image)
            .into(binding.ivTrash)
    }
}