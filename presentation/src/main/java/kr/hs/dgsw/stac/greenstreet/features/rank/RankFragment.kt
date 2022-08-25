package kr.hs.dgsw.stac.greenstreet.features.rank

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentRankBinding

class RankFragment : BaseFragment<FragmentRankBinding, RankViewModel>(R.layout.fragment_rank) {
    override val viewModel: RankViewModel by viewModels()

    override fun start() {

        bindingViewEvent {
            when (it) {
                RankViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }
}