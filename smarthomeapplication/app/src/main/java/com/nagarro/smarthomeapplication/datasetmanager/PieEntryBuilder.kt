package com.nagarro.smarthomeapplication.datasetmanager

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.model.datasetrecord.EnergyConsumption
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val TAG = "PieEntryBuilder"
class PieEntryBuilder @Inject constructor(@ApplicationContext val context: Context) {

    val resources = context.resources

    private fun getEntriesFromCSV(rawResId: Int, label: String): PieEntry {
        var totalEnergyConsumed:Double = 0.0
        var data: List<EnergyConsumption>?
        resources.openRawResource(rawResId).use { stream ->
            data = Parser.toDataSet(stream.reader())
        }

        for(item in data!!){
            totalEnergyConsumed+=item.energyConsumed
        }
        return PieEntry(totalEnergyConsumed.toFloat(),label)
    }

    fun createPieEntries(): MutableList<PieEntry>{
        val acPieEntry = getEntriesFromCSV(R.raw.ac, "AC")
        val lightPieEntry = getEntriesFromCSV(R.raw.light, "Light")
        val refrigeratorPieEntry =  getEntriesFromCSV(R.raw.refrigerator, "Refrigerator")
        val washingMachinePieEntry =getEntriesFromCSV(R.raw.washing_machine, "Washing Machine")
        val entries:MutableList<PieEntry> = ArrayList()
        entries.add(lightPieEntry)
        entries.add(acPieEntry)
        entries.add(refrigeratorPieEntry)
        entries.add(washingMachinePieEntry)
        return entries
    }
}