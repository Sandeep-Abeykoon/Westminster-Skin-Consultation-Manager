package GUI;

import SubFunctionalities.FunctionalPrompts.GUIPrompts;
import SubFunctionalities.GUI.TableFunctionalities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class Consultations extends BaseFrame{

    private JTable table;
    private JButton back;

    protected Consultations() {
        super("Consultations", 1100, 600);
        addContents();
    }

    public void addContents(){
        this.addLabels();
        this.addTable();
        this.addButtons();
    }

    private void addLabels(){
        JLabel heading = new JLabel(GUIPrompts.CONSULTATIONS_HEADING);
        this.mainHeadingLabel(heading, 370, 20);
        this.add(heading);

        JLabel tableHeading = new JLabel(GUIPrompts.SELECT_DOCTOR_SUBHEADING);
        this.subHeadingLabel(tableHeading, 18, 60);
        this.add(tableHeading);

        JLabel dateHeading = new JLabel(GUIPrompts.SELECT_DATE_SUBHEADING);
        this.subHeadingLabel(dateHeading,400 , 450);
        this.add(dateHeading);
    }

    private void addTable(){
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        TableFunctionalities.addTableData(model, GUIPrompts.SELECT_DOCTOR_HEADERS, DOCTOR_ARRAY, "TYPICAL_DATA");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 90, 1050, 333);
        this.add(scrollPane);
    }

    private void addButtons(){
        back = new JButton("Back");
        this.setButton(back, 26, 480, 250, 40);
        this.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.dispose();
            new Menu();
        }
    }
}
