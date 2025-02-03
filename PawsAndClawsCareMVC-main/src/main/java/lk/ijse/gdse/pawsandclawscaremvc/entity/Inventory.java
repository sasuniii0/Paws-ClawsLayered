package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private String inventoryId;
    private Date stockUpdate;
    private String inventoryCategory;
    private String availabilityStatus;
}
