package kr.hs.dgsw.stac.greenstreet.features.rank.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.stac.domain.model.rank.Rank
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentRankBinding
import kr.hs.dgsw.stac.greenstreet.features.rank.adapter.RankAdapter
import kr.hs.dgsw.stac.greenstreet.features.rank.vm.RankViewModel

class RankFragment : BaseFragment<FragmentRankBinding, RankViewModel>(R.layout.fragment_rank) {
    override val viewModel: RankViewModel by viewModels()

    private lateinit var rankAdapter: RankAdapter

    override fun start() {

        setRankAdapter()

        bindingViewEvent {
            when (it) {
                RankViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }

    private fun setRankAdapter() {
        rankAdapter = RankAdapter()
        binding.rvRank.adapter = rankAdapter

        rankAdapter.submitList(
            listOf(
                Rank(4, "https://shop1.daumcdn.net/thumb/R500x500.q90/?fname=http%3A%2F%2Fshop1.daumcdn.net%2Fshophow%2Fp%2FE5111345485_11464862258.jpg", "까까내놔", "해결사"),
                Rank(5, "", "지나가는 학생", "해결사"),
                Rank(6, "https://ak-d.tripcdn.com/images/0106p2224m82pnm5cABC4_W_670_10000.jpg?proc=source/trip", "밤바다러버", "해결사"),
                Rank(7, "https://file1.bobaedream.co.kr/strange/2019/12/22/02/1576948027078.jpg", "앙대영", "환경지킴이"),
                Rank(8, "http://hestech.co.kr/data/file/product/31207923_IGBgpnkX_CUB_6252.jpg", "김도우", "환경지킴이"),
                Rank(9, "https://file1.bobaedream.co.kr/strange/2014/08/04/22/1407160054378.png", "세균맨사냥꾼", "사냥꾼")
            )
        )
    }
}
