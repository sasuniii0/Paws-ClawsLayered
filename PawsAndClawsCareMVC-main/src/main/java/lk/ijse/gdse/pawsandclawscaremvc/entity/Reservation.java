package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Reservation {
    private String resId;
    private String dropOffTime;
    private String custId;
    private String date;
    private String empId;


private ArrayList<ServiceDetails> serviceDetails;

    public Reservation(String string, Time time, String string1, Date date) {
    }

    public Reservation(String resId, String dropOffTime, String custId, String date) {
    }
}
