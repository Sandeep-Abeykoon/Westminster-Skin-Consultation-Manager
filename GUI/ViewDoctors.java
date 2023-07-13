package GUI;

import Classes.WestminsterSkinConsultationManager;
import SubFunctionalities.FunctionalPrompts.GUIPrompts;
import SubFunctionalities.GUI.Functionalities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class ViewDoctors extends BaseFrame{
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
        
    }



    @Override
    public void actionPerformed(ActionEvent e){

    }
}

