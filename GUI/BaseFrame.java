package GUI;

import Classes.Doctor;
import Classes.WestminsterSkinConsultationManager;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class BaseFrame extends JFrame implements ActionListener {
    protected static final ArrayList<Doctor> DOCTOR_ARRAY = WestminsterSkinConsultationManager.getDoctorList();
    protected BaseFrame(String title, int width, int height){
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);  //Makes the frame center of the screen
        this.setLayout(null);
        this.setVisible(true);
    }

    protected void setButton(JButton button, int x, int y, int width, int height){
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.setHorizontalTextPosition(0);
        button.setVerticalTextPosition(0);
        button.setBackground(Color.GRAY);
        button.addActionListener(this);
    }

    public void setTable(DefaultTableModel model, JTable table){

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, cellRenderer);

        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        table.setRowHeight(table.getRowHeight() + 15);
        table.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.setGridColor(Color.BLACK);
    }
}
