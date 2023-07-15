package GUI;

import SubFunctionalities.GUI.DateTime;
import SubFunctionalities.GUI.Table;
import SubFunctionalities.Prompts.GUIPrompts;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class Consultations extends BaseFrame {
    private String doctorId, date, startTime, endTime, cost;
    private JLabel displayData;
    private JButton back;

    protected Consultations() {
        super("Consultations", 1100, 600);
        this.doctorId = "";
        this.date = "";
        this.startTime = "";
        this.endTime = "";
        this.cost = "";
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
        this.subHeadingLabel(dateHeading, 370, 410);
        this.add(dateHeading);

        JLabel startTimeHeading = new JLabel(GUIPrompts.SELECT_S_TIME_SUBHEADING);
        this.subHeadingLabel(startTimeHeading, 370, 450);
        this.add(startTimeHeading);

        JLabel endTimeHeading = new JLabel(GUIPrompts.SELECT_E_TIME_SUBHEADING);
        this.subHeadingLabel(endTimeHeading, 370, 490);
        this.add(endTimeHeading);

        JLabel detailBoxHeading = new JLabel(GUIPrompts.DETAIL_BOX_SUBHEADING);
        this.subHeadingLabel(detailBoxHeading, 755, 400);
        this.add(detailBoxHeading);

        displayData = new JLabel(GUIPrompts.DETAIL_BOX_DEFAULT_1);
        displayData.setVerticalAlignment(SwingConstants.TOP);
        displayData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayData.setBounds(630, 430, 300, 110);
        this.add(displayData);
    }

    private void addTable() {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        Table.addTableData(model, GUIPrompts.SELECT_DOCTOR_HEADERS, DOCTOR_ARRAY, "TYPICAL_DATA");

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()){
                this.doctorId = (DOCTOR_ARRAY.get(table.getSelectedRow())).getMedicalLicenceNumber();
                getInputs();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 90, 1050, 300);
        this.add(scrollPane);
    }

    private void addButtons() {
        back = new JButton("Back");
        this.setButton(back, 26, 480, 250, 40);
        this.add(back);
    }

    private void addDatePicker() {
        JDatePickerImpl datePicker = DateTime.CreateDatePicker(new Date());

        datePicker.addActionListener(e -> {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            date = selectedDate.toString();
            getInputs();
        });

        datePicker.setBounds(470, 410, 43, 30);
        this.add(datePicker);
    }

    private void addTimePicker(){
        JSpinner startTimePicker = DateTime.CreateTimePicker();
        startTimePicker.addChangeListener(e -> {
            this.startTime = DateTime.getTime(startTimePicker);
            getInputs();
        });
        startTimePicker.setBounds(500, 450, 50, 30);
        this.add(startTimePicker);

        JSpinner endTimePicker = DateTime.CreateTimePicker();
        endTimePicker.addChangeListener(e -> {
            this.endTime = DateTime.getTime(endTimePicker);
            getInputs();
        });
        endTimePicker.setBounds(500, 490, 50, 30);
        this.add(endTimePicker);
    }

    private void getInputs(){
        String formattedText = String.format((GUIPrompts.DETAIL_BOX_DYNAMIC),doctorId, date, startTime, endTime, cost);
        displayData.setText(formattedText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new Menu();
        }
    }
}

