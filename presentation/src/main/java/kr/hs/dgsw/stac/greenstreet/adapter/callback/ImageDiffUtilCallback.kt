package kr.hs.dgsw.stac.greenstreet.adapter.callback

import android.net.Uri
import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.stac.domain.model.post.Posting

object ImageDiffUtilCallback : DiffUtil.ItemCallback<Uri>() {
    override fun areItemsTheSame(oldItem: Uri, newItem: Uri): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Uri, newItem: Uri): Boolean {
        return oldItem == newItem
    }
}
