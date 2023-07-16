package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation {
    private static final ArrayList<Consultation> CONSULTATION_ARRAY = new ArrayList<>();
    private LocalDate date;
    private LocalTime time;
    private double cost;
    private String notes;
}


