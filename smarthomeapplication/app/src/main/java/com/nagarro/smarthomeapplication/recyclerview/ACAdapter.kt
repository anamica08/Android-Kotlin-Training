package com.nagarro.smarthomeapplication.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.dataholders.AcObjectHolder
import com.nagarro.smarthomeapplication.enums.Power_Status
import com.nagarro.smarthomeapplication.ui.ACDetailFragment
import com.nagarro.smarthomeapplication.ui.AC_ListFragmentDirections
import com.nagarro.smarthomeapplication.viewmodel.AcDetailsViewModel
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

private const val TAG = "ApplianceAdapter"

class ACAdapter(private val appliances: List<AC>) :
    RecyclerView.Adapter<ACAdapter.ApplianceViewHolder>() {




    class ApplianceViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplianceViewHolder {
        return ApplianceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return appliances.size
    }

    override fun onBindViewHolder(holder: ApplianceViewHolder, position: Int) {
        holder.view.applianceName_tv.text = appliances[position].appliance_name
        holder.view.location_tv.text = appliances[position].location
        holder.view.powerExpense_tv.text =
            appliances[position].average_consumption_per_hour.toString()
        holder.view.power_switch.isChecked = appliances[position].powerStatus == Power_Status.ON
        holder.view.setOnClickListener {
            //navigate to category view model i.e Ac here.
            Log.d(TAG, "onBindViewHolder: Clicked${appliances[position].appliance_name} ")
            //args.setArgument(appliances[position])
            val action = AC_ListFragmentDirections.actionACListFragmentToACDetailFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }


}