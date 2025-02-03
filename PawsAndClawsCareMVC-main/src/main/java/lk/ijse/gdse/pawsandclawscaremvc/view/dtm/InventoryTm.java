package lk.ijse.gdse.pawsandclawscaremvc.view.dtm;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryTm {
    private String inventoryId;
    private Date stockUpdate;
    private String inventoryCategory;
    private String availabilityStatus;
}
