/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.anacvignola.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anacvignola
 */
public class Calculations {
    public static void main(String args[]){
        Calculations c = new Calculations();
        System.out.println(">>>>"+c.calculator("5/5"));
    }
    public String calculator(String expression) {
        String result;
        List<Double> listNumbers = new ArrayList<Double>();
        List<Character> listOperation = new ArrayList<Character>();
 
        listNumbers = getNumbers(expression);
        listOperation = getOperation(expression);
 
        result = calcValue(listNumbers, listOperation);
 
        return result;
 
    }
 
    private String calcValue(List<Double> listNumbers, 
    List<Character> listOperation) {
        String result = "";
        double total = 0.0;
        int j=0;
        for (int i = 0; i < listNumbers.size()-1; i++) {
 
            if ( total==0.0) {
                double n1 = listNumbers.get(i).doubleValue();
                double n2 = listNumbers.get(i + 1).doubleValue();
                char op = listOperation.get(i).charValue();
                total = runOperation(n1, op, n2);
            }
            else if (total>0.0) {
                 
                double n2 = listNumbers.get(i).doubleValue();
                char op = listOperation.get(j).charValue();
                total = runOperation(total, op, n2);
                j++;
            }
             
             
 
        }
 
        result = ""+total;
        return result;
    }
 
    private double runOperation(double n1, char op, double n2) {
        double result = 0.0;
 
        if (op == '+') {
            result = n1 + n2;
        } else if (op == '-') {
            result = n1 - n2;
        } else if (op == '/') {
            result = n1 / n2;
        } else if (op == '*') {
            result = n1 * n2;
        }
        return result;
    }
 
    private List<Double> getNumbers(String expression) {
 
        List<Double> listNumbers = new ArrayList<Double>();
 
        String numberString = "";
        for (int i = 0; i < expression.length(); i++) {
 
            if (isOperator(expression.charAt(i))) {
                Double numero = Double.valueOf(numberString);
                listNumbers.add(numero);
                numberString = "";
            } else {
                numberString = numberString.concat("" + expression.charAt(i));
            }
        }
        if(!numberString.isEmpty())
        {
                Double number = Double.valueOf(numberString);
                listNumbers.add(number);
             
        }
        return listNumbers;
    }
 
    private List<Character> getOperation(String expression) {
 
        List<Character> listOperation = new ArrayList<Character>();
 
 
        for (int i = 0; i < expression.length(); i++) {
 
            if (isOperator(expression.charAt(i))) {
                listOperation.add(new Character(expression.charAt(i)));
            }
        }
 
        return listOperation;
    }
 
    private boolean isOperator(char caracter) {
        boolean isOperator = false;
        if (caracter == '-' || caracter == '+' || caracter == '/' || caracter == '*') {
            isOperator = true;
        }
        return isOperator;
    }
} 