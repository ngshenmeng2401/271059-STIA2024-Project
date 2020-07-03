package com.company;

import coronaVirus.CoronaVirus;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//import static com.company.ElectricityBillingSystem.customerList;

public class Records extends JFrame implements ActionListener {

    String[] header = new String[]{"Date Bill", "Account No", "Invoice No", "Name", "Address", "Meter No", "Previos Meter", "Current Meter", "Total Usage", "Tunggakan", "Current Charges", "Total CurrentCharge"};

    JTable output;
    DefaultTableModel dtm;
    JScrollPane jsp;
    JButton search,edit, delete,back;
    JLabel picture,label1,label2;
    JTextField text1,text2;
    JPanel panel1,panel2;
    DefaultTableModel dtm2;


    public Records() {
        ImageIcon icon = new ImageIcon("images/Logo.png");
        setIconImage(icon.getImage());
        outputTable();
        outputPanel1();
        outputPanel2();
        setTitle("Records");
        setLocation(400, 75);
        setSize(750, 550);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

        picture = new JLabel();
        picture.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH)));
        picture.setBounds(20, 10, 150, 80);
        add(picture);


        for (Customer customer:ElectricityBillingSystem.customerList) {
            System.out.println(customer);
        }

        System.out.println(ElectricityBillingSystem.customerList);
    }

    public void outputPanel1(){

        panel1 = new JPanel();
        panel1.setBounds(20, 105, 700, 60);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createEtchedBorder());
        add(panel1);

        label1 = new JLabel("Account No:");
        label1.setBounds(10,15,70,30);
        panel1.add(label1);

        text1 = new JTextField(20);
        text1.setBounds(90,15,150,30);
        panel1.add(text1);

        label2 = new JLabel("Name:");
        label2.setBounds(390,15,50,30);
        panel1.add(label2);

        text2 = new JTextField();
        text2.setBounds(450,15,230,30);
        panel1.add(text2);
    }

    public void outputPanel2(){

        panel2 = new JPanel();
        panel2.setBounds(20, 420, 700, 75);
        panel2.setLayout(null);
        panel2.setBorder(BorderFactory.createEtchedBorder());
        add(panel2);

        search = new JButton("Search");
        search.setBounds(75, 20, 100, 30);
        panel2.add(search);
        search.addActionListener(this);

        edit = new JButton("Edit");
        edit.setBounds(225, 20, 100, 30);
        panel2.add(edit);
        edit.addActionListener(this);

        delete = new JButton("Delete");
        delete.setBounds(375, 20, 100, 30);
        panel2.add(delete);
        delete.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(525, 20, 100, 30);
        panel2.add(back);
        back.addActionListener(this);
    }

    public void outputTable() {
        dtm = new DefaultTableModel(header, 0);
        output = new JTable();

        JTableHeader header = output.getTableHeader();
        int headerHeight = 30;
        header.setPreferredSize(new Dimension(50, headerHeight));
        ((DefaultTableCellRenderer) output.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        output.setModel(dtm);

        for (int i = 0; i < 12; i++) {
            output.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        output.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        output.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        output.setDefaultRenderer(Object.class, centerRenderer);
        output.getTableHeader().setReorderingAllowed(false);
        output.getTableHeader().setResizingAllowed(false);
        output.setDefaultEditor(Object.class, null);
        output.setRowHeight(30);

        dtm.setRowCount(0);
        for (Customer cus : ElectricityBillingSystem.customerList) {
            String t9 = String.format("%.2f", cus.t9);
            String cC = String.format("%.2f", cus.cC);
            String tCC = String.format("%.2f", cus.tCC);
            Object[] objs = {cus.t1, cus.t2, cus.t3, cus.t4, cus.t5, cus.t6, cus.t7, cus.t8, cus.tU, t9, cC, tCC};
            dtm.addRow(objs);
        }
        jsp = new JScrollPane();
        jsp.setViewportView(output);
        jsp.setBounds(20, 180, 700, 230);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jsp);

    }

    public int binarySearch(Long aacNo, ArrayList<Customer> customerList){

        int i=0;
        int j=customerList.size()-1;

        while (i<=j){

            int mid=(i+j)/2;
            if (customerList.get(mid).getT2()==aacNo){
                return mid;
            }else if (customerList.get(mid).getT2()>aacNo){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return -1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==search){

            Long t1 = Long.parseLong(text1.getText());
            String t2 = text2.getText();

            int index = binarySearch(t1,ElectricityBillingSystem.customerList);

            if (index >= 0)
            {

                dtm2.setRowCount(0);
                Object[] objs = {ElectricityBillingSystem.customerList.get(index).t1,ElectricityBillingSystem.customerList.get(index).t2,ElectricityBillingSystem.customerList.get(index).t3,ElectricityBillingSystem.customerList.get(index).t4,ElectricityBillingSystem.customerList.get(index).t5,ElectricityBillingSystem.customerList.get(index).t6,ElectricityBillingSystem.customerList.get(index).t7,ElectricityBillingSystem.customerList.get(index).t8,ElectricityBillingSystem.customerList.get(index).t9,ElectricityBillingSystem.customerList.get(index).cC,ElectricityBillingSystem.customerList.get(index).tCC};
                dtm2.addRow(objs);
            }
            else
            {

                JOptionPane.showMessageDialog(null, "Not found!");
            }
        }

        if (e.getSource() == back) {
            new MainMenu();
            setVisible(false);
        }

        int row = output.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) output.getModel();

        if (e.getSource() == delete) {
            if (ElectricityBillingSystem.customerList.isEmpty()) {
                if (e.getSource() == delete) {
                    JOptionPane.showMessageDialog(this, "List is empty", "Electricity Billing System", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (e.getSource() == delete) {
                    if (output.getSelectionModel().isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please select a row that you want to delete", "Electricity Billing System", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the data?", "Electricity Billing System", dialogButton);
                        if (dialogResult == 0) {
                            ElectricityBillingSystem.customerList.remove(row);
                            model.removeRow(row);
                            ElectricityBillingSystem ebs = new ElectricityBillingSystem();
                            ebs.fileWriter();
                        }
                    }
                }
            }
        }

        if (e.getSource() == edit) {
            if (ElectricityBillingSystem.customerList.isEmpty()) {
                if (e.getSource() == edit) {
                    JOptionPane.showMessageDialog(this, "List is empty", "Electricity Billing System", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (e.getSource() == edit) {
                    if (output.getSelectionModel().isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please select a row that you want to edit.", "Electricity Billing System", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to edit the data?", "Electricity Billing System", dialogButton);
                        if (dialogResult == 0) {
                            new EditData();
                        }
                    }
                }
            }
        }
    }
}