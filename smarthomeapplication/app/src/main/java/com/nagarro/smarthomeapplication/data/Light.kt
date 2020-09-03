package com.nagarro.smarthomeapplication.data

import androidx.room.Entity
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.Power_Status

@Entity
class Light(
    appliance_name: String, location: String,
    average_consumption_per_hour: Double, var power_status: Power_Status, var brightness: Int = 0
) : Appliance(
    appliance_name, location, average_consumption_per_hour,

    ) {


    fun adjustBrightness(brightnessLevel: Int) {
        this.brightness = brightnessLevel
    }

    override fun toString(): String {
        return "light(Power: ${power_status.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_hour," +
                "Brightness: $brightness"
    }
}