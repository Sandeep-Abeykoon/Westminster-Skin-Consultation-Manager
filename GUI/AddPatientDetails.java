package GUI;

import SubFunctionalities.Prompts.GUIPrompts;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddPatientDetails extends BaseFrame{

    protected AddPatientDetails() {
        super("Add patient Details", 1100, 600);
        this.addLabels();
    }

    private void addLabels() {
        JLabel heading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.mainHeadingLabel(heading, 410, 20);
        this.add(heading);

        JLabel patientDetailHeading = new JLabel(GUIPrompts.ADD_PATIENT_DETAILS);
        this.subHeadingLabel(patientDetailHeading, 30, 80);
        this.add(patientDetailHeading);

        JLabel fNameLabel  = new JLabel(GUIPrompts.FIRST_NAME_SUBHEADING);
        this.subHeadingLabel(fNameLabel, 30, 100);
        this.add(fNameLabel);

        JLabel lNameLabel = new JLabel(GUIPrompts.LAST_NAME_SUBHEADING);
        this.subHeadingLabel(lNameLabel, 200, 100);
        this.add(lNameLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
