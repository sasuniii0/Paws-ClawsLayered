package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;

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

}
