package com.nagarro.smarthomeapplication.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.WashingMachine
import kotlinx.android.synthetic.main.list_item.view.*

class WashingMachineAdapter(private val appliances:List<WashingMachine>):
    RecyclerView.Adapter<WashingMachineAdapter.ApplianceViewHolder>() {


    class ApplianceViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplianceViewHolder {
        return ApplianceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        )
    }
    override fun getItemCount(): Int {
        return appliances.size
    }

    override fun onBindViewHolder(holder: ApplianceViewHolder, position: Int) {
        holder.view.applianceName_tv.text = appliances[position].appliance_name
        holder.view.location_tv.text = appliances[position].location
        holder.view.powerExpense_tv.text = appliances[position].average_consumption_per_hour.toString()
        //holder.view.power_switch.isChecked = appliances[position].power_status == Power_Status.ON
    }


}