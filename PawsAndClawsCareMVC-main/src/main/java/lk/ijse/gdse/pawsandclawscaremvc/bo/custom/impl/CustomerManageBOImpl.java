package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.CustomerManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.CustomerDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.CustomerDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerManageBOImpl implements CustomerManageBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<String> getAllCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public CustomerDto findById(String selectedCustId) throws SQLException {
        return null;
    }

    @Override
    public CustomerDto SearchCustomerByContact(String contactNumber) {
        return null;
    }

    @Override
    public String getCustomerNameById(String selectedCustId) throws SQLException {
        return "";
    }

    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException {
        return customerDAO.save(new Customer(customerDto.getCustomerId(),customerDto.getCustomerName(),customerDto.getAddress(),customerDto.getEmail(),customerDto.getContactNumber()));
    }

    @Override
    public String getNextCustomerId() throws SQLException {
        return customerDAO.getNextId();
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers){
            customerDtos.add(new CustomerDto(customer.getCustomerId(),customer.getCustomerName(),customer.getAddress(),customer.getEmail(),customer.getContactNumber()));
        }
        return customerDtos;
    }

    @Override
    public boolean deleteCustomer(String customerId) throws SQLException {
        return customerDAO.delete(customerId);
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) throws SQLException {
        return customerDAO.update(new Customer(customerDto.getCustomerId(),customerDto.getCustomerName(),customerDto.getAddress(),customerDto.getEmail(),customerDto.getContactNumber()));
    }
}
