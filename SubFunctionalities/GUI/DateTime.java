package SubFunctionalities.GUI;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public abstract class DateTime {
    public static JDatePickerImpl CreateDatePicker(Date startDate){
        SqlDateModel model = new SqlDateModel();

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl panel = new JDatePanelImpl(model, p);

        if (!(startDate == null)){
            model.setValue(new java.sql.Date(startDate.getTime()));

            Calendar minDate = Calendar.getInstance();
            minDate.setTime(startDate);
        }

        return new JDatePickerImpl(panel, null);
    }

    public static JSpinner CreateTimePicker(){
        SpinnerModel spinnerModel = new SpinnerDateModel();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        spinnerModel.setValue(calendar.getTime());

        JSpinner timeSpinner = new JSpinner(spinnerModel);

        JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(editor);

        return timeSpinner;
    }

    public static String getTime(JSpinner jSpinner){
        Date d = (Date) jSpinner.getModel().getValue();
        LocalTime time = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault()).toLocalTime();
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
