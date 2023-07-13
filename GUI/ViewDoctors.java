package GUI;

import Classes.WestminsterSkinConsultationManager;
import SubFunctionalities.FunctionalPrompts.GUIPrompts;
import SubFunctionalities.GUI.Functionalities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class ViewDoctors extends BaseFrame{

    JButton back, sortByFName;
    public ViewDoctors(){
        super("View Doctors", 1100, 600);
        this.addContent();
    }

    private void addContent(){
        addTable();
        addButtons();
    }

    private void addTable(){
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        Functionalities.addTableData(model, GUIPrompts.TABLE_HEADERS, WestminsterSkinConsultationManager.getDoctorList());

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

        JButton sortByLName = new JButton("Sort by Last Name");
        this.setButton(sortByLName, 546, 480, 250, 40);
        this.add(sortByLName);

        JButton reset = new JButton("Reset");
        this.setButton(reset, 806, 480, 250, 40);
        this.add(reset);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.back){
            this.dispose();
            new Menu();
        }else if(e.getSource() == this.sortByFName){

        }
    }
}

