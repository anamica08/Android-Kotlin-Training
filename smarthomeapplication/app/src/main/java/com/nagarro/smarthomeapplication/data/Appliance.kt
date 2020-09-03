package com.nagarro.smarthomeapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
open class Appliance(

    @PrimaryKey
    var appliance_name: String,
    var location: String,
    var average_consumption_per_hour: Double,



){
    override fun toString(): String {
        return "[$appliance_name,$location,$average_consumption_per_hour]"
    }
}
