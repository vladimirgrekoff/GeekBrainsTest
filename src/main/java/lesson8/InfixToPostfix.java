//Домашнее задание, урок 8: Владимир Греков
package lesson8;

import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostfix {

    private static StringBuilder postfixNotation = new StringBuilder();
    private static LinkedList<String> operators = new LinkedList<>();
    private static Stack<String> operatorsStack = new Stack<>();

    static {
        operators.add("*");
        operators.add("x");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        operators.add("^");
    }


    public static String convert(String mathInfix) {
        String strInfixWithSpaces;
        String[] mathElement;
        operatorsStack.clear();
        postfixNotation.setLength(0);


        strInfixWithSpaces = insertSpacesInString(mathInfix);
        strInfixWithSpaces = checkMinusOperatorOrSign(strInfixWithSpaces);
        mathElement = strInfixWithSpaces.split(" ");
        for (int i = 0; i < mathElement.length; i++) {

            if (isNumeric(mathElement[i])) {
                postfixNotation.append(mathElement[i]).append(" ");
            } else if (mathElement[i].equals("(")) {
                operatorsStack.add(mathElement[i]);
            } else if (mathElement[i].equals(")")) {
                while (!operatorsStack.peek().equals("(")) {
                    postfixNotation.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.pop();
            } else {
                while (!operatorsStack.isEmpty() && getOperatorPriority(operatorsStack.peek()) >= getOperatorPriority(mathElement[i])) {
                    postfixNotation.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.push(mathElement[i]);
            }
        }

        while (!operatorsStack.isEmpty()) {
            postfixNotation.append(operatorsStack.pop()).append(" ");
        }

        return postfixNotation.toString().replaceAll("x", "*");
    }
    private static int getOperatorPriority(String operator) {
        return switch (operator) {
            case "x" -> 5; //самый высокий для "-1 *", x - для расстановки операторов
            case "^" -> 3;
            case "/", "*" -> 2;
            case "+", "-" -> 1;
            default -> 0;
        };
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

    private static String checkMinusOperatorOrSign(String checkString) {
        //проверка символа "-" на отношение к оператору или знаку числа
        String returnString = "";
        String[] arrayTemp;
        arrayTemp = checkString.split(" ");

        for (int i = 0; i < arrayTemp.length; i++) {
            if (i == 0 && arrayTemp[i].equals("-")) {
                replaceMinusToSign(arrayTemp, i); //"-" на знак
            } else if (arrayTemp[i].equals("-") && (isOperator(arrayTemp[i-1]) || arrayTemp[i-1].equals("("))) {
                replaceMinusToSign(arrayTemp, i); //"-" на знак
            }
        }
        returnString = String.join(" ", arrayTemp);
        returnString = returnString.trim().replaceAll("\s+", " ");
        arrayTemp = null;
        return returnString;
    }

    private static void replaceMinusToSign(String[] arrayTemp, int i) {
        //Установка знака числа или замена умножением на -1
        if (isNumeric(arrayTemp[i +1])){
            arrayTemp[i +1] = arrayTemp[i] + arrayTemp[i +1];
            arrayTemp[i] = "";
        } else if (arrayTemp[i +1].equals("(")) {
            arrayTemp[i] = "-1 x";
        }
    }

    private static String insertSpacesInString(String resultString) {
        //вставка пробелов между скобками, операторами и числами
        String returnString = "";
        boolean containsCheckSymbol;

        for (int i = 0; i < resultString.length(); i++) {
            containsCheckSymbol = ".0123456789".contains(resultString.substring(i, i+1));
            if ("()-+/*^".contains(resultString.substring(i, i+1))) {
                if (i == 0) {
                    returnString += resultString.substring(i, i+1) + " ";
                } else if (" ".contains(returnString.substring(returnString.length()-1))) {
                    returnString += resultString.substring(i, i+1) + " ";
                } else {
                    returnString += " " + resultString.substring(i, i+1) + " ";
                }
            } else if (containsCheckSymbol) {
                returnString += resultString.substring(i, i+1);
            }
        }
        return returnString.trim();
    }

//    public static void main(String[] args) {

//        System.out.println(convert("-11*(42 + 23)/-(40^2/-5)"));
//        System.out.println(convert("-11*(42 + 23)/2*(40^2/-(5+2))"));
//        System.out.println(convert("-11*(4 + 5)/2*(4^2/-(5+2))"));
//        System.out.println(convert("-(45 + 90)"));
//
//    }
}

