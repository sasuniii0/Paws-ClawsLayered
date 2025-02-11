package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.EmployeeDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpManageBO extends SuperBO {
    ArrayList<String> getAllServiceIds() throws SQLException;
    String getServiceDescriptionById(String newValue) throws SQLException;
    ObservableList<String> getAllOrderIds() throws SQLException;
    Object getOrderDate(String newValue) throws SQLException ;
    ArrayList<Employee> searchEmployeeByRole(String searchText) throws SQLException ;
    boolean saveEmployee(EmployeeDto dto) throws SQLException;
    String getNextEmployeeId() throws SQLException;
    ArrayList<EmployeeDto> getAllEmployee() throws SQLException;
    boolean deleteService(String customerId) throws SQLException ;
    boolean updateEmployee(EmployeeDto dto) throws SQLException;
}
