package lk.ijse.gdse.pawsandclawscaremvc.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private String customerId;
    private String customerName;
    private String address;
    private String email;
    private String contactNumber;
}
