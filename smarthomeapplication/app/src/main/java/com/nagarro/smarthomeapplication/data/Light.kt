package com.nagarro.smarthomeapplication.data

import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.Power_Status

class Light(appliance_name: String, location: String,
            average_consumption_per_hour: Double
) :Appliance(
    appliance_name, location, average_consumption_per_hour,
    category = Constants.APPLIANCE_CATEGORY_LIGHT
) {


    var power_status: Power_Status = Power_Status.OFF
        private set(value) {
            field = value
        }
    //in lux meter
    var brightness:Int = 0
        private set(value) {field=value}


    fun adjustBrightness(brightnessLevel:Int){
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