//Домашнее задание, урок 8: Владимир Греков
package lesson8;



import lesson8.components.NumberJButton;
import lesson8.components.OperatorJButton;
import lesson8.listeners.BackSpaceButtonActionListener;
import lesson8.listeners.ButtonListener;
import lesson8.listeners.ClearButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorForm extends JFrame {
    private JTextField inputField;

    public CalculatorForm(String title) throws HeadlessException {
        super(title);
        setBounds(500,300, 280,370);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        inputField.setFont(new Font("Arial",Font.PLAIN, 25));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setMargin(new Insets(8,0,8,0));
        inputField.setBackground(new Color(255,255,255));

        inputField.setText("0");
        return top;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createDelimiterPanel(buttonListener), BorderLayout.BEFORE_FIRST_LINE);
        centerPanel.add(createOperatorPanel(buttonListener), BorderLayout.EAST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4,3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i==9) ? "0" : String.valueOf(i + 1);
            JButton button = new NumberJButton(buttonTitle);
            button.addActionListener(buttonListener);
            digitsPanel.add(button);
        }

        JButton decPoint = new NumberJButton(".");
        decPoint.addActionListener(buttonListener);
        digitsPanel.add(decPoint);

        JButton calc = new OperatorJButton("=");
        calc.setBackground(new Color(148, 181, 210));
        calc.addActionListener(buttonListener);
        digitsPanel.add(calc);
        calc.setEnabled(true);

        return digitsPanel;
    }

    private JPanel createDelimiterPanel(ActionListener buttonListener) {
        JPanel delimiterPanel = new JPanel();
        delimiterPanel.setLayout(new GridLayout(1, 4));

        JButton leftBracket = new OperatorJButton("(");
        leftBracket.addActionListener(buttonListener);
        delimiterPanel.add(leftBracket);

        JButton rightBracket = new OperatorJButton(")");
        rightBracket.addActionListener(buttonListener);
        delimiterPanel.add(rightBracket);

        JButton backSpace = new OperatorJButton("←");
        backSpace.addActionListener(new BackSpaceButtonActionListener(inputField));

        backSpace.setFont(new Font("Arial", Font.PLAIN, 20));
        delimiterPanel.add(backSpace);

        JButton clear = new OperatorJButton("C");

        clear.setFont(new Font("Arial", Font.PLAIN, 25));
        clear.setBackground(new Color(194, 102, 102));
        clear.addActionListener(new ClearButtonActionListener(inputField));
        delimiterPanel.add(clear);

        return delimiterPanel;
    }

    private JPanel createOperatorPanel(ActionListener buttonListener) {
        JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(4,1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        operatorPanel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        operatorPanel.add(plus);

        JButton multiply = new OperatorJButton("*");
        multiply.addActionListener(buttonListener);
        operatorPanel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(buttonListener);
        operatorPanel.add(divide);

        return operatorPanel;
    }
}


