package com.nagarro.smarthomeapplication.sensordata

import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status
//this class has kotlin object notation for reading live data(mock) from sensor.
data class ACData(val powerStatus: Power_Status,val name:String, val operatingTemp:Int, val mode: AC_Mode, val fanSpeed: FanSpeed)

data class Light(val powerStatus: Power_Status, val brightness:Int)