package com.example.calculator;

import org.jetbrains.annotations.NotNull;

import javax.xml.transform.dom.DOMLocator;

public class AppServices {

    @NotNull
    public String performOperation(@NotNull String op, @NotNull String value, @NotNull String result) {
        Double operand1 = null;
        Double operand2 = null;

        if(result == ""){
            operand1 = 0.0;
        }else{
            operand1 = Double.parseDouble(result);
        }

        operand2 = Double.parseDouble(value);

        System.out.println(op);

        switch(op){
            case "=": operand1 = operand2;
                        break;
            case "=+": operand1 = operand1+operand2;
                        break;
            case "=-": operand1 = operand1-operand2;
                        break;
            case "=*": operand1 = operand1*operand2;
                        break;
            case "=/": operand1 = operand1/operand2;
                        break;
        }

        System.out.println(operand1);
        if(operand1 == 0.0){
            return  "";
        }else{
            return operand1.toString();
        }

    }
}
