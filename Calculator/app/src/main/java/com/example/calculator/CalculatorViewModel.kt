package com.example.calculator

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorViewModel : ViewModel() {

    private var operand1Exists = false

    // Variables to hold the operands and type of calculation
    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    //create referencec to the feilds where you want to update with live data
//    private val newNumber = MutableLiveData<String>()
//    var newNumberString: LiveData<String>
//        get() = newNumber

    private val newNumber = MutableLiveData<String>()
    val stringNewNumber: LiveData<String>
        get() = newNumber

    private var result = MutableLiveData<String>()
    val resultString: LiveData<String>
        get() = Transformations.map(result) { it.toString()}

    private var operation = MutableLiveData<String>()
    val operationString:LiveData<String>
        get() = operation

    fun digitPressed(caption: String) {
        if(newNumber.value == null )
            newNumber.value = caption
        else
            newNumber.value = newNumber.value + caption
    }

    fun operandPressed(operand: String) {

        try {
            val value = newNumber.value?.toDouble()

            performOperation(value, operand)
            operand1Exists = true

        } catch (e: NumberFormatException) {
            newNumber.value = ""
        }

        pendingOperation = operand
        operation.value = pendingOperation

    }

    fun negButtonPressed(){
        val value = newNumber.value.toString()
        if(value.isEmpty()){
            newNumber.value = "-"
        }else {
            try {
                var doubleValue = value.toDouble()
                doubleValue *= -1
                newNumber.value = doubleValue.toString()
            } catch (e: NumberFormatException) {
                // newNumber was "-" or ".", so clear it
                newNumber.value = ""
            }
        }
        //can have more logic
    }
    fun cancelPressed(){
        result.value = ""
        newNumber.value = ""
        operand1 = 0.0
        pendingOperation = "="
        operand2 = 0.0
    }

    private fun performOperation(value: Double?, operation: String) {
        if (operand1 == null) {
            operand1 = value
        } else {
            if (value != null) {
                operand2 = value
            }

            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) {
                "=" -> operand1 = operand2
                "/" -> if (operand2 == 0.0) {
                    operand1 = Double.NaN   // handle attempt to divide by zero
                } else {
                    operand1 = operand1!! / operand2
                }
                "*" -> operand1 = operand1!! * operand2
                "-" -> operand1 = operand1!! - operand2
                "+" -> operand1 = operand1!! + operand2
            }

            result.value = (operand1.toString())
            newNumber.value = ""
        }

    }
}