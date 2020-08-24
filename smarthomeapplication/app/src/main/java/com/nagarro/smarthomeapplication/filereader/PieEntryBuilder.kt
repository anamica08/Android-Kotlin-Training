package com.nagarro.smarthomeapplication.filereader

import android.content.res.Resources
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.model.data.EnergyConsumption

class PieEntryBuilder(val resources: Resources) {

    fun getEntriesFromCSV(rawResId: Int, label: String): PieEntry {
        var totalEnergyConsumed:Double = 0.0
        var data: List<EnergyConsumption>? = null
        resources.openRawResource(rawResId).use { stream ->
            data = Parser.toDataSet(stream.reader())
        }

        for(item in data!!){
            totalEnergyConsumed+=item.energyConsumed
        }
        return PieEntry(totalEnergyConsumed.toFloat(),label)
    }
}