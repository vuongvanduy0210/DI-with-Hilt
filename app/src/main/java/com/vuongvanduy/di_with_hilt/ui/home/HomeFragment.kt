package com.vuongvanduy.di_with_hilt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.vuongvanduy.di_with_hilt.R
import com.vuongvanduy.di_with_hilt.base.fragment.BaseFragment
import com.vuongvanduy.di_with_hilt.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

class HomeFragment : BaseFragment() {

    private lateinit var dataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentHomeBinding.inflate(inflater)
        dataBinding.btJsonPlaceHolder.setOnClickListener {
            openScreen()
        }
        return dataBinding.root
    }

    private fun openScreen() {

    }


}