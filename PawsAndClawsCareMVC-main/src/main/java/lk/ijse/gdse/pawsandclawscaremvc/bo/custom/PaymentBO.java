package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    ObservableList<String> getAllOrderIds() throws SQLException;
    ObservableList<String> getAllReservationIds() throws SQLException;
    void displayCustomerDetailsByResId(String newValue) throws SQLException;
    void displayCustomerDetailsByOrderId(String newValue) throws SQLException;
    ArrayList<Payment> searchPaymentsByEmail(String searchText) throws SQLException;
    boolean savePayment(PaymentDto dto) throws SQLException;
    String getNextPaymentId() throws SQLException;
    ArrayList<PaymentDto> getAllPayment() throws SQLException;
    boolean deletePayment(String customerId) throws SQLException ;
    boolean updatePayment(PaymentDto dto) throws SQLException;

}
