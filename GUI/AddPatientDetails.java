package GUI;

import SubFunctionalities.GUI.DateTime;
import SubFunctionalities.GUI.TextFieldChangeListener;
import SubFunctionalities.InputValidations.GUIValidations;
import SubFunctionalities.Prompts.GUIPrompts;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

public class AddPatientDetails extends BaseFrame{

    private String firstName, surName, dateOfBirth, mobileNumber, patientId;
    private String formattedText;
    private JButton back, proceed;
    private JLabel displayData;

    protected AddPatientDetails() {
        super("Add patient Details", 1100, 600);
        this.firstName = "";
        this.surName = "";
        this.dateOfBirth = "";
        this.mobileNumber = "";
        this.patientId = "";
        this.addContents();
    }

    public void addContents() {
        this.addLabels();
        this.addTextFields();
        this.addDatePicker();
        this.addTextArea();
        this.addButtons();
    }

    private void addLabels() {
        JLabel heading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.mainHeadingLabel(heading, 410, 20);
        this.add(heading);

        JLabel patientDetailHeading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.subHeadingLabel(patientDetailHeading, 30, 85);
        this.add(patientDetailHeading);

        JLabel additionalDetailHeading = new JLabel(GUIPrompts.ADD_ADDITIONAL_DETAILS);
        this.subHeadingLabel(additionalDetailHeading, 550, 85);
        this.add(additionalDetailHeading);

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

        JLabel notesLabel  = new JLabel(GUIPrompts.ADDITIONAL_NOTES_SUBHEADING);
        this.subHeadingLabel(notesLabel, 550, 120);
        this.add(notesLabel);

        JLabel imageLabel  = new JLabel(GUIPrompts.ADD_IMAGE_SUBHEADING);
        this.subHeadingLabel(imageLabel, 550, 306);
        this.add(imageLabel);

        JLabel detailBoxHeading = new JLabel(GUIPrompts.DETAIL_BOX_SUBHEADING);
        this.subHeadingLabel(detailBoxHeading, 622, 400);
        this.add(detailBoxHeading);

        displayData = new JLabel(GUIPrompts.DETAIL_BOX_DEFAULT_2);
        displayData.setVerticalAlignment(SwingConstants.TOP);
        displayData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        displayData.setBounds(527, 430, 250, 110);
        this.add(displayData);
    }

    private void addTextFields() {
        JTextField firstNameField = new JTextField(20);
        firstNameField.setBounds(30, 148, 155, 28);

        TextFieldChangeListener.addChangeListener(firstNameField, () -> {
            firstName = firstNameField.getText();
            processInputs();
        });
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
            this.dateOfBirth = selectedDate.toString();
            processInputs();
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
        scrollPane.setBounds(550, 148, 400, 130);
        this.add(scrollPane);
    }

    private void addButtons(){
        back = new JButton("Back");
        this.setButton(back, 20, 500, 250, 40);
        this.add(back);

        proceed = new JButton("Proceed");
        this.setButton(proceed, 815, 500, 250, 40);
        proceed.setEnabled(false);
        this.add(proceed);
    }

    private void processInputs(){
        proceed.setEnabled(false);
        GUIValidations validate = new GUIValidations(firstName, surName, dateOfBirth, mobileNumber, patientId);
        boolean valid = validate.validatePatient();

        String[] outputs = validate.getOutputs();

        formattedText = String.format((GUIPrompts.DETAIL_BOX_DYNAMIC_2), outputs[0], outputs[1], outputs[2], outputs[3], outputs[4]);
        displayData.setText(formattedText);
        proceed.setEnabled(valid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            this.dispose();
            new BookConsultation();
        }
    }
}
