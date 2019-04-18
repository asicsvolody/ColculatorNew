package ru.yakimovvn;

import javax.swing.*;

class CalculatorFrame extends JFrame {
     CalculatorFrame(){
        super("Calculator");
        setBounds(0,40,300,530);
        setResizable(false);
        CalculatorPanel panel=new CalculatorPanel();
        add(panel);
        //pack();
    }
}
