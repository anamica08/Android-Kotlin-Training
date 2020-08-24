package com.nagarro.smarthomeapplication.ui

//import com.nagarro.smarthomeapplication.service.Readings

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.filereader.PieEntryBuilder
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val description = Description()
        description.text = "Energy Consumption by appliances (in Kwh $)"
        description.textSize = 16F
        pieChart.description = description
        pieChart.isRotationEnabled = true
        pieChart.holeRadius=30F
        pieChart.setTransparentCircleAlpha(0)
        pieChart.centerText = "Energy expenditure"
        pieChart.setCenterTextSize(15F)

        pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                val energyConsumed:String = e.toString().substring(e.toString().indexOf("y: ") +1)
                Toast.makeText(this@MainActivity,"Energy Consumed in last 24hrs is $energyConsumed Kwh",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected() {

            }
        })

        val acPieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.ac, "ac")
        val LightPieEntry= PieEntryBuilder(resources).getEntriesFromCSV(R.raw.light, "Light")
        val refrigeratorPieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.refrigerator,"Refrigerator")
        val washingMachinePieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.washing_machine,"Washing Machine")
        val entries: MutableList<PieEntry> = ArrayList()
        entries.add(LightPieEntry)
        entries.add(acPieEntry)
        entries.add(refrigeratorPieEntry)
        entries.add(washingMachinePieEntry)
        val set= PieDataSet(entries, null)
        set.sliceSpace = 2F
        set.valueTextSize = 13F

        //add colors
        val colors:MutableList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.AC,null))
        colors.add(resources.getColor(R.color.Light,null))
        colors.add(resources.getColor(R.color.Regrigertaor,null))
        colors.add(resources.getColor(R.color.WashingMachine,null))
        set.setColors(colors)

        //add legend
        val legend = pieChart.legend
        legend.form = (Legend.LegendForm.CIRCLE)
        //legend.position = Legend.LegendDirection.Left


        val data = PieData(set)
        pieChart.data = data
        pieChart.invalidate() // refresh

//        lineChart.data = LineData(
//            ACdataset,LightDataset
//        )
//        val ACColor = resources.getColor(R.color.ac,null)
//        val LightColor = resources.getColor(R.color.Light,null)
//
//        DatasetConfig().configureSetLayout(ACdataset,ACColor)
//        DatasetConfig().configureSetLayout(LightDataset,LightColor)

//        val readings = Readings()
//        Log.d(TAG, "onCreate: $readings")
//        val readingstring = readings.getdata(applicationContext)
//        display_tv.movementMethod= ScrollingMovementMethod()
//        display_tv.setText(readingstring)
    }
}