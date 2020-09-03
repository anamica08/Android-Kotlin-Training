package com.nagarro.smarthomeapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "appliancedata")
open class Appliance(

    @PrimaryKey
    val appliance_name: String,
    val location: String,
    val average_consumption_per_hour: Double,
    val category: String


){
    override fun toString(): String {
        return "[$appliance_name,$location,$average_consumption_per_hour,$category]"
    }
}
