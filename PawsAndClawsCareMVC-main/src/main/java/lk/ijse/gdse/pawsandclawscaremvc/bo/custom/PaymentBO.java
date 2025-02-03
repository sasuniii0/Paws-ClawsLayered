package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    ObservableList<String> getAllOrderIds() throws SQLException;
    ObservableList<String> getAllReservationIds() throws SQLException;
    void displayCustomerDetailsByResId(String newValue) throws SQLException;
    void displayCustomerDetailsByOrderId(String newValue) throws SQLException;
    ArrayList<PaymentDto> searchPaymentsByEmail(String searchText) throws SQLException;
    boolean save(PaymentDto dto) throws SQLException;
    String getNextId() throws SQLException;
    ArrayList<PaymentDto> getAll() throws SQLException;
    boolean delete(String customerId) throws SQLException ;
    boolean update(PaymentDto dto) throws SQLException;

}
