package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ReservationDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.ServiceDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
     ObservableList<String> getAllCustomerId() throws SQLException;
     boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;
     ArrayList<String> getAvailableEmployee() throws SQLException;
     String getSelectedServicePrice(String selectedService) throws SQLException;
    boolean saveReservation(ReservationDto dto) throws SQLException;
    String getNextReservationId() throws SQLException;
    ArrayList<ServiceDetailsDto> getAllReservation() throws SQLException;
    boolean deleteReservation(String customerId) throws SQLException ;
    boolean updateReservation(ReservationDto dto) throws SQLException;

}
