package GUI;

import SubFunctionalities.Prompts.GUIPrompts;
import SubFunctionalities.GUI.DateTime;
import SubFunctionalities.GUI.Table;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class Consultations extends BaseFrame {

    private JTable table;
    private JButton back;

    protected Consultations() {
        super("Consultations", 1100, 600);
        addContents();
    }

    public void addContents() {
        this.addLabels();
        this.addTable();
        this.addButtons();
        this.addDatePicker();
        this.addTimePicker();
    }

    private void addLabels() {
        JLabel heading = new JLabel(GUIPrompts.CONSULTATIONS_HEADING);
        this.mainHeadingLabel(heading, 410, 20);
        this.add(heading);

        JLabel tableHeading = new JLabel(GUIPrompts.SELECT_DOCTOR_SUBHEADING);
        this.subHeadingLabel(tableHeading, 18, 60);
        this.add(tableHeading);

        JLabel dateHeading = new JLabel(GUIPrompts.SELECT_DATE_SUBHEADING);
        this.subHeadingLabel(dateHeading, 380, 410);
        this.add(dateHeading);

        JLabel startTimeHeading = new JLabel(GUIPrompts.SELECT_S_TIME_SUBHEADING);
        this.subHeadingLabel(startTimeHeading, 380, 450);
        this.add(startTimeHeading);

        JLabel endTimeHeading = new JLabel(GUIPrompts.SELECT_E_TIME_SUBHEADING);
        this.subHeadingLabel(endTimeHeading, 380, 490);
        this.add(endTimeHeading);

        JLabel displayData = new JLabel("Sandeep Abeykoon");
        displayData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayData.setBounds(640, 430, 300, 100);
        this.add(displayData);
    }

    private void addTable() {
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        Table.addTableData(model, GUIPrompts.SELECT_DOCTOR_HEADERS, DOCTOR_ARRAY, "TYPICAL_DATA");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 90, 1050, 300);
        this.add(scrollPane);
    }

    private void addButtons() {
        back = new JButton("Back");
        this.setButton(back, 26, 480, 250, 40);
        this.add(back);
    }

    private void addDatePicker(){
        JDatePickerImpl datePicker = DateTime.CreateDatePicker(new Date());
        datePicker.setBounds(480, 410, 43, 30);
        this.add(datePicker);
    }

    private void addTimePicker(){
        JSpinner startTime = DateTime.CreateTimePicker();
        startTime.setBounds(510, 450, 50, 30);
        this.add(startTime);

        JSpinner endTime = DateTime.CreateTimePicker();
        endTime.setBounds(510, 490, 50, 30);
        this.add(endTime);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new Menu();
        }
    }
}

