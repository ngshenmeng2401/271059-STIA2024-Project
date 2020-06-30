package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchData extends JFrame implements ActionListener {

    private JLabel label1;
    private JButton button1,button2,button3;

    public SearchData(){

        getContentPane().setLayout(null);
        setTitle("Search Data");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel();
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));;
        label1.setBounds(20,10,150,80);
        add(label1);

        button1 = new JButton("No Account");
        button2 = new JButton("Name");
        button3 = new JButton("Back");

        button1.setFont(new Font("Dialog",Font.BOLD,12));
        button2.setFont(new Font("Dialog",Font.BOLD,12));
        button3.setFont(new Font("Dialog",Font.BOLD,12));

        button1.setBounds(35,120,120,30);
        button2.setBounds(185,120,120,30);
        button3.setBounds(335,120,120,30);

        add(button1);
        add(button2);
        add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        setVisible(true);
        setBounds(200,120,500,220);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1){
            new SearchNoAkaun();
            setVisible(false);
        }if (e.getSource()==button2){
            new SearchName();
            setVisible(false);
        }if (e.getSource()==button3){
            new MainMenu();
            setVisible(false);
        }
    }
}
