package com.nagarro.smarthomeapplication.utils

import android.content.Context
import android.util.Log
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.energyunitPOJO.EnergyConsumption
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "PieEntryBuilder"
class PieEntryBuilder @Inject constructor(@ApplicationContext val context: Context) {

    val resources = context.resources

    private suspend fun getEntriesFromCSV(rawResId: Int, label: String): PieEntry {
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


    suspend fun createPieEntries(): MutableList<PieEntry>{
        val entries:MutableList<PieEntry> = ArrayList()
        withContext(Dispatchers.IO){
            val acPieEntry = getEntriesFromCSV(R.raw.ac, "AC")
            val lightPieEntry = getEntriesFromCSV(R.raw.light, "Light")
            val refrigeratorPieEntry =  getEntriesFromCSV(R.raw.refrigerator, "Refrigerator")
            val washingMachinePieEntry =getEntriesFromCSV(R.raw.washing_machine, "Washing Machine")
            entries.add(lightPieEntry)
            entries.add(acPieEntry)
            entries.add(refrigeratorPieEntry)
            entries.add(washingMachinePieEntry)
            Log.d(TAG, "createPieEntries: ${Thread.currentThread().name}")
        }

        return entries
    }
}