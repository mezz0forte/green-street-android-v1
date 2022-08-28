package kr.hs.dgsw.stac.greenstreet.adapter

import android.net.Uri
import android.util.Log
import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.adapter.callback.ImageDiffUtilCallback
import kr.hs.dgsw.stac.greenstreet.base.BaseListAdapter
import kr.hs.dgsw.stac.greenstreet.databinding.ItemImagePostingBinding

class AddImageAdapter : BaseListAdapter<Uri, ItemImagePostingBinding>(R.layout.item_image_posting, ImageDiffUtilCallback) {
    override fun action(item: Uri, binding: ItemImagePostingBinding) {
        Glide.with(binding.ivImage)
            .load(item)
            .error(R.drawable.img_no_image)
            .into(binding.ivImage)
    }
}