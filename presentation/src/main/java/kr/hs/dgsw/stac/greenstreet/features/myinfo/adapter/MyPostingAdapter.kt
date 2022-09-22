package kr.hs.dgsw.stac.greenstreet.features.myinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.databinding.ItemMyPostingBinding
import kr.hs.dgsw.stac.greenstreet.features.myinfo.adapter.callback.MyPostingDiffUtilCallback

class MyPostingAdapter : ListAdapter<Posting, MyPostingAdapter.MyPostingViewHolder>(MyPostingDiffUtilCallback) {

    inner class MyPostingViewHolder(private val binding: ItemMyPostingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(posting: Posting) {
            binding.posting = posting
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostingViewHolder {
        return MyPostingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_my_posting,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyPostingViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}
