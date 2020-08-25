package com.nagarro.smarthomeapplication.ui

import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.viewmodel.PieChartViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import dagger.hilt.android.AndroidEntryPoint
import javax.annotation.Resource

private const val TAG = "Home"

@AndroidEntryPoint
class Home : Fragment() {

    private val model: PieChartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        //add colors
        val colors: MutableList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.AC, null))
        colors.add(resources.getColor(R.color.Light, null))
        colors.add(resources.getColor(R.color.Regrigertaor, null))
        colors.add(resources.getColor(R.color.WashingMachine, null))


        val description = Description()
        description.text = "Energy Consumption by appliances (in Kwh $)"
        description.textSize = 15F
        pieChart.description = description
//        pieChart.description.setPosition(0F,0F)
        pieChart.isRotationEnabled = true
        pieChart.holeRadius = 50F
        pieChart.setTransparentCircleAlpha(0)
        pieChart.setCenterTextSize(15F)

        pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                val energyConsumed: String = e.toString().substring(e.toString().indexOf("y: ") + 1)
                Toast.makeText(
                    context, "Energy Consumed in last 24hrs is $energyConsumed Kwh",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected() {

            }
        })

        model.getEntries().observe(viewLifecycleOwner, Observer<List<PieEntry>> {
            val set = PieDataSet(it, null)
            set.sliceSpace = 2F
            set.valueTextColor = resources.getColor(R.color.Text,null)
            set.valueTextSize = 20F
            set.setColors(colors)
            //add legend
            val legend = pieChart.legend
            legend.isEnabled = true
            legend.formSize = 15F
            legend.form = (Legend.LegendForm.SQUARE)
            legend.textSize = 13F
            //legend.position = Legend.LegendDirection.Left
            Log.d(TAG, "onActivityCreated: here outside $set")

            val data = PieData(set)
            pieChart.data = data
            pieChart.invalidate() // refresh
        })

        ac_btn.setOnClickListener {

        }
    }
    
    
}