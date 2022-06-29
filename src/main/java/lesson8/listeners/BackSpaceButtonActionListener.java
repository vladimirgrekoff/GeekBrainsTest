//Домашнее задание, урок 8: Владимир Греков
package lesson8.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.Objects.isNull;

public class BackSpaceButtonActionListener implements ActionListener {
    //слушатель кнопки BackSpace
    private JTextField inputField;

    public BackSpaceButtonActionListener(JTextField inputField) {
        this.inputField = inputField;
    }



    public void actionPerformed(ActionEvent e) {
        int i;
        int intInputFieldLen;
        int intNumVariableLen;
        int leftBracketCount;
        int rightBracketCount;
        String strNumVariable;
        String stringAfterOperator;
//        String strBeforeIncludeOperator;
        String symbolInInputField;
        String symbolInNumVariable;
        String strString;
        String strProcessingNumVariable;

        strString = inputField.getText();
        strNumVariable = ButtonListener.getStrNumVariable();
        strProcessingNumVariable = strNumVariable;

        if(isNull(strNumVariable)){
            strProcessingNumVariable = strString;
        }

        leftBracketCount = ButtonListener.getLeftBracketCount();
        rightBracketCount = ButtonListener.getRightBracketCount();


        if (!strString.isEmpty()) {
            intInputFieldLen = strString.length();
            intNumVariableLen = strProcessingNumVariable.length();
            symbolInInputField = strString.substring(intInputFieldLen-1);
            if (intNumVariableLen == 0){
                //найдем последний оператор
                i = ButtonListener.indexInSting(strString,".0123456789");
                stringAfterOperator = strString.substring(i);
//                strBeforeIncludeOperator = strString.substring(0, i);
//                    System.out.println("строка до оператора, включая оператор: " + strBeforeIncludeOperator);
//                    System.out.println("строка после оператора: " + stringAfterOperator);
                strProcessingNumVariable = stringAfterOperator;
                intNumVariableLen = strProcessingNumVariable.length();
            }

            if (intNumVariableLen != 0) {
                symbolInNumVariable = strProcessingNumVariable.substring(intNumVariableLen-1);

                if (symbolInNumVariable.equals(symbolInInputField)) {
                    strProcessingNumVariable = strProcessingNumVariable.substring(0, intNumVariableLen-1);
                }
            }

            if (symbolInInputField.equals("(")) {
                ButtonListener.setLeftBracketCount(--leftBracketCount);
            }

            if (symbolInInputField.equals(")")) {
                ButtonListener.setRightBracketCount(--rightBracketCount);
            }

            strString = strString.substring(0, intInputFieldLen-1);
//                System.out.println("Значение переменной в слушателе: " + strProcessingNumVariable);
            if (".0123456789".contains(strString.substring(intInputFieldLen-1)) && strProcessingNumVariable.isEmpty()){
                i = ButtonListener.indexInSting(strString,".0123456789");
                stringAfterOperator = strString.substring(i);
                strProcessingNumVariable = stringAfterOperator;
            }

            inputField.setText(strString);

            ButtonListener.setStrNumVariable(strProcessingNumVariable);

        }
    }
}