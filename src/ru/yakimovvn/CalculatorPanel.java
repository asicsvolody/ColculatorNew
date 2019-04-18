package ru.yakimovvn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorPanel extends JPanel {
    private double result=0;
    private String lastCommand="=";
    private JLabel display;
    private JPanel panel;
    private int symbolNumber=1;
    private boolean start=true;
    CalculatorPanel(){
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        display=new JLabel("0",JLabel.RIGHT);
        //display.setEnabled(false);
        //display.setBounds(5,45,280,70);
        display.setPreferredSize(new Dimension(290,140));
        display.setOpaque(true);
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setVerticalAlignment(SwingConstants.BOTTOM);
        Font fontDisplay=new Font("TimesRoman",Font.ITALIC,60);
        display.setFont(fontDisplay);
        add(display,BorderLayout.NORTH);

        ActionListener numberAct=new NumberAction();
        ActionListener command=new CommandAction();

        panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.BLACK);


        addButton("c",command,"c.jpg");
        addButton("+/-",command,"plasMin.jpg");
        addButton("%",command,"proz.jpg");
        addButton("/",command,"del.jpg");

        addButton("7",numberAct,"seven.jpg");
        addButton("8",numberAct,"eight.jpg");
        addButton("9",numberAct,"nine.jpg");
        addButton("*",command,"umn.jpg");

        addButton("4",numberAct,"four.jpg");
        addButton("5",numberAct,"five.jpg");
        addButton("6",numberAct,"six.jpg");
        addButton("-",command,"minus.jpg");

        addButton("1",numberAct,"one.jpg");
        addButton("2",numberAct,"two.jpg");
        addButton("3",numberAct,"three.jpg");
        addButton("+",command,"plus.jpg");

        addButton("0",numberAct,"zero.jpg");
        addButton(".",numberAct,"double.jpg");
        addButton("=",command,"ravno.jpg");

        add(panel,BorderLayout.CENTER);



    }
    private void addButton(String label,ActionListener listener,String file ){
        final String TRIP="./images/";
        JButton button=new JButton();
        button.setActionCommand(label);
        if(label.equals("0")) button.setPreferredSize(new Dimension(138,68));
        else button.setPreferredSize(new Dimension(68,68));
        button.setIcon(new ImageIcon(TRIP+file));
        button.addActionListener(listener);
        button.setFocusPainted(false);
        panel.add(button,BorderLayout.CENTER);
    }
    private class NumberAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String input=event.getActionCommand();
            if(start){
                if (input.equals(".")){
                    display.setText("0");
                    start=false;
                    symbolNumber++;
                }
                else {
                    display.setText("");
                    start = false;
                }
            }

            if (symbolNumber<=10){
                display.setText(display.getText()+input);
                symbolNumber++;
            }
        }
    }
    private class  CommandAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String command=event.getActionCommand();

            if(command.equals("c")) {
                result=0;
                lastCommand="=";
                display.setText("0");
                start=true;
            }
            else if (command.equals("+/-")) display.setText(""+(Double.parseDouble(display.getText())*(-1)));
            else if (command.equals("%")) display.setText(""+((result*Double.parseDouble(display.getText()))/100));
            else if (start){
                if(command.equals("-")){
                    display.setText("-");
                    start=false;
                }
                else lastCommand=command;
            }
            else {

                calculator(Double.parseDouble(display.getText()));
                lastCommand=command;
                start=true;
            }
        }
    }
    private void calculator(double x){
        char lastCommandChar=lastCommand.charAt(0);
         switch(lastCommandChar){
             case '-':
                 result-=x;
                 break;
             case '/':
                 result/=x;
                 break;
             case '*':
                 result*=x;
                 break;
             case 'c':
                 result=0;
                 lastCommand="=";
                 display.setText("0");
                 start=true;
                 break;
             case '=':
                 result=x;
                 break;


         }
        /*
        if(lastCommand.equals("+")) result+=x;
        else if(lastCommand.equals("-")) result-=x;
        else if(lastCommand.equals("/")) result/=x;
        else if(lastCommand.equals("*")) result*=x;
        else if(lastCommand.equals("c")) {
            result=0;
            lastCommand="=";
            display.setText("0");
            start=true;
        }
        else if(lastCommand.equals("=")) result=x;

         */
        display.setText(""+result);



    }
}