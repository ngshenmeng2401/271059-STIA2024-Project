package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchNoAkaun extends JFrame implements ActionListener {

    private JLabel label1,label2;
    private JButton button1,button2;
    private JTextField text1;

    public SearchNoAkaun(){

        getContentPane().setLayout(null);
        setTitle("Search No Akaun");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));;
        label1.setBounds(20,10,150,80);
        add(label1);

        label2 = new JLabel("No Akaun:");
        label2.setBounds(35,120,100,30);
        add(label2);

        text1 = new JTextField();
        text1.setBounds(200,120,120,30);
        add(text1);

        button1 = new JButton("Search");
        button2 = new JButton("Back");

        button1.setFont(new Font("Dialog",Font.BOLD,12));
        button2.setFont(new Font("Dialog",Font.BOLD,12));

        button1.setBounds(35,160,120,30);
        button2.setBounds(335,160,120,30);

        add(button1);
        add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        setVisible(true);
        setBounds(200,120,500,250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1){


        }if (e.getSource()==button2){
            new SearchData();
            setVisible(false);
        }
    }
}
