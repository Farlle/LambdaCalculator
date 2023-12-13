package com.company.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Calculator {
    BinaryOperator<Double> add = Double::sum;
    BinaryOperator<Double> sub = (a, b) -> a - b;
    BinaryOperator<Double> mult = (a, b) -> a * b;
    BinaryOperator<Double> div = (a, b) -> a / b;

    public double calculate(String expression) {
        var inputExpression = new ArrayList<>(Arrays.asList(expression.split(" ")));
        var expressionPolishNotation = new ArrayList<String>();
        var stack = new Stack<String>();

        for (var symbol : inputExpression) {
            if (isOperator(symbol)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && (priority(stack.peek()) >= priority(symbol))) {
                    expressionPolishNotation.add(stack.pop());
                }
                stack.push(symbol);
            } else if (symbol.equals("(")) {
                stack.push(symbol);
            } else if (symbol.equals(")")) {
                while (!stack.peek().equals("(")) {
                    expressionPolishNotation.add(stack.pop());
                }
                stack.pop();
            } else {
                expressionPolishNotation.add(symbol);
            }
        }
        while (!stack.isEmpty()) {
            expressionPolishNotation.add(stack.pop());
        }
        return evaluate(expressionPolishNotation);
    }

    private boolean isOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/");
    }

    private int priority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    private double evaluate(List<String> input) {
        var stack = new Stack<Double>();

        for (var symbol : input) {
            if (!isOperator(symbol)) {
                stack.push(Double.parseDouble(symbol));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                char operator = symbol.charAt(0);
                switch (operator) {
                    case '+' -> stack.push(add.apply(operand1, operand2));
                    case '-' -> stack.push(sub.apply(operand1, operand2));
                    case '*' -> stack.push(mult.apply(operand1, operand2));
                    case '/' -> stack.push(div.apply(operand1, operand2));
                    default -> throw new IllegalArgumentException("Unknown operator: " + operator);
                }
            }
        }

        return stack.pop();
    }


}
