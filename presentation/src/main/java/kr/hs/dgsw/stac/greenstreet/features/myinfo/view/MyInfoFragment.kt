package kr.hs.dgsw.stac.greenstreet.features.myinfo.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentMyInfoBinding
import kr.hs.dgsw.stac.greenstreet.features.myinfo.adapter.MyPostingAdapter
import kr.hs.dgsw.stac.greenstreet.features.myinfo.vm.MyInfoViewModel

class MyInfoFragment : BaseFragment<FragmentMyInfoBinding, MyInfoViewModel>(R.layout.fragment_my_info) {

    override val viewModel: MyInfoViewModel by viewModels()
    private lateinit var myPostingAdapter: MyPostingAdapter

    override fun start() {
        settingMyPostingAdapter()

        bindingViewEvent {
            when (it) {
                MyInfoViewModel.EVENT_ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }

    private fun settingMyPostingAdapter() {
        myPostingAdapter = MyPostingAdapter()
        binding.vpMyPosting.adapter = myPostingAdapter
    }
}
