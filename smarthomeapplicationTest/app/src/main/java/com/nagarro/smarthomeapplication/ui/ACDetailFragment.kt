package com.nagarro.smarthomeapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.dataholders.AcObjectHolder
import com.nagarro.smarthomeapplication.viewmodel.AcDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_a_c_detail.*
import javax.inject.Inject

@AndroidEntryPoint
class ACDetailFragment : Fragment() {

    @Inject
    lateinit var args:AcObjectHolder

    private val viewModel:AcDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_c_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel.liveTemp.observe(viewLifecycleOwner,{
//            temp_tv.setText(it.toString())
//        })
    }


}