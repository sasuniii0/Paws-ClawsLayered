package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.EmpManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.EmployeeDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.EmployeeDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpManageBOImpl implements EmpManageBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
    @Override
    public ArrayList<String> getAllServiceIds() throws SQLException {
        return serviceDAO.getAllServiceIds();
    }

    @Override
    public String getServiceDescriptionById(String newValue) throws SQLException {
        return serviceDAO.getServiceDescriptionById(newValue);
    }

    @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        return orderDetailsDAO.getAllOrderIds();
    }

    @Override
    public Object getOrderDate(String newValue) throws SQLException {
        return orderDetailsDAO.getOrderDate(newValue);
    }

    @Override
    public ArrayList<Employee> searchEmployeeByRole(String searchText) throws SQLException {
        return employeeDAO.searchEmployeeByRole(searchText);
    }

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.save(new Employee(dto.getEmpId(),dto.getStartTime(),dto.getEndTime(), dto.getRole(), dto.getContactNumber(), dto.getServiceId(), dto.getOrderId(), dto.getEmployeeType()));
    }

    @Override
    public String getNextEmployeeId() throws SQLException {
        return employeeDAO.getNextId();
    }

    @Override
    public ArrayList<EmployeeDto> getAllEmployee() throws SQLException {
        ArrayList<Employee> employee = employeeDAO.getAll();
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employees : employee){
            employeeDtos.add(new EmployeeDto(employees.getEmpId(),employees.getStartTime(),employees.getEndTime(),employees.getRole(),employees.getContactNumber(),employees.getServiceId(),employees.getOrderId(),employees.getEmployeeType()));
        }
        return employeeDtos;
    }

    @Override
    public boolean deleteService(String customerId) throws SQLException {
        return employeeDAO.delete(customerId);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.update(new Employee(dto.getEmpId(),dto.getStartTime(),dto.getEndTime(), dto.getRole(), dto.getContactNumber(), dto.getServiceId(), dto.getOrderId(), dto.getEmployeeType()));
    }
}
