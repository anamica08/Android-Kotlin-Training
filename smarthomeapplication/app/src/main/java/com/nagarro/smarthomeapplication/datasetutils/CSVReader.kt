package com.nagarro.smarthomeapplication.datasetutils//package com.nagarro.smarthomeapplication.datasetmanager
//
//import android.content.res.Resources
//import com.github.mikephil.charting.data.Entry
//import com.github.mikephil.charting.data.LineDataSet
//import com.nagarro.smarthomeapplication.model.datasetrecord.EnergyConsumption
//
//class CSVReader(val resources: Resources) {
//
//     fun getEntriesFromCSV(rawResId: Int, label: String): LineDataSet {
//
//        var data: List<EnergyConsumption>? = null
//        resources.openRawResource(rawResId).use { stream ->
//            data = Parser.toDataSet(stream.reader())
//        }
//        val entries: MutableList<Entry> = ArrayList()
//
//        data?.mapIndexed { index, item ->
//            entries.add(
//                Entry(index.toFloat(), item.energyConsumed.toFloat(), item)
//            )
//        }
//
//        return LineDataSet(entries, label)
//    }
//}