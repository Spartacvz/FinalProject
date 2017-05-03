package com.Greg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ToDoList extends JFrame {

    private JTabbedPane ToDoTabs;
    private JButton addTaskALL;
    private JTable allTable;
    private JButton addTaskWORK;
    private JButton addTaskSCHOOL;
    private JButton addTaskPERSONAL;
    private JButton addListButton;
    private JButton deleteTaskALL;
    private JTable workTable;
    private JTable schoolTable;
    private JTable personalTable;
    private JButton deleteTaskSCHOOL;
    private JButton deleteTaskPERSONAL;
    private JButton deleteTaskWORK;
    private JPanel primaryPanel;
    private JButton button1;

    DefaultTableModel model1;
    DefaultTableModel model;

    public ToDoList() {

        setContentPane(primaryPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        addTaskWORK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTaskWORK();
            }

        });

        deleteTaskWORK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTaskWORK();
            }
        });
    }

    // This method adds row to jtable
    private void AddTaskWORK()    {
        // Accepts user input
        String name = JOptionPane.showInputDialog("Task Name:");
        String desc = JOptionPane.showInputDialog("Task Description:");
        String due = JOptionPane.showInputDialog("Due Date:");
        Date date = new Date();

        // Create array to store data
        Object rowData[] = new Object[4];
        // Store items in array
        rowData[0] = name;
        rowData[1] = desc;
        rowData[2] = due;
        rowData[3] = date;
        // Adds array to default table model
        model = (DefaultTableModel)workTable.getModel();
        // Adds default table model info to JTable
        model.addRow(rowData);

        // Adds array to default table model
        model1 = (DefaultTableModel)allTable.getModel();
        // Adds default table model info to JTable
        model1.addRow(rowData);
    }

    private void DeleteTaskWORK() {
        try {
            // Adds array to default table model
            DefaultTableModel model = (DefaultTableModel) workTable.getModel();
            // Counts the number of rows
            int rowCount = model.getRowCount();
            // Gets user input in string form
            String row = JOptionPane.showInputDialog("Enter the Number of the Task You'd Like to Delete");
            // Converts string to int
            int rowNum = Integer.parseInt(row);
            if (rowNum > rowCount) {
                JOptionPane.showInputDialog("Sorry That is NOT a Valid Row, Try Again");
                DeleteTaskWORK();
            }
            // Adds default table model info to JTable
            model.removeRow(rowNum);
        } catch (Exception e) {
            JOptionPane.showInputDialog("Sorry that input was invalid, please try again");
            DeleteTaskWORK();
        }
    }

    // This method adds row to jtable
    private void AddTaskSCHOOL()    {
        // Accepts user input
        String name = JOptionPane.showInputDialog("Task Name:");
        String desc = JOptionPane.showInputDialog("Task Description:");
        String due = JOptionPane.showInputDialog("Due Date:");
        Date date = new Date();

        // Create array to store data
        Object rowData[] = new Object[4];
        // Store items in array
        rowData[0] = name;
        rowData[1] = desc;
        rowData[2] = due;
        rowData[3] = date;
        // Adds array to default table model
        DefaultTableModel model = (DefaultTableModel)schoolTable.getModel();
        // Adds default table model info to JTable
        model.addRow(rowData);
    }

    private void DeleteTaskSCHOOL() {
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
            DeleteTaskSCHOOL();
        }
    }

    // This method adds row to jtable
    private void AddTaskPERSONAL()    {
        // Accepts user input
        String name = JOptionPane.showInputDialog("Task Name:");
        String desc = JOptionPane.showInputDialog("Task Description:");
        String due = JOptionPane.showInputDialog("Due Date:");
        Date date = new Date();

        // Create array to store data
        Object rowData[] = new Object[4];
        // Store items in array
        rowData[0] = name;
        rowData[1] = desc;
        rowData[2] = due;
        rowData[3] = date;
        // Adds array to default table model
        DefaultTableModel model = (DefaultTableModel)personalTable.getModel();
        // Adds default table model info to JTable
        model.addRow(rowData);
    }

    private void DeleteTaskPERSONAL() {
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
            DeleteTaskPERSONAL();
        }
    }

    // This method adds row to jtable
    private void AddTaskALL()    {
        // Accepts user input
        String name = JOptionPane.showInputDialog("Task Name:");
        String desc = JOptionPane.showInputDialog("Task Description:");
        String due = JOptionPane.showInputDialog("Due Date:");
        Date date = new Date();

        // Create array to store data
        Object rowData[] = new Object[4];
        // Store items in array
        rowData[0] = name;
        rowData[1] = desc;
        rowData[2] = due;
        rowData[3] = date;
        // Adds array to default table model
        DefaultTableModel model = (DefaultTableModel)allTable.getModel();
        // Adds default table model info to JTable
        model.addRow(rowData);
    }

    private void DeleteTaskALL() {
        try {
            // Adds array to default table model
            DefaultTableModel model = (DefaultTableModel) workTable.getModel();
            // Counts the number of rows
            int rowCount = model.getRowCount();
            // Gets user input in string form
            String row = JOptionPane.showInputDialog("Enter the Number of the Task You'd Like to Delete");
            // Converts string to int
            int rowNum = Integer.parseInt(row);
            if (rowNum > rowCount) {
                JOptionPane.showInputDialog("Sorry That is NOT a Valid Row, Try Again");
                DeleteTaskALL();
            }
            // Adds default table model info to JTable
            model.removeRow(rowNum);
        } catch (Exception e) {
            JOptionPane.showInputDialog("Sorry that input was invalid, please try again");
            DeleteTaskALL();
        }
    }
}
