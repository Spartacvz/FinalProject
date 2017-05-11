package com.Greg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class ToDoList extends JFrame {

    private JPanel primaryPanel;

    private JTabbedPane ToDoTabs;

    private JButton addTaskWORK;
    private JButton addTaskSCHOOL;
    private JButton addTaskPERSONAL;
    private JButton addListButton;
    private JButton deleteTaskSCHOOL;
    private JButton deleteTaskPERSONAL;
    private JButton deleteTaskWORK;
    private JButton editTaskButton;

    private JTable allTable;
    private JTable workTable;
    private JTable schoolTable;
    private JTable personalTable;
    private JButton editTaskSchool;
    private JButton editTaskPersonal;
    private JPanel tabALL;
    private JPanel tabWork;
    private JPanel tabSchool;
    private JPanel tabPersonal;
    private JOptionPane jop;



    DefaultTableModel model1;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/task_list";
    String user = "root";
    String pw = "number21";


    public ToDoList() {

        setContentPane(primaryPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setSize(350,500);


        addMouseListener();

        addTaskWORK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddTaskWORK();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteTaskWORK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTaskWORK();
            }
        });

        addTaskSCHOOL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddTaskSCHOOL();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteTaskSCHOOL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTaskSCHOOL();
            }
        });

        addTaskPERSONAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTaskPERSONAL();
            }
        });

        deleteTaskPERSONAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTaskPERSONAL();
            }
        });

        addListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = JOptionPane.showInputDialog("What would you like to name this new task list?");
                JPanel newTab = new JPanel(Boolean.parseBoolean(name));
                ToDoTabs.add(newTab);
                primaryPanel.add(ToDoTabs);

                try {
                    Connection con = DriverManager.getConnection(url, user, pw);
                    Statement state = con.createStatement();
                    state.execute("CREATE TABLE new(\n" +
                            "    task_number INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                            "    task_name VARCHAR(30) NOT NULL,\n" +
                            "    task_description VARCHAR(60) NULL,\n" +
                            "    entry_date TIMESTAMP,\n" +
                            "    due_date DATE NULL,\n" +
                            "    task_complete ENUM('Y', 'N') NULL);");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void addMouseListener() {
    }

    private void AddTaskWORK() throws ClassNotFoundException {

        JTextField nnum = new JTextField(5);
        JTextField nname = new JTextField(5);
        JTextField ddesc = new JTextField(5);
        JTextField ddueDate = new JTextField(5);
        String [] done = {" ", "Yes", "No"};
        Object[] options = new Object[] {};
        JComboBox ccomplete = new JComboBox(done);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Task Number:"));
        myPanel.add(nnum);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Name:"));
        myPanel.add(nname);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Description:"));
        myPanel.add(ddesc);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Due Date:"));
        myPanel.add(ddueDate);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Complete:"));
        myPanel.add(ccomplete);
        myPanel.add(Box.createVerticalStrut(5));

        String num = nnum.getText();
        String name = nname.getText();
        String desc = ddesc.getText();
        String dueDate = ddueDate.getText();
        String complete = (String) ccomplete.getSelectedItem();
        Date date = new Date();

        if(num == null){}
        else if (name == null){}
        else if (desc == null){}
        else if (dueDate == null){}
        else if (ccomplete == null){}
        else {AddTaskALL();}

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Task Details Here:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            // Create array to store data
            Object rowData[] = new Object[6];
            // Store items in array
            rowData[0] = num;
            rowData[1] = name;
            rowData[2] = desc;
            rowData[3] = dueDate;
            rowData[4] = date;
            rowData[5] = complete;

            // Adds array to default table model
            model = (DefaultTableModel) workTable.getModel();
            // Adds default table model info to JTable
            model.addRow(rowData);

            AddTaskALL();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pw);
                Statement state = con.createStatement();
                state.execute("INSERT INTO all_tasks VALUES(num, name, desc, dueDate, date, complete)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void DeleteTaskWORK()  {
        try {
            // Adds array to default table model
            DefaultTableModel model = (DefaultTableModel) workTable.getModel();
            // Counts the number of rows
            int rowCount = model.getRowCount();
            // Gets user input in string form
            String rowww = JOptionPane.showInputDialog("Enter the Number of the Task You'd Like to Delete");
            // Converts string to int
            int rowNum = Integer.parseInt(rowww);
            if (rowNum > rowCount) {
                JOptionPane.showInputDialog("Sorry That is NOT a Valid Row, Try Again");
                DeleteTaskWORK();
            }
            // Adds default table model info to JTable
            model.removeRow(rowNum);

            Connection con = DriverManager.getConnection(url, user, pw);
            Statement state = con.createStatement();
            state.execute("DELETE FROM ROWS WHERE task_num = rowww");

        } catch (Exception e) {
            JOptionPane.showInputDialog("Sorry that input was invalid, please try again");
            DeleteTaskALL();
        }
    }

    private void AddTaskSCHOOL() throws ClassNotFoundException {
        JTextField num = new JTextField(5);
        JTextField name = new JTextField(5);
        JTextField desc = new JTextField(5);
        JTextField dueDate = new JTextField(5);
        String [] done = {"Yes", "No"};
        Object[] options = new Object[] {};
        JComboBox complete = new JComboBox(done);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Task Number:"));
        myPanel.add(num);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Name:"));
        myPanel.add(name);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Description:"));
        myPanel.add(desc);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Due Date:"));
        myPanel.add(dueDate);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Complete:"));
        myPanel.add(complete);
        myPanel.add(Box.createVerticalStrut(5));

        Date date = new Date();

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Task Details Here:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            // Create array to store data
            Object rowData[] = new Object[6];
            // Store items in array
            rowData[0] = num;
            rowData[1] = name;
            rowData[2] = desc;
            rowData[3] = dueDate;
            rowData[4] = date;
            rowData[5] = complete;

            // Adds array to default table model
            model = (DefaultTableModel) schoolTable.getModel();
            // Adds default table model info to JTable
            model.addRow(rowData);

            AddTaskALL();
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pw);
            Statement state = con.createStatement();
            state.execute("INSERT INTO all_tasks VALUES(num, name, desc, dueDate, date, complete)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void DeleteTaskSCHOOL()  {
        try {
            // Adds array to default table model
            DefaultTableModel model = (DefaultTableModel) schoolTable.getModel();
            // Counts the number of rows
            int rowCount = model.getRowCount();
            // Gets user input in string form
            String row = JOptionPane.showInputDialog("Enter the Number of the Task You'd Like to Delete");
            // Converts string to int
            int rowNum = Integer.parseInt(row);
            if (rowNum > rowCount) {
                JOptionPane.showInputDialog("Sorry That is NOT a Valid Row, Try Again");
                DeleteTaskSCHOOL();
            }
            // Adds default table model info to JTable
            model.removeRow(rowNum);
        } catch (Exception e) {
            JOptionPane.showInputDialog("Sorry that input was invalid, please try again");
            DeleteTaskALL();
        }
    }

    private void AddTaskPERSONAL()  {
        JTextField num = new JTextField(5);
        JTextField name = new JTextField(5);
        JTextField desc = new JTextField(5);
        JTextField dueDate = new JTextField(5);
        String [] done = {"Yes", "No"};
        Object[] options = new Object[] {};
        JComboBox complete = new JComboBox(done);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Task Number:"));
        myPanel.add(num);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Name:"));
        myPanel.add(name);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Description:"));
        myPanel.add(desc);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Due Date:"));
        myPanel.add(dueDate);
        myPanel.add(Box.createVerticalStrut(5));

        myPanel.add(new JLabel("Task Complete:"));
        myPanel.add(complete);
        myPanel.add(Box.createVerticalStrut(5));

        Date date = new Date();

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Task Details Here:", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            // Create array to store data
            Object rowData[] = new Object[6];
            // Store items in array
            rowData[0] = num;
            rowData[1] = name;
            rowData[2] = desc;
            rowData[3] = dueDate;
            rowData[4] = date;
            rowData[5] = complete;

            // Adds array to default table model
            model = (DefaultTableModel) personalTable.getModel();
            // Adds default table model info to JTable
            model.addRow(rowData);

            AddTaskALL();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pw);
                Statement state = con.createStatement();
                state.execute("INSERT INTO all_tasks VALUES(num, name, desc, dueDate, date, complete)");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void DeleteTaskPERSONAL()  {
        try {
            // Adds array to default table model
            DefaultTableModel model = (DefaultTableModel) personalTable.getModel();
            // Counts the number of rows
            int rowCount = model.getRowCount();
            // Gets user input in string form
            String row = JOptionPane.showInputDialog("Enter the Number of the Task You'd Like to Delete");
            // Converts string to int
            int rowNum = Integer.parseInt(row);
            if (rowNum > rowCount) {
                JOptionPane.showInputDialog("Sorry That is NOT a Valid Row, Try Again");
                DeleteTaskPERSONAL();
            }
            // Adds default table model info to JTable
            model.removeRow(rowNum);
        } catch (Exception e) {
            JOptionPane.showInputDialog("Sorry that input was invalid, please try again");
            DeleteTaskALL();
        }
    }

    private void AddTaskALL()  {

    }

    private void DeleteTaskALL()  {
    }
}
