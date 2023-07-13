package GUI;

import SubFunctionalities.FunctionalPrompts.GUIPrompts;
import SubFunctionalities.GUI.TableFunctionalities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class CheckDoctorAvailability extends BaseFrame{

    private JTable table;

    protected CheckDoctorAvailability() {
        super("Doctor Availability", 1100, 600);
        addContents();
    }

    public void addContents(){
        this.addLabels();
        this.addTable();
    }

    private void addLabels(){
        JLabel heading = new JLabel("CHECK DOCTOR AVAILABILITY");
        this.mainHeadingLabel(heading, 370, 20);
        this.add(heading);
    }

    private void addTable(){
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table, true);
        TableFunctionalities.addTableData(model, GUIPrompts.SELECT_DOCTOR, DOCTOR_ARRAY, "TYPICAL_DATA");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 80, 1050, 333);
        this.add(scrollPane);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
