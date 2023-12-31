package GUI;

import Classes.Doctor;
import SubFunctionalities.GUI.ConsultationFunctionalities;
import SubFunctionalities.GUI.DateTime;
import SubFunctionalities.GUI.Table;
import SubFunctionalities.InputValidations.GUIValidations;
import SubFunctionalities.Prompts.GUIPrompts;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class BookConsultation extends BaseFrame {
    private Doctor doctor;
    private int selectedRow;
    private LocalDate date;
    private LocalTime startTime, endTime;
    private JLabel displayData;
    private JButton back, checkAvailability, bookConsultation;
    String formattedText;

    protected BookConsultation() {
        super("Consultations", 1100, 600);
        addContents();

        doctor = null;
        selectedRow = -1;
        date = null;
        startTime = null;
        endTime = null;
    }

    public void addContents() {
        this.addLabels();
        this.addTable();
        this.addButtons();
        this.addDatePicker();
        this.addTimePickers();
    }

    private void addLabels() {
        JLabel heading = new JLabel(GUIPrompts.CONSULTATIONS_HEADING);
        this.mainHeadingLabel(heading, 410, 20);
        this.add(heading);

        JLabel tableHeading = new JLabel(GUIPrompts.SELECT_DOCTOR_SUBHEADING);
        this.subHeadingLabel(tableHeading, 18, 60);
        this.add(tableHeading);

        JLabel dateHeading = new JLabel(GUIPrompts.SELECT_DATE_SUBHEADING);
        this.subHeadingLabel(dateHeading, 310, 410);
        this.add(dateHeading);

        JLabel startTimeHeading = new JLabel(GUIPrompts.SELECT_S_TIME_SUBHEADING);
        this.subHeadingLabel(startTimeHeading, 310, 450);
        this.add(startTimeHeading);

        JLabel endTimeHeading = new JLabel(GUIPrompts.SELECT_E_TIME_SUBHEADING);
        this.subHeadingLabel(endTimeHeading, 310, 490);
        this.add(endTimeHeading);

        JLabel detailBoxHeading = new JLabel(GUIPrompts.DETAIL_BOX_SUBHEADING);
        this.subHeadingLabel(detailBoxHeading, 622, 400);
        this.add(detailBoxHeading);

        displayData = new JLabel(GUIPrompts.DETAIL_BOX_DEFAULT_1);
        displayData.setVerticalAlignment(SwingConstants.TOP);
        displayData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayData.setBounds(527, 430, 267, 110);
        this.add(displayData);
    }

    private void addTable() {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        this.setTable(model, table);
        Table.addTableData(model, GUIPrompts.SELECT_DOCTOR_HEADERS, DOCTOR_ARRAY, "BASIC");

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectedRow = table.getSelectedRow();
                processInputs();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(18, 90, 1050, 300);
        this.add(scrollPane);
    }

    private void addButtons() {
        back = new JButton("Back");
        this.setButton(back, 20, 500, 250, 40);
        this.add(back);

        checkAvailability = new JButton("Check Availability");
        this.setButton(checkAvailability, 815, 450, 250, 40);
        checkAvailability.setEnabled(false);
        this.add(checkAvailability);

        bookConsultation = new JButton("Book Consultation");
        this.setButton(bookConsultation, 815, 500, 250, 40);
        bookConsultation.setEnabled(false);
        this.add(bookConsultation);
    }

    private void addDatePicker() {
        JDatePickerImpl datePicker = DateTime.CreateDatePicker(new Date());

        datePicker.addActionListener(e -> {
            date = DateTime.getDate(datePicker);
            processInputs();
        });

        datePicker.setBounds(410, 410, 43, 30);
        this.add(datePicker);
    }

    private void addTimePickers() {
        JSpinner startTimePicker = DateTime.CreateTimePicker();
        startTimePicker.addChangeListener(e -> {
            this.startTime = DateTime.getTime(startTimePicker);
            processInputs();
        });
        startTimePicker.setBounds(440, 450, 50, 30);
        this.add(startTimePicker);

        JSpinner endTimePicker = DateTime.CreateTimePicker();
        endTimePicker.addChangeListener(e -> {
            this.endTime = DateTime.getTime(endTimePicker);
            processInputs();
        });
        endTimePicker.setBounds(440, 490, 50, 30);
        this.add(endTimePicker);
    }

    private void processInputs() {
        bookConsultation.setEnabled(false);

        // Validating and getting the inputs
        doctor = ConsultationFunctionalities.getDoctor(selectedRow);

        GUIValidations validate = new GUIValidations();
        boolean valid = doctor != null
                & validate.dateInput(date, false, false)
                & validate.consultTimeInput(startTime, endTime, 5, 5, false)
                & validate.consultTimeInput(endTime, startTime, 5, 5, true);

        formattedText = String.format((GUIPrompts.DETAIL_BOX_DYNAMIC_1), doctor != null ? doctor.getFullName()
                        : GUIPrompts.NOT_SELECTED,
                validate.getValidationPrompts().get(0),
                validate.getValidationPrompts().get(1),
                validate.getValidationPrompts().get(2));

        displayData.setText(formattedText);
        checkAvailability.setEnabled(valid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new Menu();

        } else if (e.getSource() == checkAvailability) {
            checkAvailability.setEnabled(false);
            boolean available = ConsultationFunctionalities.getDoctorAvailability(doctor.getMedicalLicenceNumber(),
                    date, startTime, endTime);

            if (available) {
                this.bookConsultation.setEnabled(true);
                displayData.setText(GUIPrompts.appendToHtml(formattedText, GUIPrompts.DOCTOR_AVAILABLE));

            } else {
                this.bookConsultation.setEnabled(false);
                displayData.setText(GUIPrompts.appendToHtml(formattedText, GUIPrompts.NO_ANY_DOCTORS));
            }
        } else if (e.getSource() == bookConsultation) {
            this.setVisible(false);
            new AddPatientDetails(doctor, date, startTime, endTime);
        }
    }
}


