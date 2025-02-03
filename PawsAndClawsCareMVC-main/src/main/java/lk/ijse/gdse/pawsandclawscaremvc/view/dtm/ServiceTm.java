package lk.ijse.gdse.pawsandclawscaremvc.view.dtm;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTm {
    private String serviceId;
    private String availability;
    private String description;
    private Time Duration;
    private double price;
}
