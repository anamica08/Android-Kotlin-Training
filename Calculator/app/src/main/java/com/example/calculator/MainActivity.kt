package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import androidx.activity.viewModels
import androidx.lifecycle.Observer



class MainActivity : AppCompatActivity() {

//    private lateinit var result: EditText
//    private lateinit var newNumber: EditText
//    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.operation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model:CalculatorViewModel by viewModels()
        model.stringNewNumber.observe(this,Observer<String>{
            newNumber.setText(it)
        })
        model.operationString.observe(this,Observer<String>{
            operation.setText(it)
        })
        model.resultString.observe(this,Observer<String>{
            resultEditText.setText(it)
        })



//        result = findViewById(R.id.resultEditText)
//        newNumber = findViewById(R.id.newNumber)

        // Data input buttons
//        val button0: Button = findViewById(R.id.button0)
//        val button1: Button = findViewById(R.id.button1)
//        val button2: Button = findViewById(R.id.button2)
//        val button3: Button = findViewById(R.id.button3)
//        val button4: Button = findViewById(R.id.button4)
//        val button5: Button = findViewById(R.id.button5)
//        val button6: Button = findViewById(R.id.button6)
//        val button7: Button = findViewById(R.id.button7)
//        val button8: Button = findViewById(R.id.button8)
//        val button9: Button = findViewById(R.id.button9)
//        val buttonDot: Button = findViewById(R.id.buttonDot)

        // Operation buttons
//        val buttonEquals = findViewById<Button>(R.id.buttonEqual)
//        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
//        val buttonMultiply = findViewById<Button>(R.id.buttonMutiply)
//        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
//        val buttonPlus = findViewById<Button>(R.id.buttonPlus)

        val listener = View.OnClickListener { v ->
        model.digitPressed((v as Button).text.toString())
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
           model.operandPressed((v as Button).text.toString())
        }

        buttonEqual.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)



        buttonNeg.setOnClickListener({v->
           model.negButtonPressed()
        })

        buttonCancel.setOnClickListener({v->
           model.cancelPressed()
        })


    }




//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        if(operand1 != null){
//            outState.putDouble(STATE_OPERAND1, operand1!!)
//        }
//        outState.putBoolean(STATE_OPERAND1_EXISTS,operand1Exists)
//        outState.putString(STATE_PENDING_OPERATION,pendingOperation)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        if(savedInstanceState.getBoolean(STATE_OPERAND1_EXISTS)){
//            operand1 = savedInstanceState.getDouble(STATE_OPERAND1)
//        }else{
//            operand1 = null
//        }
//
//        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION).toString()
//        operation.setText(pendingOperation)
//    }
}