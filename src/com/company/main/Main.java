package com.company.main;
import com.company.calculator.Calculator;


public class Main {
    public static void main(String[] args) {
        var calculator = new Calculator();
        System.out.println(calculator.calculate("( 7 + 4 ) * 10 / ( 1 - 6 * 2 )"));
        System.out.println(calculator.calculate("( 3 + 5 ) / ( 4 / 4 + 3 )"));
        System.out.println(calculator.calculate("5 + 5 * 4 * 2 / ( 1 + 5 )"));
    }
}
