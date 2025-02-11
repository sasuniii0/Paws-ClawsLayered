package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.SuperDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
     ArrayList<Payment> getAll() throws SQLException;
     void displayCustomerDetailsByResId(String newValue) throws SQLException;
     void displayCustomerDetailsByOrderId(String newValue) throws SQLException;
     boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;
     ArrayList<PaymentDto> searchPaymentsByEmail(String searchText) throws SQLException;
     ServiceDto findServiceByEmployeeId(String empId) throws SQLException;
    }
