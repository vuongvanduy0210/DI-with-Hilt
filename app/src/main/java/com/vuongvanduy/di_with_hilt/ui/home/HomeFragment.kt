package com.vuongvanduy.di_with_hilt.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vuongvanduy.di_with_hilt.R

class HomeFragment : Fragment() {

    private lateinit var view: View
    private lateinit var btJPH: Button
    private lateinit var btSOF: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_home, container, false)

        btJPH = view.findViewById(R.id.bt_jph)
        btSOF = view.findViewById(R.id.bt_sof)
        btJPH.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_jsonPlaceHolderFragment2)
        }
        btSOF.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_stackOverFlowFragment3)
        }
        return view
    }
}