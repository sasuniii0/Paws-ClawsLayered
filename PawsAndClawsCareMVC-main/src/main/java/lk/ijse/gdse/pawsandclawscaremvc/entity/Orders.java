package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private String orderId;
    private String customerId;
    private Date orderDate;

    private ArrayList<OrderDetails> orderDetails;
}
