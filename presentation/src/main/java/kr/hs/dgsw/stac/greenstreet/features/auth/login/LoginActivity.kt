package kr.hs.dgsw.stac.greenstreet.features.auth.login

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.user.Login
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityLoginBinding
import kr.hs.dgsw.stac.greenstreet.features.auth.register.RegisterActivity
import kr.hs.dgsw.stac.greenstreet.features.main.MainActivity
import kr.hs.dgsw.stac.greenstreet.widget.GreenStreetApplication

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
            Log.d("TAGTAG", token.value!!.access_token)
            GreenStreetApplication.prefs.setAccessToken(token.value!!.access_token)
            GreenStreetApplication.prefs.setRefreshToken(token.value!!.refresh_token)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}