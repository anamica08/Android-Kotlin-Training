package com.nagarro.smarthomeapplication.model

import android.icu.lang.UCharacterCategory
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nagarro.smarthomeapplication.enums.Power_Status


@Entity
open class Appliance(
    var power_status: Power_Status,
    @PrimaryKey
    val appliance_name: String,
    val location: String,
    val average_consumption_per_day: Double,
    val category: String


){
    override fun toString(): String {
        return "[$power_status,$appliance_name,$location,$average_consumption_per_day,$category]"
    }
}
