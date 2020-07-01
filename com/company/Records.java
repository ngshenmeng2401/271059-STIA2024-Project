package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static com.company.AddData.CustomerList;

public class Records extends JFrame implements ActionListener {

    private JPanel contentPane,panel;
    private JTable table;
    private JButton button1;
    private JLabel label1;

    public Records(){

        panel = new JPanel();
        label1 = new JLabel();
        contentPane = new JPanel();
        label1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("Logo.png")).getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH)));;
        label1.setBounds(20,-10,150,80);
        contentPane.add(label1);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });

        setTitle("Records");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,120, 550, 300);
        setSize(800, 450);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));

        button1 = new JButton("Main Menu");
        button1.setBounds(600, 300, 100, 25);
        contentPane.add(button1);
        button1.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);

    }

    protected void do_this_windowActivated(WindowEvent e) {

        DefaultTableModel defaulttablemodel = (DefaultTableModel) table.getModel();
        defaulttablemodel.setColumnIdentifiers(new Object[]{"", "Document", "(Below 2kg)", "Parcel", "(above 2kg)",});


        JTableHeader tb = table.getTableHeader();
        tb.setBackground(Color.white);

        table.setRowHeight(30);
        table.setModel(defaulttablemodel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){
            new MainMenu();
            setVisible(false);
        }

    }

}
