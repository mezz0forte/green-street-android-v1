package kr.hs.dgsw.stac.greenstreet.features.myinfo.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.util.myLocationGPSToAddress

object MyInfoBindingAdapter {

    @JvmStatic
    @BindingAdapter("posting_img")
    fun setPostingImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.img_no_image)
            .centerCrop()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter(value = ["latitude", "longitude"], requireAll = true)
    fun setGPStoAddress(view: TextView, latitude: Double, longitude: Double) {
        view.text = view.context.myLocationGPSToAddress(latitude, longitude)
    }
}