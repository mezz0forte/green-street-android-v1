package kr.hs.dgsw.stac.greenstreet.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.greenstreet.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["latitude", "longitude"], requireAll = true)
    fun setGpsAddress(view: TextView, latitude: Double?, longitude: Double?) {
        if (latitude == null || longitude == null)
            return
        view.text = view.context.myLocationGPSToAddress(latitude, longitude)
    }

    @JvmStatic
    @BindingAdapter("yearDateText")
    fun setYearDateText(view: TextView, date: String?) {
        date?.let {
            val format = LocalDate.parse(it, DateTimeFormatter.ISO_DATE_TIME)
            view.text = format.toString()
        }
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
