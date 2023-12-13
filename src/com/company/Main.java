package com.company;//package com.company;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Main {


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var calculator = new Calculator();
        //var result = calculator.calculate("3 + 4 * 2 / ( 1 - 5 )");
        System.out.println(calculator.calculate("( 7 + 4 ) * 10 / ( 1 - 6 * 2 )"));
        System.out.println(calculator.calculate("( 3 + 5 ) / ( 4 / 4 + 3 )"));
        System.out.println(calculator.calculate("5 + 5 * 4 * 2 / ( 1 + 5 )"));
    }
}
