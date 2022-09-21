package kr.hs.dgsw.stac.greenstreet.features.auth.register

import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.user.User
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityRegisterBinding

@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>(R.layout.activity_register) {
    override val viewModel: RegisterViewModel by viewModels()

    override fun start() {

        bindingViewEvent { event ->
            when (event) {
                RegisterViewModel.EVENT_ON_CLICK_BACK -> {
                    finish()
                }
                RegisterViewModel.EVENT_ON_CLICK_REGISTER -> {
                    viewModel.postRegister(
                        User(
                            "https://avatars.githubusercontent.com/u/80818534?v=4",
                            binding.etNickname.text.toString(),
                            binding.etPw.text.toString(),
                            binding.etPhone.text.toString()
                        )
                    )
                    finish()
                }
            }
        }
    }
}