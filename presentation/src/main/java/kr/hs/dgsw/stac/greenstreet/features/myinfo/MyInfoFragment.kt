package kr.hs.dgsw.stac.greenstreet.features.myinfo

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentMyInfoBinding

class MyInfoFragment : BaseFragment<FragmentMyInfoBinding, MyInfoViewModel>(R.layout.fragment_my_info) {
    override val viewModel: MyInfoViewModel by viewModels()

    override fun start() {

        bindingViewEvent {
            when (it) {
                MyInfoViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }
}