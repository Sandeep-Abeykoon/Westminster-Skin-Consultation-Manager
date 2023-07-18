package GUI;

import SubFunctionalities.GUI.DateTime;
import SubFunctionalities.Prompts.GUIPrompts;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

public class AddPatientDetails extends BaseFrame{

    private String date;

    protected AddPatientDetails() {
        super("Add patient Details", 1100, 600);
        this.date = "";
        this.addContents();
    }

    public void addContents() {
        this.addLabels();
        this.addTextFields();
        this.addDatePicker();
        this.addTextArea();
    }

    private void addLabels() {
        JLabel heading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.mainHeadingLabel(heading, 410, 20);
        this.add(heading);

        JLabel patientDetailHeading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.subHeadingLabel(patientDetailHeading, 30, 85);
        this.add(patientDetailHeading);

        JLabel fNameLabel  = new JLabel(GUIPrompts.FIRST_NAME_SUBHEADING);
        this.subHeadingLabel(fNameLabel, 30, 120);
        this.add(fNameLabel);

        JLabel sNameLabel = new JLabel(GUIPrompts.SUR_NAME_SUBHEADING);
        this.subHeadingLabel(sNameLabel, 200, 120);
        this.add(sNameLabel);

        JLabel dateOfBirthLabel = new JLabel(GUIPrompts.SELECT_DOB_SUBHEADING);
        this.subHeadingLabel(dateOfBirthLabel, 30, 186);
        this.add(dateOfBirthLabel);

        JLabel mobileNumberLabel = new JLabel(GUIPrompts.MOBILE_NUMBER_SUBHEADING);
        this.subHeadingLabel(mobileNumberLabel, 30, 254);
        this.add(mobileNumberLabel);

        JLabel patientIdLabel = new JLabel(GUIPrompts.PATIENT_ID_SUBHEADING);
        this.subHeadingLabel(patientIdLabel, 30, 320);
        this.add(patientIdLabel);

        JLabel notesLabel  = new JLabel(GUIPrompts.FIRST_NAME_SUBHEADING);
        this.subHeadingLabel(notesLabel, 30, 120);
        this.add(notesLabel);
    }

    private void addTextFields() {
        JTextField firstNameField = new JTextField(20);
        firstNameField.setBounds(30, 148, 155, 28);
        this.add(firstNameField);

        JTextField surNameField = new JTextField(20);
        surNameField.setBounds(200, 148, 155, 28);
        this.add(surNameField);

        JTextField mobileNumberField = new JTextField(20);
        mobileNumberField.setText(GUIPrompts.DUMMY_MOBILE_NUMBER);
        mobileNumberField.setBounds(30, 282, 155, 28);
        mobileNumberField.setForeground(Color.GRAY);
        mobileNumberField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(mobileNumberField.getText().equals(GUIPrompts.DUMMY_MOBILE_NUMBER)){
                    mobileNumberField.setText("");
                    mobileNumberField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (mobileNumberField.getText().isEmpty()){
                    mobileNumberField.setText(GUIPrompts.DUMMY_MOBILE_NUMBER);
                    mobileNumberField.setForeground(Color.GRAY);
                }
            }
        });
        this.add(mobileNumberField);

        JTextField patientIdField = new JTextField(20);
        patientIdField.setBounds(30, 348, 155, 28);
        this.add(patientIdField);
    }

    private void addDatePicker() {
        JDatePickerImpl datePicker = DateTime.CreateDatePicker(new Date());

        datePicker.addActionListener(e -> {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            this.date = selectedDate.toString();
            //processInputs();
        });

        datePicker.setBounds(72, 214, 43, 30);
        this.add(datePicker);
    }

    private void addTextArea(){
        JTextArea noteTextArea = new JTextArea(10, 20);
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);
        noteTextArea.setText(GUIPrompts.PATIENT_NOTE_PROMPT);
        noteTextArea.setForeground(Color.GRAY);

        JScrollPane scrollPane = new JScrollPane(noteTextArea);
        noteTextArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(noteTextArea.getText().equals(GUIPrompts.PATIENT_NOTE_PROMPT)){
                    noteTextArea.setText("");
                    noteTextArea.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (noteTextArea.getText().isEmpty()){
                    noteTextArea.setText(GUIPrompts.PATIENT_NOTE_PROMPT);
                    noteTextArea.setForeground(Color.GRAY);
                }
            }
        });
        scrollPane.setBounds(30, 386, 325, 130);
        this.add(scrollPane);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
