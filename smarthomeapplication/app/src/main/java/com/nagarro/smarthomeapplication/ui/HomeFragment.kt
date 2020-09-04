package com.nagarro.smarthomeapplication.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.viewmodel.PieChartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

private const val TAG = "Home"

@AndroidEntryPoint
class Home : Fragment(),View.OnClickListener  {
    /**
     * Viewmodel for LiveData.
     */
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

        //setting the description of pie chart
        val description = Description()
        description.text = "Energy Consumption by appliances (in Kwh $)"
        description.textSize = 15F
        pieChart.description = description

        //settings related to effects
        pieChart.isRotationEnabled = true
        pieChart.holeRadius = 50F
        pieChart.centerText = resources.getString(R.string.centre_Text)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.setCenterTextSize(18F)

        pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                val energyConsumed: String = e.toString().substring(e.toString().indexOf("y: ") + 1)
                Toast.makeText(
                    context,
                    "Energy Consumed in last 24hrs is $energyConsumed Kwh",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected() {

            }
        })
        /**
         * Observer for LiveData
         */
        model.getEntries().observe(viewLifecycleOwner, Observer<List<PieEntry>> {
            // attach the list of pieEntries to pie Data set.
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

            //add data set to pie chart
            val data = PieData(set)
            pieChart.data = data
            pieChart.invalidate() // refresh
        })

       //set on click listeners.
        ac_btn.setOnClickListener(this)
        refrigerator_btn.setOnClickListener(this)
        washingmachine_btn.setOnClickListener(this)
        light_btn.setOnClickListener(this)

    }

    /**
     * OnClick Listeners for buttons
     */
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.light_btn ->{
                val action = HomeDirections.homeToList(Constants.APPLIANCE_CATEGORY_LIGHT)
                Navigation.findNavController(p0).navigate(action)

            }
            R.id.ac_btn -> {
                val action = HomeDirections.homeToList(Constants.APPLIANCE_CATEGORY_AC)
                Navigation.findNavController(p0).navigate(action)

            }
            R.id.refrigerator_btn -> {
                val action = HomeDirections.homeToList(Constants.APPLIANCE_CATEGORY_REFRIGERATOR)
                Navigation.findNavController(p0).navigate(action)

            }
            R.id.washingmachine_btn -> {
                val action = HomeDirections.homeToList(Constants.APPLIANCE_CATEGORY_WASHINGMACHINE)
                Navigation.findNavController(p0).navigate(action)
            }
        }

    }


}