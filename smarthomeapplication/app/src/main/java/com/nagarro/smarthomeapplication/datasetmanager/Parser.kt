package com.nagarro.smarthomeapplication.datasetmanager

import com.nagarro.smarthomeapplication.model.datasetrecord.EnergyConsumption
import com.opencsv.CSVReaderBuilder
import java.io.Reader

class Parser {

    companion object {

        fun toDataSet(reader: Reader): List<EnergyConsumption> {

            val csvReader = CSVReaderBuilder(reader)
                .withSkipLines(1)
                .build()

            val consumptionReadings = mutableListOf<EnergyConsumption>()
            var record = csvReader.readNext()

            while (record != null) {
                consumptionReadings.add(EnergyConsumption(record[0].toInt(), record[3].toDouble(),record[4].toString()))
                record = csvReader.readNext()
            }
            print(consumptionReadings)
            return consumptionReadings
        }
    }

}