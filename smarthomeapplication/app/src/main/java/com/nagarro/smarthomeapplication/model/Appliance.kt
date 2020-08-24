package com.nagarro.smarthomeapplication.model

import com.nagarro.smarthomeapplication.enums.Power_Status

open class Appliance(
    var power_status: Power_Status,
    val appliance_name:String,
    val location:String,
    val average_consumption_per_hour:Double)
