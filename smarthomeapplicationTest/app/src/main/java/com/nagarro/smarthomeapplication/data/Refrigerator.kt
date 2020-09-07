package com.nagarro.smarthomeapplication.data

import androidx.room.Entity
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.Power_Status


@Entity
class Refrigerator(
    appliance_name: String, location: String,
    average_consumption_per_hour: Double, var powerStatus: Power_Status, var freezerTemp: Int, var temp: Int,
    category: String = Constants.APPLIANCE_CATEGORY_REFRIGERATOR
) : Appliance(
    appliance_name, location, average_consumption_per_hour, category
) {

    fun changePowerStatus(switchMode: Power_Status) {
        this.powerStatus = switchMode
    }

    fun decreaseTempOfFreezer() {
        --freezerTemp
    }

    fun decreaseTemp() {
        temp = temp - 1;
    }

    fun increaseTempOfFreezer() {
        ++freezerTemp
    }

    fun increaseTemp() {
        ++temp
    }

    override fun toString(): String {
        return "ac(Power: ${powerStatus.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_hour," +
                "Freezer Temperature: $freezerTemp," +
                "Temperatur: $temp"
    }
}