package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String proId;
    private int quantity;
    private double price;
}
