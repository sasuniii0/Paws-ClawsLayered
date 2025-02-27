package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.CustomerDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.CustomerDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public boolean save(Customer entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Customer (custId, name, address, email, contactNumber)\n" +
                        "VALUES (?, ?, ?, ?, ?)",
                entity.getCustomerId(),
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getContactNumber());
    }
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select custId from Customer order by custId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            return String.format("C%03d", newIndex);
        }
        return "C001";
    }

    public ArrayList<Customer> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()) {
            Customer entity = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
            allCustomer.add(entity);
        }
        return allCustomer;
    }

    public boolean delete(String customerId) throws SQLException {
        return SQLUtil.execute("delete from Customer where custId = ?",customerId);
    }

    public boolean update(Customer entity) throws SQLException {
        return  SQLUtil.execute("update Customer set name=?, address =?, email=?, contactNumber=? where custId =?",
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getContactNumber(),
                entity.getCustomerId()
        );
    }

    public ArrayList<String> getAllCustomerIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select custId from Customer");
        ArrayList<String> customerIds = new ArrayList<>();
        while (rst.next()) {
            customerIds.add(rst.getString(1));
        }
        return customerIds;
    }

    public CustomerDto findById(String selectedCustId) throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Customer where custId=?", selectedCustId);

        if (rst.next()) {
            return new CustomerDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    public CustomerDto SearchCustomerByContact(String contactNumber) {
        try{
            ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE contactNumber = ?",contactNumber);
            if (rst.next()){
                return new CustomerDto(
                        rst.getString("custId"),
                        rst.getString("name"),
                        rst.getString("address"),
                        rst.getString("email"),
                        rst.getString("contactNumber")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getCustomerNameById(String selectedCustId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT name FROM Customer WHERE custId = ?", selectedCustId);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "Unknown Customer";
    }
}
