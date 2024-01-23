package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var calculator = new Calculator();
        System.out.println(calculator.calculate("( 7 + 4 ) * 10 / ( 1 - 6 * 2 )"));
        System.out.println(calculator.calculate("( 3 + 5 ) / ( 4 / 4 + 3 )"));
        System.out.println(calculator.calculate("5 + 5 * 4 * 2 / ( 1 + 5 )"));
        System.out.println(calculator.calculate("5.0 / 0.0"));
    }
}