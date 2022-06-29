//Домашнее задание, урок 8: Владимир Греков
package lesson8.listeners;

import lesson8.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static java.util.Objects.isNull;

public class ButtonListener implements ActionListener {
    private JTextField inputField;

    private static String strNumVariable;


    private static int leftBracketCount;
    private static int rightBracketCount;

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    public static String getStrNumVariable() {
        return strNumVariable;
    }

    public static void setStrNumVariable(String strNumVariable) {
        ButtonListener.strNumVariable = strNumVariable;
    }

    public static void setLeftBracketCount(int leftBracketCount) {
        ButtonListener.leftBracketCount = leftBracketCount;
    }

    public static void setRightBracketCount(int rightBracketCount) {
        ButtonListener.rightBracketCount = rightBracketCount;
    }

    public static int getLeftBracketCount() {
        return leftBracketCount;
    }

    public static int getRightBracketCount() {
        return rightBracketCount;
    }

    public void actionPerformed(ActionEvent e) {
        int intLen;
        String strInputField;
        String strButton;


        JButton button = (JButton) e.getSource();

        strButton = button.getText();

        strInputField = (inputField.getText()).trim();
        intLen = strInputField.length();

        if (isNull(strNumVariable)) {
            if (intLen == 1 && ("0123456789".contains(strInputField))) {
                strNumVariable = strInputField;
            } else {
                strNumVariable = "";
            }
        }
//////////////////////////////////////ПРОВЕРКИ КОРРЕКТНОСТИ ВВОДА///////////////////////////////////////

//////////////////////////////////////ПРОВЕРКА ДЕЛЕНИЯ НА НОЛЬ//////////////////////////////////////////

        boolean checkDivisionByZero = isDivideByZero(strInputField, strButton);

//////////////////////////////////////////////СКОБКИ////////////////////////////////////////////////////

        if (isBracket(strButton) && !checkDivisionByZero){
            //нажата кнопка скобки
            intLen = strInputField.length();

            if (strButton.equals("(")) {
                //если левая скобка (открывающая)
                if (strInputField.isEmpty()) {
                    //если пусто
                    inputField.setText(strButton);
                    changeLeftBracketCounter(); //измненение значения счетчика левых скобок
                }

                if (intLen == 1 && strInputField.equals("0")) {
                    //если только 0
                    inputField.setText(strButton);
                    changeLeftBracketCounter(); //измненение значения счетчика левых скобок
                }

                if (intLen > 0 && strInputField.substring(intLen - 1).equals("(")) {
                    //если последняя левая скобка
                    inputField.setText(strInputField + strButton);
                    changeLeftBracketCounter(); //измненение значения счетчика левых скобок
                }

                if (intLen > 0 && isOperator(strInputField.substring(intLen - 1))) {
                    //если последний знак оператор
                    inputField.setText(strInputField + strButton);
                    changeLeftBracketCounter(); //измненение значения счетчика левых скобок
                }
            }
            if (strButton.equals(")") && intLen > 0) {
                //если правая скобка (закрывающая)

                if (intLen > 0 && strInputField.substring(intLen - 1).equals(")") && (leftBracketCount > rightBracketCount)) {
                    //если последняя правая скобка (закрывающая)
                    inputField.setText(strInputField + strButton);
                    changeRightBracketCounter(); //измненение значения счетчика правых скобок
                }

                if (isNumeric(strInputField.substring(intLen - 1)) && (leftBracketCount > rightBracketCount)) {
                    //если последняя цифра
                    if(strInputField.substring(intLen - 1).equals(".")){
                        strInputField = strInputField + "0"; //последняя точка (дробь) добавить 0
                    }
                    inputField.setText(strInputField + strButton);
                    changeRightBracketCounter(); //измненение значения счетчика правых скобок
                }
            }
        }

//////////////////////////////////////////////ОПЕРАТОРЫ////////////////////////////////////////////////////

        if (isOperator(strButton) && !checkDivisionByZero) {
            //нажата кнопка оператора
            intLen = strInputField.length();

            if ((strInputField.isEmpty() || (inputField.getText()).equals("0")) && strButton.equals("-")) {
                //если пустая можно только "-"
                inputField.setText(strButton);
                strNumVariable = "";

            } else if (intLen == 1) {//если один символ

                if (strInputField.equals("0") && (strButton.equals("-"))) {
                    //если один символ 0 и кнопка "-" заменить
                    inputField.setText(button.getText());
                    strNumVariable = "";
                }

                if (strInputField.equals("(") && (strButton.equals("-"))) {
                    //если один символ ( можно только "-"
                    inputField.setText(strInputField + button.getText());
                    strNumVariable = "";
                }

                if (strInputField.equals("0") && ("+/*".contains(strButton))) {
                    //если один символ 0 и кнопка "+*/" добавить
                    inputField.setText(strInputField + strButton);
                    strNumVariable = "";

                }

                if ("123456789".contains(strInputField) && ("-+/*".contains(strButton))) {
                    //если один символ (1-9) любой оператор добавить
                    inputField.setText(strInputField + strButton);
                    strNumVariable = "";
                }
            } else if (intLen > 1) {//если больше одного символа

                if (strInputField.substring(intLen - 1).equals("(") && "+/*".contains(strButton)) {
                    //ничего не делать
                    inputField.setText(inputField.getText());
                }

                if (strInputField.substring(intLen - 1).equals("(") && strButton.equals("-")) {
                    inputField.setText(inputField.getText() + strButton);
                    strNumVariable = "";
                }

                if (strInputField.substring(intLen - 1).equals(")") && "-+/*".contains(strButton)) {
                    inputField.setText(inputField.getText() + strButton);
                    strNumVariable = "";
                }

                if (strInputField.substring(intLen - 1).equals(".") && "-+/*".contains(strButton)) {
                    strInputField = strInputField + "0"; //последняя точка (дробь) добавить 0
                    inputField.setText(strInputField + strButton);
                    strNumVariable = "";
                }

                if ("0123456789".contains(strInputField.substring(intLen - 1)) && ("-+/*".contains(strButton))) {
                    //если символ 0-9 любой оператор добавить
                    inputField.setText(strInputField + strButton);
                    strNumVariable = "";
                }
                //////////////КОМБИНАЦИЯ ЗНАКОВ//////////////////////////////////
                if (isOperator(strInputField.substring(intLen - 1))) {//!!!

                    if (strInputField.substring(intLen - 2).equals("/-") || strInputField.substring(intLen - 2).equals("*-")) {//два последних "/-" или "*-"
                        if (!strInputField.substring(intLen - 1).equals(strButton)) {
                            //если вводится не совпадающий заменить 2 последних
                            strInputField = strInputField.substring(0, intLen - 2);
                            inputField.setText(strInputField + strButton);
                            strNumVariable = "";
                        }
                        intLen = strInputField.length();
                    }


                    if ("/*".contains(strInputField.substring(intLen - 1)) && (strButton.equals("-"))) {
                        //к "*" или "/" можно добавить "-"
                        inputField.setText(strInputField + strButton);
                        strNumVariable = "";
                        intLen = strInputField.length();
                    }

                    if ("+-".contains(strInputField.substring(intLen - 1)) && !strInputField.substring(intLen - 1).equals(strButton)) {
                        strInputField = strInputField.substring(0, intLen - 1);
                        inputField.setText(strInputField + strButton);
                        strNumVariable = "";
                        intLen = strInputField.length();
                    }

                    if ("/*".contains(strInputField.substring(intLen - 1)) && "+/*".contains(strButton) && !strInputField.substring(intLen - 1).equals(strButton)) {
                        strInputField = strInputField.substring(0, intLen - 1);
                        inputField.setText(strInputField + strButton);
                        strNumVariable = "";
                    }
                }
            }
        }

//////////////////////////////////////////////ВВОД ЧИСЕЛ////////////////////////////////////////////////////

        //проверка вводимого значения члена выражения
        checkInputNumberVariable(strButton);

        if (isNumeric(strButton)) {
            intLen = strInputField.length();
            if (strInputField.isEmpty() && !strNumVariable.isEmpty()) {
                //если строка пустя, а переменная со значением, заменить на переменную
                inputField.setText(strNumVariable);
            }
            /////////////////////////////////////////////////////////////////////
            if (intLen >= 1 && !strNumVariable.isEmpty()) {
                if (isNumeric(strInputField.substring(intLen - 1))) {
                    int i; //найдем последний оператор

                    i = indexInSting(strInputField, ".0123456789");
                    String strBeforeIncludeOperator = strInputField.substring(0, i);
//                    String stringAfterOperator = strInputField.substring(i);

                    inputField.setText(strBeforeIncludeOperator + strNumVariable);
                }
                ///////////////////////////////////////////////////////////////////////
                if (isOperator(strInputField.substring(intLen - 1))) {
                    //если оператор добавить
                    inputField.setText(strInputField + strNumVariable);
                }
                if (strInputField.substring(intLen - 1).equals("(")) {
                    //если открывающая скобка добавить
                    inputField.setText(strInputField + strNumVariable);
                }
            }
        }
/////////////////////////////////////////КНОПКА РАВНО (ВЫЧИСЛИТЬ)/////////////////////////////////////////
        if(isCalc(strButton) && !checkDivisionByZero && !inputField.getText().isEmpty()) {
            //Удалить хвосты (операторы не закрытые числами или скобкой) и не дописанные числа
            strInputField = getStrInputField(strInputField);
            inputField.setText(strInputField);
            if (leftBracketCount == rightBracketCount) {//проверка скобок
                double result = Calculator.handle(inputField.getText());
                String resultStr = (result % 1 == 0) ? String.valueOf((int) result) : String.format("%.3f", result);
                inputField.setText(resultStr);
                strNumVariable = "";
            } else {//в противном случае показать количество скобок
                inputField.setText(strInputField);
            }
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String getStrInputField(String strFromInputField) {
        //подготовка перед пердачей на вычисление
        int i;
        if (strFromInputField.substring(strFromInputField.length()-1).equals(".")) {
            strFromInputField = strFromInputField + "0";
        }
        if ("(+-/*".contains(strFromInputField.substring(strFromInputField.length()-1))) {
            i = indexInSting(strFromInputField, "(+-/*");

            strFromInputField = strFromInputField.substring(0, i);

        }
        return strFromInputField;
    }


    private boolean isDivideByZero(String strInputField, String strButton) {
        //Удалить 0 или 0.00, если есть и ничего не делать
        String strPreviousOperator;

        int intLen = strInputField.length();
        boolean result = false;

        if (intLen > 1 && ("+-/*)=".contains(strButton))) {
            int i; //найдем последний оператор

            i = indexInSting(strInputField, "-.0123456789");
            String stringAfterOperator = strInputField.substring(i);
            String strBeforeIncludeOperator = strInputField.substring(0, i);
            if (i > 0) {
                strPreviousOperator = strInputField.substring(i - 1, i);
            } else {
                strPreviousOperator = strInputField.substring(i);
            }
            //проверка деления на ноль
            if (strPreviousOperator.equals("/") && isZero(stringAfterOperator)) {
                strInputField = strBeforeIncludeOperator; //исключить доление на ноль
                inputField.setText(strInputField);
                strNumVariable = "";
                result = true;
            }
        }
        return result;
    }

    private void changeRightBracketCounter() {
        //измненение значения счетчика правых скобок и запись последнего символа
        strNumVariable = "";
        rightBracketCount++;
    }

    private void changeLeftBracketCounter() {
        //измненение значения счетчика левых скобок и запись последнего символа
        strNumVariable = "";
        leftBracketCount++;
    }


    private boolean isCalc(String strValue) {
        //проверка является ли нажатая кнопка командой начала вычислений
        return strValue.equals("=");

    }

    private static boolean isOperator(String strValue) {
        //проверка является ли нажатая кнопка оператором
        return "+-/*".contains(strValue);
    }


    private static boolean isBracket(String strValue) {
        //проверка является ли нажатая кнопка скобкой
        return "()".contains(strValue);
    }

    private static boolean isNumeric(String strValue) {
        //проверка является ли нажатая кнопка числовой
        return ".0123456789".contains(strValue);
    }

    private static boolean isZero (String strCheckedString) {
        //проверка является ли число нолем (пример 0.00)
        boolean result = true;
        String symbol;
        int len = strCheckedString.length();

        for (int i = 0; i < len ; i++) {
            symbol = strCheckedString.substring((i), i + 1);
            if ("123456789".contains(symbol)) {
//                System.out.println(symbol);
                result = false;
                break;
            } else if ("-0.".contains(symbol)) {
                if (i == 0 && symbol.equals("-") && len > 1) {
                    result = true;
                } else if (i == 1 || i == 2 && symbol.equals(".") && len >= 2) {
                    result = true;
                } else if (symbol.equals("0")) {
                    result = true;
                }
            }
        }
        if (len == 1 && strCheckedString.endsWith("-")) {
            result = false;
        }
        if (len == 0) {
            result = false;
        }
        return result;
    }
    private void checkInputNumberVariable(String strButton) {
        //проверка корректности ввода числа
        if (strNumVariable.isEmpty() && ("0123456789").contains(strButton)) {
            strNumVariable = strButton;
        } else if (strNumVariable.length() == 1 && strNumVariable.equals("0") && ("123456789").contains(strButton)) {
            strNumVariable = strButton;
        } else if (strNumVariable.length() == 1 && ("0123456789").contains(strNumVariable) && strButton.equals(".")) {
            strNumVariable += strButton;
        } else if (strNumVariable.length() == 1 && ("123456789").contains(strNumVariable) && ("0123456789").contains(strButton)) {
            strNumVariable += strButton;
        } else if (strNumVariable.length() > 1 && !strNumVariable.contains(".") && (".0123456789").contains(strButton)) {
            strNumVariable += strButton;
        } else if (strNumVariable.length() > 1 && strNumVariable.contains(".") && ("0123456789").contains(strButton)) {
            strNumVariable += strButton;
        }
    }
    protected static int indexInSting(String strCheckedString, String NotEqual) {
        // найти положение символа не относящегося к числам
        // String NotEqual последовательность, элементы которой пропускаются
        String symbol;
        int len = strCheckedString.length();
        int result = 0;

        for (int i = len; i > 0 ; i--) {
            symbol = strCheckedString.substring((i-1), i);
            if ( !NotEqual.contains(symbol)) {
                result = i;
                break;
            }
        }
        return result;
    }

}

