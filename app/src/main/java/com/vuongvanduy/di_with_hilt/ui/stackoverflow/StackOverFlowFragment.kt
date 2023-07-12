package com.vuongvanduy.di_with_hilt.ui.stackoverflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vuongvanduy.di_with_hilt.base.fragment.BaseFragment
import com.vuongvanduy.di_with_hilt.databinding.FragmentStackOverFlowBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StackOverFlowFragment : BaseFragment() {

    private lateinit var dataBinding: FragmentStackOverFlowBinding

    private val viewModel by viewModels<StackOverFlowViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentStackOverFlowBinding.inflate(inflater, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
        return dataBinding.root
    }
}