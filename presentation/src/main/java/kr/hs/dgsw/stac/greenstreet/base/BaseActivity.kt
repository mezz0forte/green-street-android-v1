package kr.hs.dgsw.stac.greenstreet.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kr.hs.dgsw.stac.greenstreet.BR

abstract class BaseActivity<B : ViewDataBinding, VM: BaseViewModel>(@LayoutRes private val layoutRes: Int) : AppCompatActivity() {
    protected lateinit var binding: B
    protected lateinit var mViewModel: VM

    protected abstract val viewModel: VM

    protected abstract fun start()
    protected fun bindingViewEvent(action: (event: Any) -> Unit) {
        viewModel.viewEvent.observe(this) {
            it.getContentIfNotHandled()?.let { event ->
                action.invoke(event)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
        start()
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