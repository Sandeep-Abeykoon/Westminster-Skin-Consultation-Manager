package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Menu extends BaseFrame {
private JButton viewDoctors, bookConsultation, exit;

    public Menu(){
        super("Menu", 420, 420);
        addContents();
    }

    private void addContents(){
        addButtons();
    }

    private void addButtons(){
        viewDoctors = new JButton("VIEW DOCTORS");
        this.setButton(viewDoctors, 90, 80, 220, 70);
        this.add(viewDoctors);

        bookConsultation = new JButton("BOOK CONSULTATION");
        this.setButton(bookConsultation, 90, 160, 220, 70);
        this.add(bookConsultation);

        exit = new JButton("EXIT");
        this.setButton(exit, 90, 240, 220, 70);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.viewDoctors){
            this.dispose();
            new ViewDoctors();

        } else if(e.getSource() == this.bookConsultation) {
            this.dispose();
            new Consultations();

        } else if(e.getSource() == this.exit){
            this.dispose();
        }
    }
}