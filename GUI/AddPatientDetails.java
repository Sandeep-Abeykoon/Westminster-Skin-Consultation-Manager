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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
