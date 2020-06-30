package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AddData extends JFrame implements ActionListener {

    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    private JTextField text1,text2,text3, text4,text5A,text5B,text5C,text6,text7,text8,text9;
    private JButton button1,button2,button3;
    private String t1,t2,t3,t4,t5a,t5b,t5c,t6,t7,t8,t9;
    private double currentMeter,previousMeter,tunggakan;
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public AddData(){

        getContentPane().setLayout(null);
        setTitle("Add Data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label10= new JLabel();
        label10.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));;
        label10.setBounds(20,10,150,80);
        add(label10);

        label1 = new JLabel("Date Bill:");
        label2 = new JLabel("Account No:");
        label3 = new JLabel("Invoice No:");
        label4 = new JLabel("Name:");
        label5 = new JLabel("Address:");
        label6 = new JLabel("Meter No:");
        label7 = new JLabel("Previos Meter:");
        label8 = new JLabel("Current Meter:");
        label9 = new JLabel("Tunggakan:");

        text1 = new JTextField(10);
        text2 = new JTextField(10);
        text3 = new JTextField(10);
        text4 = new JTextField(50);
        text5A = new JTextField(60);
        text5B = new JTextField(60);
        text5C = new JTextField(60);
        text6 = new JTextField(10);
        text7 = new JTextField(10);
        text8 = new JTextField(10);
        text9 = new JTextField(10);

        button1 = new JButton("Save");
        button2 = new JButton("Reset");
        button3 = new JButton("Back");

        label1.setBounds(50,120,100,25);
        label2.setBounds(50,150,100,25);
        label3.setBounds(50,180,100,25);
        label4.setBounds(50,210,100,25);
        label5.setBounds(50,240,100,25);
        label6.setBounds(50,330,100,25);
        label7.setBounds(50,360,100,25);
        label8.setBounds(50,390,100,25);
        label9.setBounds(50,420,100,25);

        text1.setBounds(150,120,100,25);
        text2.setBounds(150,150,100,25);
        text3.setBounds(150,180,100,25);
        text4.setBounds(150,210,400,25);
        text5A.setBounds(150,240,300,25);
        text5B.setBounds(150,270,300,25);
        text5C.setBounds(150,300,300,25);
        text6.setBounds(150,330,100,25);
        text7.setBounds(150,360,100,25);
        text8.setBounds(150,390,100,25);
        text9.setBounds(150,420,100,25);

        button1.setBounds(50,480,100,25);
        button2.setBounds(250,480,100,25);
        button3.setBounds(450,480,100,25);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(label9);

        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(text5A);
        add(text5B);
        add(text5C);
        add(text6);
        add(text7);
        add(text8);
        add(text9);

        add(button1);
        add(button2);
        add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        setVisible(true);
        setBounds(200,120,600,600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){

            try{
                t1 = text1.getText();
                t2 = text2.getText();
                t3 = text3.getText();
                t4 = text4.getText();
                t5a = text5A.getText();
                t5b = text5B.getText();
                t5c = text5C.getText();
                t6 = text6.getText();
                t7 = text7.getText();
                t8 = text8.getText();
                t9 = text9.getText();

                previousMeter = Double.parseDouble(t7);
                currentMeter = Double.parseDouble(t8);
                tunggakan = Double.parseDouble(t9);

                CalculateData cData = new CalculateData(currentMeter,previousMeter,tunggakan);
                cData.calculateBill();
                cData.setCurrentMeter(currentMeter);
                cData.setPreviousMeter(previousMeter);
                customerList.add(new Customer(t1,t2,t3,t4,t5a,t5b,t5c,t6,t7,t8,t9,cData.getTotalUsage(),cData.getCurrentCharge(),cData.getTotalcurrentCharge()));

                try {
                    FileWriter fw = new FileWriter("Customer.txt");
                    fw.write(String.valueOf(customerList));
                    fw.flush();
                    fw.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
//                System.out.println(customerList);
                JOptionPane.showMessageDialog(this, "Data Saved");

            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(this, "Please key in data!!!");

            }

        }if (e.getSource()==button2){

            text1.setText(null);
            text2.setText(null);
            text3.setText(null);
            text4.setText(null);
            text5A.setText(null);
            text5B.setText(null);
            text5C.setText(null);
            text6.setText(null);
            text7.setText(null);
            text8.setText(null);
            text9.setText(null);

        }if (e.getSource()==button3){
            new MainMenu();
            setVisible(false);
        }
    }
}
