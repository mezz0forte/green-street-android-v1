package kr.hs.dgsw.stac.greenstreet.features.auth.login

import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityLoginBinding
import kr.hs.dgsw.stac.greenstreet.features.auth.register.RegisterActivity

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel by viewModels()

    override fun start() {

        observeLiveData()

        bindingViewEvent { event ->
            when (event) {
                LoginViewModel.EVENT_ON_CLICK_REGISTER -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
                LoginViewModel.EVENT_ON_CLICK_LOGIN -> {
                    viewModel.postLogin(
                        Login(
                            binding.etPw.text.toString(),
                            binding.etPhone.text.toString()
                        )
                    )
                }
            }
        }
    }

    private fun observeLiveData() = with(viewModel) {
        token.observe(this@LoginActivity) {

        }
    }
}