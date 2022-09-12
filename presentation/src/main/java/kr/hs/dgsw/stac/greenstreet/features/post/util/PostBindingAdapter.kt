package kr.hs.dgsw.stac.greenstreet.features.post.util

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
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

    @JvmStatic
    @BindingAdapter(value = ["comment_name", "comment_content"], requireAll = true)
    fun setCommentContent(view: TextView, comment_name: String, comment_content: String) {
        val mediumFont = Typeface.create(ResourcesCompat.getFont(view.context, R.font.noto_medium), Typeface.BOLD)
        val regular = Typeface.create(ResourcesCompat.getFont(view.context, R.font.noto_regular), Typeface.NORMAL)

        val content = SpannableString("$comment_name  $comment_content")
        content.setSpan(TypefaceSpan(mediumFont), 0, comment_name.length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        content.setSpan(TypefaceSpan(regular), comment_name.length, comment_content.length + comment_name.length + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        view.text = content
    }

}