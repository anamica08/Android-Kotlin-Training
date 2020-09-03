package com.nagarro.smarthomeapplication.ui

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.Appliance
import com.nagarro.smarthomeapplication.recyclerview.ApplianceAdapter
import com.nagarro.smarthomeapplication.viewmodel.ApplianceViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_appliancelist.*


private const val TAG = "AC_ListFragment"
/**
 * A simple [Fragment] subclass.
 */

@AndroidEntryPoint
class AC_ListFragment : Fragment() {


    private val model:ApplianceViewModel by viewModels()
    private var argCategory:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       arguments?.let {
           argCategory = AC_ListFragmentArgs.fromBundle(it).applianceCategory.toString()
           //argCategory =Appl

       }
        Log.d(TAG, "onActivityCreated: arguments : $arguments")

        applianceRecyclerView.setHasFixedSize(true)
        applianceRecyclerView.layoutManager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL
        )
        val itemDecor = DividerItemDecoration(context, HORIZONTAL)
        applianceRecyclerView.addItemDecoration(itemDecor)

        argCategory?.let {
            model.getAllAppliance(it).observe(viewLifecycleOwner, Observer<List<Appliance>> {
//                for (item in it) {
//                    Log.d(TAG, "onActivityCreated: ${item.toString()}")
//                }
                applianceRecyclerView.adapter =
                    activity?.applicationContext?.let { it1 -> ApplianceAdapter(it) }

            })
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appliancelist, container, false)
    }


}