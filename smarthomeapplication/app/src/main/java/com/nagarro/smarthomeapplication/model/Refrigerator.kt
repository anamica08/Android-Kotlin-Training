package com.nagarro.smarthomeapplication.model

import android.widget.Toast
import com.nagarro.smarthomeapplication.enums.Power_Status

class Refrigerator(
    power_status: Power_Status, appliance_name: String, location: String,
    average_consumption_per_hour: Double, var freeze_temp:Int, var temp:Int
) : Appliance(
    power_status,
    appliance_name, location, average_consumption_per_hour
) {

    fun changePowerStatus(switchMode:Power_Status){
        when(switchMode){
            Power_Status.ON -> power_status = Power_Status.ON
            Power_Status.OFF -> power_status = Power_Status.OFF
        }
    }
    fun decreaseTempOfFreezer(){
        freeze_temp = freeze_temp -1
    }
    fun decreaseTemp(){
        temp = temp-1;
    }
    fun increaseTempOfFreezer(){
        freeze_temp = freeze_temp +1
    }
    fun increaseTemp(){
        temp = temp+1;
    }
}