package com.nagarro.smarthomeapplication.model

import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status


class AC(
    power_status: Power_Status,
    appliance_name: String,
    location: String,
    average_consumption_per_day: Double
) : Appliance(power_status, appliance_name, location, average_consumption_per_day, category = "ac") {

    var operatingTemperature: Int = 27
        private set(value) {
            field = value
        }
    var mode: AC_Mode = AC_Mode.AUTO
        private set(value) {
            field = value
        }
    var fanSpeed: FanSpeed = FanSpeed.MEDIUM
        private set(value) {
            field = value
        }


    override fun toString(): String {
        return "ac(Power: ${power_status.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_day," +
                "Temp: ${operatingTemperature}," +
                "Mode: ${mode.name}, " +
                "Fan Speed: ${fanSpeed.name})"
    }

    fun changePowerStatus(switchMode: Power_Status) {
        this.power_status = switchMode
    }

    fun decreaseTemp() {
        --operatingTemperature
    }

    fun increaseTemp() {
        ++operatingTemperature
    }

    fun changeMode(mode: AC_Mode) {
        this.mode = mode
    }

    fun changeFanSpeed(speed: FanSpeed) {
        this.fanSpeed = speed
    }
}