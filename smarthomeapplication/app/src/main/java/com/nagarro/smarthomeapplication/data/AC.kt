package com.nagarro.smarthomeapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status


@Entity
class AC(
    appliance_name: String,
    location: String,
    average_consumption_per_hour: Double,
    var powerStatus: Power_Status,
    val operatingTemperature:Int,
    var mode: AC_Mode,
    var fanSpeed: FanSpeed
) : Appliance(appliance_name, location, average_consumption_per_hour) {

    override fun toString(): String {
        return "ac(Power: ${powerStatus.name}," +
                "Name: $appliance_name," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_hour," +
                "Temp: ${operatingTemperature}," +
                "Mode: ${mode.name}, " +
                "Fan Speed: ${fanSpeed.name})"
    }

    fun changePowerStatus(switchMode: Power_Status) {
        this.powerStatus = switchMode
    }

    fun changeMode(mode: AC_Mode) {
        this.mode = mode
    }

    fun changeFanSpeed(speed: FanSpeed) {
        this.fanSpeed = speed
    }
}