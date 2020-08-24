package com.nagarro.smarthomeapplication.model.data

import com.nagarro.smarthomeapplication.model.Appliance
import java.sql.Timestamp

data class EnergyConsumption( val id:Int, val energyConsumed:Double, val timestamp: String)