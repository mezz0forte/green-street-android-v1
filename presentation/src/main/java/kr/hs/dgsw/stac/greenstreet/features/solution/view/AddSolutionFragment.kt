package kr.hs.dgsw.stac.greenstreet.features.solution.view

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentAddSolutionBinding
import kr.hs.dgsw.stac.greenstreet.features.solution.vm.AddSolutionViewModel

@AndroidEntryPoint
class AddSolutionFragment : BaseFragment<FragmentAddSolutionBinding, AddSolutionViewModel>(R.layout.fragment_add_solution) {

    override val viewModel: AddSolutionViewModel by viewModels()

    private val navArgs: AddSolutionFragmentArgs by navArgs()

    override fun start() {
        observeViewEvent()
        viewModel.postingId.value = navArgs.postingId
    }

    private fun observeViewEvent() = bindingViewEvent { event ->

        when (event) {
            AddSolutionViewModel.EVENT_SUCCESS_ADD_SOLUTION -> {
                navigateToBack()
            }

            AddSolutionViewModel.EVENT_ON_CLICK_BACK -> {
                navigateToBack()
            }

            AddSolutionViewModel.EVENT_ON_CLICK_ADD -> {
                viewModel.addSolution()
            }
        }
    }

    private fun navigateToBack() {
        findNavController().popBackStack()
    }
}
