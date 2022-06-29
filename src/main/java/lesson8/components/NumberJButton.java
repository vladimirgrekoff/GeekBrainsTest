//Домашнее задание, урок 8: Владимир Греков
package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class NumberJButton extends JButton {

    public NumberJButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 25));
        this.setPreferredSize(new Dimension(65, 40));
        setBackground(new Color(154,195,231));
    }
}