package kr.hs.dgsw.stac.greenstreet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.adapter.callback.PostingDiffUtilCallback
import kr.hs.dgsw.stac.greenstreet.databinding.ItemHomePostingBinding

class HomePostAdapter : ListAdapter<Posting, HomePostAdapter.HomePostViewHolder>(PostingDiffUtilCallback) {
    inner class HomePostViewHolder(val binding: ItemHomePostingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Posting) {
            // TODO : 1. 서버에서 위치 주소 받거나 GPS 주소로 해독하기 2. 이미지 받기
            binding.posting = item

            Glide.with(binding.ivPhoto)
                .load("http://mediahub.seoul.go.kr/wp-content/uploads/2016/10/483b09a867e5beee49765af7423ecbbb.jpg")
                .error(R.drawable.img_no_image)
                .centerCrop()
                .into(binding.ivPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePostViewHolder {
        return HomePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_posting,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomePostViewHolder, position: Int) {
       return holder.bind(getItem(position))
    }
}