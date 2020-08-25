package com.nagarro.smarthomeapplication.viewmodel

import android.content.Context
import android.content.res.Resources
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.datasetmanager.PieEntryBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PieChartViewModel @ViewModelInject constructor(private val pieChartEntriesBuilder:PieEntryBuilder, @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {
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