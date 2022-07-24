package kr.hs.dgsw.stac.greenstreet.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.hs.dgsw.stac.greenstreet.BR
import kr.hs.dgsw.stac.greenstreet.R
import java.lang.reflect.ParameterizedType
import java.util.*

abstract class BaseActivity<B : ViewDataBinding, VM: BaseViewModel>(@LayoutRes private val layoutRes: Int) : AppCompatActivity() {
    protected lateinit var binding: B
    protected lateinit var mViewModel: VM

    protected abstract val viewModel: VM

    protected abstract fun observerViewModel()
    protected abstract fun bindingViewEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
        observerViewModel()
        bindingViewEvent()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        binding.setVariable(BR.vm, mViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(::binding.isInitialized) binding.unbind()
    }
}