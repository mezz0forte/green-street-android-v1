package kr.hs.dgsw.stac.greenstreet.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kr.hs.dgsw.stac.greenstreet.BR
import kr.hs.dgsw.stac.greenstreet.features.main.MainActivity

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes private val layoutRes: Int) : Fragment() {

    protected lateinit var binding: B
    protected lateinit var mViewModel: VM
    protected abstract val viewModel: VM

    protected abstract fun start()
    protected abstract fun bindingViewEvent()

    protected open val hasBottomNav: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        start()
        bindingViewEvent()
        (activity as? MainActivity)?.setNavVisible(!hasBottomNav)
    }

    private fun setUp() {
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        binding.setVariable(BR.vm, mViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
}