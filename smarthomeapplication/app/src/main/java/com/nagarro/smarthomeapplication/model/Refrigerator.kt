package com.nagarro.smarthomeapplication.model

import com.nagarro.smarthomeapplication.enums.Power_Status

class Refrigerator(
    power_status: Power_Status, appliance_name: String, location: String,
    average_consumption_per_day: Double,
) : Appliance(
    power_status,
    appliance_name, location, average_consumption_per_day,
    category = "refrigerator"
) {
    var freezer_temp: Int = 0
        private set(value) {
            field = value
        }

    var temp: Int = 9
        private set(value) {
            field = value
        }

    fun changePowerStatus(switchMode: Power_Status) {
        this.power_status = switchMode
    }

    fun decreaseTempOfFreezer() {
        --freezer_temp
    }

    fun decreaseTemp() {
        temp = temp - 1;
    }

    fun increaseTempOfFreezer() {
        ++freezer_temp
    }

    fun increaseTemp() {
        ++temp
    }

    override fun toString(): String {
        return "ac(Power: ${power_status.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_day," +
                "Freezer Temperature: $freezer_temp," +
                "Temperatur: $temp"
    }
}