package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.CustomerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerManageBO extends SuperBO {
     ArrayList<String> getAllCustomerIds() throws SQLException;
     CustomerDto findById(String selectedCustId) throws SQLException;
     CustomerDto SearchCustomerByContact(String contactNumber);
     String getCustomerNameById(String selectedCustId) throws SQLException;
     boolean saveCustomer(CustomerDto customerDto) throws SQLException;
     String getNextCustomerId() throws SQLException;
     ArrayList<CustomerDto> getAllCustomer() throws SQLException;
     boolean deleteCustomer(String customerId) throws SQLException ;
     boolean updateCustomer(CustomerDto customerDto) throws SQLException;
}
