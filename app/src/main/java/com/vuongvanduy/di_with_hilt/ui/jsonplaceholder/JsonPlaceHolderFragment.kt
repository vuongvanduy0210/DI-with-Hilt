package com.vuongvanduy.di_with_hilt.ui.jsonplaceholder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vuongvanduy.di_with_hilt.base.fragment.BaseFragment
import com.vuongvanduy.di_with_hilt.databinding.FragmentJsonPlaceHolderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JsonPlaceHolderFragment : BaseFragment() {

    private lateinit var dataBinding: FragmentJsonPlaceHolderBinding

    private val viewModel by viewModels<JsonPlaceHolderViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentJsonPlaceHolderBinding.inflate(inflater)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
        return dataBinding.root
    }
}