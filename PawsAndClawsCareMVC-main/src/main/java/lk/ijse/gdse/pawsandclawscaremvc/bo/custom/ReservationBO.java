package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ReservationDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
     ObservableList<String> getAllCustomerId() throws SQLException;
     boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;
     ArrayList<String> getAvailableEmployee() throws SQLException;
     String getSelectedServicePrice(String selectedService) throws SQLException;
    boolean saveReservation(ReservationDto dto) throws SQLException;
    String getNextId() throws SQLException;
    ArrayList<ServiceDetailsDto> getAll() throws SQLException;
    boolean delete(String customerId) throws SQLException ;
    boolean update(ServiceDetailsDto dto) throws SQLException;

}
