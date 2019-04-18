package ru.yakimovvn;

import javax.swing.*;
import java.awt.*;



public class Calculator {

    public static void main(String[] args){
        try {


            EventQueue.invokeLater(() -> {

                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            });
        }catch (Exception e){
            System.exit(0);

        }
    }
}