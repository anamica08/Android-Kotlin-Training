package com.nagarro.smarthomeapplication.data

import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status


class AC(
    appliance_name: String,
    location: String,
    average_consumption_per_hour: Double
) : Appliance(appliance_name, location, average_consumption_per_hour, category = Constants.APPLIANCE_CATEGORY_AC) {

    var power_status: Power_Status? = Power_Status.OFF
        private set(value) {
            field = value
        }

    var operatingTemperature: Int? = 27
        private set(value) {
            field = value
        }
    var mode: AC_Mode? = AC_Mode.AUTO
        private set(value) {
            field = value
        }
    var fanSpeed: FanSpeed? = FanSpeed.MEDIUM
        private set(value) {
            field = value
        }


    override fun toString(): String {
        return "ac(Power: ${power_status?.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_hour," +
                "Temp: ${operatingTemperature}," +
                "Mode: ${mode?.name}, " +
                "Fan Speed: ${fanSpeed?.name})"
    }

    fun changePowerStatus(switchMode: Power_Status) {
        this.power_status = switchMode
    }

//    fun decreaseTemp() {
//        --operatingTemperature
//    }
//
//    fun increaseTemp() {
//        ++operatingTemperature
//    }

    fun changeMode(mode: AC_Mode) {
        this.mode = mode
    }

    fun changeFanSpeed(speed: FanSpeed) {
        this.fanSpeed = speed
    }
}