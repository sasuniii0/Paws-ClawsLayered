package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.EmployeeDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.EmployeeDto ;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpManageDAOImpl implements EmployeeDAO {
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select empId from Employee order by empId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            return String.format("E%03d", newIndex);
        }
        return "E001";
    }

    public ArrayList<Employee> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Employee");
        ArrayList<Employee> entity = new ArrayList<>();

        while (rst.next()) {
            Employee employee = new Employee(
                    rst.getString("empId"),
                    rst.getString("orderId"),
                    rst.getString("employeeType"),
                    rst.getString("roll"),
                    rst.getString("serviceId"),
                    rst.getString("startTime"),
                    rst.getString("contactNumber"),
                    rst.getString("endTime")
            );
            entity.add(employee);
        }
        return entity;
    }

    public ObservableList<String> getAllServiceIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT serviceId FROM Service");

        ObservableList<String> serviceIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            serviceIds.add(resultSet.getString(1));
        }
        return serviceIds;
        
    }

    public String getServiceDescription(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT description FROM Service WHERE serviceId = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return "";
    }

    public ObservableList<String> getAllOrderIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderId FROM Orders");

        ObservableList<String> orderIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            orderIds.add(resultSet.getString(1));
        }
        return orderIds;
    }

    public Object getOrderDate(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderDate FROM Orders WHERE orderId = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getDate(1);
        }
        return null;
    }

    public boolean save(Employee entity) throws SQLException {;
        SQLUtil.execute(
                "INSERT INTO Employee (empId, roll,contactNumber, serviceId, orderId, employeeType, endTime, startTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getEmpId(),
                entity.getRole(),
                entity.getContactNumber(),
                entity.getServiceId(),
                entity.getOrderId(),
                entity.getEmployeeType(),
                entity.getEndTime(),
                entity.getStartTime()
        );
        return true;
    }

    public boolean update(Employee entity) throws SQLException {
        return SQLUtil.execute(
                "update Employee set employeeType=?, startTime = ?, endTime=?, roll=?, contactNumber=?, serviceId=?, orderId =? where empId =?",
                entity.getEmployeeType(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getRole(),
                entity.getContactNumber(),
                entity.getServiceId(),
                entity.getOrderId(),
                entity.getEmpId()
        );
    }

    public boolean delete(String serviceIdText) throws SQLException {
        return SQLUtil.execute("delete from Service where empId = ?",serviceIdText);
    }

    public ArrayList<Employee> searchEmployeeByRole(String searchText) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT empId, roll, contactNumber, serviceId, orderId,employeeType,startTime, endTime FROM Employee WHERE roll LIKE ?", "%" + searchText + "%");

        ArrayList<Employee> entity = new ArrayList<>();
        while (rst.next()) {
            Employee employee = new Employee(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            entity.add(employee);
        }
        return entity;
    }
}
