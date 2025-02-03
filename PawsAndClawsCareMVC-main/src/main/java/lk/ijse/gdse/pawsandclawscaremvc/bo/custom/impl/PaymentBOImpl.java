package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.PaymentBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        return null;
    }

    @Override
    public ObservableList<String> getAllReservationIds() throws SQLException {
        return null;
    }

    @Override
    public void displayCustomerDetailsByResId(String newValue) throws SQLException {

    }

    @Override
    public void displayCustomerDetailsByOrderId(String newValue) throws SQLException {

    }

    @Override
    public ArrayList<PaymentDto> searchPaymentsByEmail(String searchText) throws SQLException {
        return null;
    }

    @Override
    public boolean save(PaymentDto dto) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<PaymentDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PaymentDto dto) throws SQLException {
        return false;
    }
}
