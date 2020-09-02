package com.nagarro.smarthomeapplication.model

import com.nagarro.smarthomeapplication.enums.Power_Status

class Light(power_status: Power_Status, appliance_name: String, location: String,
            average_consumption_per_day: Double
) :Appliance(power_status,
    appliance_name, location, average_consumption_per_day,
    category = "light"
) {

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
                " Average_Consumption: $average_consumption_per_day," +
                "Brightness: $brightness"
    }
}