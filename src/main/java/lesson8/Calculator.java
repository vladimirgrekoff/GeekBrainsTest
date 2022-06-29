//Домашнее задание, урок 8: Владимир Греков
package lesson8;

import java.util.Stack;

public class Calculator {
    private static Stack<Double> numbers = new Stack<>();
    private static String postfixNotation;

    public static double handle(String infixNotation) {

        postfixNotation = InfixToPostfix.convert(infixNotation);
        String[] mathArr = postfixNotation.split(" ");

        for (String mathElement : mathArr) {
            if (isNumeric(mathElement)) {
                numbers.push(Double.parseDouble(mathElement));
                continue;
            }
            double num2 = numbers.pop();
            double num1 = numbers.pop();

            numbers.push(calc(num1, num2, mathElement));
        }


        return numbers.pop();
    }

    private static boolean isOperator(String strElement) {
        return (strElement.length() == 1 && "-+/*^".contains(strElement));
    }

    private static boolean isNumeric(String strElement) {
        int n = 0;
        int len = strElement.length();

        if (len > 0 && !isOperator(strElement)) {
            for (int i = 0; i < strElement.length(); i++) {
                if ("-.0123456789".contains(strElement.substring(i, i+1))){
                    n++;
                }
            }
            return (n == len);
        }
        return false;
    }

    private static double calc(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "^" -> Math.pow(num1, num2);
            default -> 0;
        };

    }

//    public static void main(String[] args) {
//        System.out.println(eval("11*(42 + 23 )-(40^2/5)"));
//        System.out.println(eval("-11*(42 + 23)/2*(40^2/-(5+2))"));
//        System.out.println(eval("-45 + 90"));
//        System.out.println(eval("-(45 + 90)"));
//    }
}


