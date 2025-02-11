package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.CustomerDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
     ArrayList<String> getAllCustomerIds() throws SQLException;
     String getCustomerNameById(String selectedCustId) throws SQLException ;
     boolean save(Customer entity) throws SQLException ;
     String getNextId() throws SQLException;
     ArrayList<Customer> getAll() throws SQLException;
     boolean delete(String customerId) throws SQLException ;
     boolean update(Customer entity) throws SQLException ;
     CustomerDto findById(String selectedCustId) throws SQLException ;
     CustomerDto SearchCustomerByContact(String contactNumber) ;
    }
