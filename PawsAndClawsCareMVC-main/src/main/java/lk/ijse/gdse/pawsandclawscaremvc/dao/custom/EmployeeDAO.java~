package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.EmployeeDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee> {
     ArrayList<Employee> searchEmployeeByRole(String searchText) throws SQLException ;
     String getNextId() throws SQLException ;
     ArrayList<Employee> getAll() throws SQLException;
     ArrayList<String> getAvailableEmployee() throws SQLException;
     boolean save(Employee entity) throws SQLException ;
     boolean update(Employee entity) throws SQLException;
     boolean delete(String serviceIdText) throws SQLException ;
    }
