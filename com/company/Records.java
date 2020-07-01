package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class Records extends JFrame implements ActionListener {

    private JTable output;
    DefaultTableModel dtm2;
    private JButton button1;
    private JLabel label1;

    public Records(){

        setTitle("Records");
        setLocation(200,120);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Pay Bill System", dialogButton);
                if (dialogResult == 0) {
                    System.exit(0);
                }
            }
        });

        label1 = new JLabel();
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));;
        label1.setBounds(20,10,150,80);
        add(label1);

        String[] header2 = new String[]{"Account No", "Name","Address","Date Bill","Invoice No","Meter No","Previos Meter","Current Meter","Tunggakan"};



        button1 = new JButton("Main Menu");
        button1.setBounds(600, 300, 100, 25);
        add(button1);
        button1.addActionListener(this);

        setSize(800, 450);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){
            new MainMenu();
            setVisible(false);
        }

    }

}
