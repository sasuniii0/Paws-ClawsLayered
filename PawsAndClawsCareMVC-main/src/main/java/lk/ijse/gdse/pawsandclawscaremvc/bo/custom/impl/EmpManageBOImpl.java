package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.EmpManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.EmployeeDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.EmployeeDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpManageBOImpl implements EmpManageBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ObservableList<String> getAllServiceIds() throws SQLException {
        return null;
    }

    @Override
    public String getServiceDescription(String newValue) throws SQLException {
        return "";
    }

    @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        return null;
    }

    @Override
    public Object getOrderDate(String newValue) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<EmployeeDto> searchEmployeeByRole(String searchText) throws SQLException {
        return null;
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
