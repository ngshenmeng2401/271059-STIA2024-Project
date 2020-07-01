package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    private JButton button1,button2,button3,button4;
    private JLabel label;

    public static void main(String[] args) {
        new MainMenu();
    }

    MainMenu(){

        getContentPane().setLayout(null);
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label= new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));;
        label.setBounds(20,10,150,80);
        add(label);

        button1 = new JButton("Add Data");
        button2 = new JButton("Search");
        button3 = new JButton("Display Records");
        button4 = new JButton("Exit");

        button1.setFont(new Font("Dialog",Font.BOLD,14));
        button2.setFont(new Font("Dialog",Font.BOLD,14));
        button3.setFont(new Font("Dialog",Font.BOLD,14));
        button4.setFont(new Font("Dialog",Font.BOLD,14));

        button1.setBounds(70,100,150,40);
        button2.setBounds(270,100,150,40);
        button3.setBounds(70,150,150,40);
        button4.setBounds(270,150,150,40);

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        setVisible(true);
        setBounds(200,120,500,250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            new AddData();
            setVisible(false);

        }if(e.getSource()==button2){
            new SearchData();
            setVisible(false);

        }if (e.getSource()==button3){
            new Records();
            setVisible(false);

        }if (e.getSource()==button4){
            JOptionPane.showMessageDialog(this, "Thanks For Using Our System");
            System.exit(0);
        }
    }
}
