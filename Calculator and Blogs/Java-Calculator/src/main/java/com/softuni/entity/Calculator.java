package com.softuni.entity;

import java.text.DecimalFormat;

public class Calculator {

    private double leftOperand;
    private double rightOperand;
    private String operator;


    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public String calculateResult() {
        String result;

        switch (this.operator) {
            case "+":
                result = "" + (this.leftOperand + this.rightOperand);
                break;
            case "-":
                result = "" + (this.leftOperand - this.rightOperand);
                break;
            case "*":
                result = "" + (this.leftOperand * this.rightOperand);
                break;
            case "/":
                if (this.rightOperand != 0)
                    result = "" + (this.leftOperand / this.rightOperand);
                else
                    result = "infinity";
                break;
            case "%":
                result = "" + (this.leftOperand % this.rightOperand);
                break;
            case "compare":
                if (this.leftOperand > this.rightOperand)
                    result = this.leftOperand + " > " + this.rightOperand;
                else if (this.leftOperand < this.rightOperand)
                    result = this.leftOperand + " < " + this.rightOperand;
                else
                    result = this.leftOperand + " = " + this.rightOperand;
                break;
            case "^":
                result = "" + (Math.pow(this.leftOperand, this.rightOperand));
                break;
            default:
                result = "0";
        }
        return result;
    }
}
