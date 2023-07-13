package GUI;

import SubFunctionalities.FunctionalPrompts.GUIPrompts;
import SubFunctionalities.GUI.TableFunctionalities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class ViewDoctors extends BaseFrame{
    private JTable table;
    private JButton back, sortByFName, sortByLName, reset;
    public ViewDoctors(){
        super("View Doctors", 1100, 600);
        this.addContent();
    }

    private void addContent(){
        addTable();
        addButtons();
    }

    private void addTable(){
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        TableFunctionalities.addTableData(model, GUIPrompts.TABLE_HEADERS, DOCTOR_ARRAY);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 80, 1050, 333);
        this.add(scrollPane);
    }

    private void addButtons(){
        back = new JButton("Back");
        this.setButton(back, 26, 480, 250, 40);
        this.add(back);

        sortByFName = new JButton("Sort by First Name");
        this.setButton(sortByFName, 286, 480, 250, 40);
        this.add(sortByFName);

        sortByLName = new JButton("Sort by Last Name");
        this.setButton(sortByLName, 546, 480, 250, 40);
        this.add(sortByLName);

        reset = new JButton("Reset");
        this.setButton(reset, 806, 480, 250, 40);
        this.add(reset);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.back){
            this.dispose();
            new Menu();
        }else if(e.getSource() == this.sortByFName){
            TableFunctionalities.sortTable(table, 1, SortOrder.ASCENDING, DOCTOR_ARRAY);
        } else if(e.getSource() == this.sortByLName){
            TableFunctionalities.sortTable(table, 2, SortOrder.ASCENDING, DOCTOR_ARRAY);
        }else if(e.getSource() == this.reset){
            this.table.setRowSorter(null);
        }
    }
}

