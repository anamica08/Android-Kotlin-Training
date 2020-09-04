package com.nagarro.smarthomeapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nagarro.smarthomeapplication.R
//import com.nagarro.smarthomeapplication.databinding.FragmentACDetailsBinding
import com.nagarro.smarthomeapplication.viewmodel.AcDetailsViewModel


class ACDetailsFragment : Fragment() {

    private val model:AcDetailsViewModel by viewModels()
    //private var fragmentBinding: FragmentACDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_a_c_details, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }




}