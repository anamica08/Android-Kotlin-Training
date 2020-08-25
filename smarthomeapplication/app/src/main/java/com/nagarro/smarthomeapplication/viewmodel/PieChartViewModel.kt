package com.nagarro.smarthomeapplication.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.filereader.PieEntryBuilder

class PieChartViewModel(val resources: Resources) : ViewModel() {

    private val pieChartEntriesBuilder: PieEntryBuilder = PieEntryBuilder(resources)

    private val entries = MutableLiveData<List<PieEntry>>()
    val liveEntries:LiveData<List<PieEntry>>
    get() = entries

    fun getEntries(): LiveData<List<PieEntry>> {
        entries.value = pieChartEntriesBuilder.createPieEntries()
        return liveEntries
    }


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