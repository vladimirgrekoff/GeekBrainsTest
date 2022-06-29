//Домашнее задание, урок 8: Владимир Греков
package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class OperatorJButton extends JButton {

    public OperatorJButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 25));
        this.setPreferredSize(new Dimension(65, 40));
        setBackground(new Color(182, 184, 187));
    }
}