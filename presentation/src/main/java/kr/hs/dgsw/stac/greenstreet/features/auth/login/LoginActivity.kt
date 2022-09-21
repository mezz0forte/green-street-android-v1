package kr.hs.dgsw.stac.greenstreet.features.auth.login

import android.content.Intent
import androidx.activity.viewModels
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseActivity
import kr.hs.dgsw.stac.greenstreet.databinding.ActivityLoginBinding
import kr.hs.dgsw.stac.greenstreet.features.auth.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel by viewModels()

    override fun start() {

        bindingViewEvent { event ->
            when (event) {
                LoginViewModel.EVENT_ON_CLICK_REGISTER -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}