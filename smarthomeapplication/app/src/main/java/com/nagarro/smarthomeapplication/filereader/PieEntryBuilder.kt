package com.nagarro.smarthomeapplication.filereader

import android.content.res.Resources
import androidx.lifecycle.LiveData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.model.data.EnergyConsumption

class PieEntryBuilder(val resources: Resources) {

    private fun getEntriesFromCSV(rawResId: Int, label: String): PieEntry {
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

    fun createPieEntries(): MutableList<PieEntry>{
        val acPieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.ac, "AC")
        val lightPieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.light, "Light")
        val refrigeratorPieEntry =  PieEntryBuilder(resources).getEntriesFromCSV(R.raw.refrigerator, "Refrigerator")
        val washingMachinePieEntry = PieEntryBuilder(resources).getEntriesFromCSV(R.raw.washing_machine, "Washing Machine")
        val entries:MutableList<PieEntry> = ArrayList()
        entries.add(lightPieEntry)
        entries.add(acPieEntry)
        entries.add(refrigeratorPieEntry)
        entries.add(washingMachinePieEntry)
        return entries
    }
}