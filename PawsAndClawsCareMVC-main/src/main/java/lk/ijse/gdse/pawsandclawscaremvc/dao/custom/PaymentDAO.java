package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentDAO  extends CrudDAO<Payment> {
     ObservableList<String> getAllOrderIds() throws SQLException ;
     ObservableList<String> getAllReservationIds() throws SQLException;
     void displayCustomerDetailsByResId(String newValue) throws SQLException;
     void displayCustomerDetailsByOrderId(String newValue) throws SQLException;
     ArrayList<PaymentDto> searchPaymentsByEmail(String searchText) throws SQLException;
}
