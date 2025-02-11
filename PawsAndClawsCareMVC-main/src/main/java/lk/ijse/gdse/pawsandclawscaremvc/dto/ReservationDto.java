package lk.ijse.gdse.pawsandclawscaremvc.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReservationDto {
    private String resId;
    private String dropOffTime;
    private String custId;
    private String date;
    private String empId;


private ArrayList<ServiceDetailsDto> serviceDetailsDtos;

    public ReservationDto(String resId, String dropOffTime, String custId, String selectedDate, String employee, String text, ArrayList<ServiceDetailsDto> serviceDetailsDtos) {
    }
}
