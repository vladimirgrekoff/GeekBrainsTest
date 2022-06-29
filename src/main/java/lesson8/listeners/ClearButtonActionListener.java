//Домашнее задание, урок 8: Владимир Греков
package lesson8.listeners;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonActionListener implements ActionListener {
    private JTextField inputField;

    public ClearButtonActionListener(JTextField inputField) {
        this.inputField = inputField;
    }

    public void actionPerformed(ActionEvent e) {
        inputField.setText("");
        ButtonListener.setStrNumVariable("");
    }
}