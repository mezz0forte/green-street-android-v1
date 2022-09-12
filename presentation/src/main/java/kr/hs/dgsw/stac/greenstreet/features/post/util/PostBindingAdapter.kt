package kr.hs.dgsw.stac.greenstreet.features.post.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.greenstreet.R

object PostBindingAdapter {

    @JvmStatic
    @BindingAdapter("beforeImage")
    fun setBeforeImage(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url ?: "")
            .error(R.drawable.background_after)
            .centerCrop()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("afterImage")
    fun setAfterImage(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url ?: "")
            .error(R.drawable.background_after)
            .centerCrop()
            .into(view)
    }

}