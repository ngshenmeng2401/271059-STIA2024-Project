package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import static com.company.AddData.customerList;

public class SearchNoAkaun extends JFrame implements ActionListener {

    private JLabel label1,label2;
    private JButton button1,button2;
    private JTextField text1;
    private int accNo;
    private String t1;

    public SearchNoAkaun(){

        getContentPane().setLayout(null);
        setTitle("Search No Akaun");
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

            t1=text1.getText();
            accNo=Integer.parseInt(t1);
            binarySearch(accNo,customerList);

            System.out.println(customerList);

        }if (e.getSource()==button2){
            new SearchData();
            setVisible(false);
        }
    }

    public int binarySearch(int accNo,ArrayList<Customer> customerList){

        int i=0;
        int j=customerList.size()-1;
        int mid=(i+j)/2;

        while (i<=j){


            if (customerList.get(mid).getAccNo()==accNo){
                return mid;
            }else if (customerList.get(mid).getAccNo()>accNo){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return mid;
    }
}
