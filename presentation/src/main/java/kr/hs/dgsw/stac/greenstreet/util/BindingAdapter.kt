package kr.hs.dgsw.stac.greenstreet.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Locale
import kr.hs.dgsw.stac.greenstreet.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value=["latitude", "longitude"], requireAll = true)
    fun setGpsAddress(view: TextView, latitude: Double, longitude: Double) {
        view.text = view.context.myLocationGPSToAddress(latitude, longitude)
    }

    @JvmStatic
    @BindingAdapter("yearDateText")
    fun setYearDateText(view: TextView, date: String) {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        view.text = format.format(date)
    }

    @JvmStatic
    @BindingAdapter("profileImage")
    fun setProfileImage(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url ?: "")
            .error(R.drawable.ic_profile_default)
            .centerCrop()
            .into(view)
    }

}