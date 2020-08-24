package com.nagarro.smarthomeapplication.model

import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status


class AC(
    power_status: Power_Status,
    appliance_name: String,
    location: String,
    average_consumption_per_hour: Double,
    var operating_temperature: Int,
    val mode: AC_Mode,
    val fanSpeed: FanSpeed
) : Appliance(power_status, appliance_name, location, average_consumption_per_hour) {

    override fun toString(): String {
        return "ac(Power: $power_status,Name: $appliance_name,Location: $location, Average_Consumption: $average_consumption_per_hour,Temp: $operating_temperature,Mode: $mode, Fan Speed: $fanSpeed)"
    }

    fun changePowerStatus(switchMode: Power_Status) {
        when (switchMode) {
            Power_Status.ON -> power_status = Power_Status.ON
            Power_Status.OFF -> power_status = Power_Status.OFF
        }
    }

    fun decreaseTemp() {
        --operating_temperature
    }

    fun increaseTemp() {
        ++operating_temperature
    }

    fun changeMode(){
        
    }
}