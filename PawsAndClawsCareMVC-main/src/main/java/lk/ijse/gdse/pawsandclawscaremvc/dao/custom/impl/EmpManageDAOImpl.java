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
                    rst.getString("empType"),
                    rst.getString("role"),
                    rst.getString("serviced"),
                    rst.getString("startTime"),
                    rst.getString("contactNumber"),
                    rst.getString("endTime")
            );
            entity.add(employee);
        }
        return entity;
    }

    public ArrayList<String> getAvailableEmployee() throws SQLException {
        ArrayList<String> availableEmployees = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(
                "select empId,role from Employee"
        );
        while (rst.next()) {
            String empId = rst.getString(1);
            String roll = rst.getString(2);
            availableEmployees.add(empId + " " + roll);
        }
        return availableEmployees;

    }

    /*public ObservableList<String> getAllServiceIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT serviced FROM Service");

        ObservableList<String> serviceIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            serviceIds.add(resultSet.getString(1));
        }
        return serviceIds;
        
    }*/

    /*public String getServiceDescription(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT description FROM Service WHERE serviced = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return "";
    }*/

    /*public ObservableList<String> getAllOrderIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderId FROM Orders");

        ObservableList<String> orderIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            orderIds.add(resultSet.getString(1));
        }
        return orderIds;
    }*/

    /*public Object getOrderDate(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderDate FROM Orders WHERE orderId = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getDate(1);
        }
        return "";
    }*/

    public boolean save(Employee entity) throws SQLException {;
        SQLUtil.execute(
                "INSERT INTO Employee (empId, role,contactNumber, serviced, orderId, empType, endTime, startTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
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
                "update Employee set empType=?, startTime = ?, endTime=?, role=?, contactNumber=?, serviced=?, orderId =? where empId =?",
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
        return SQLUtil.execute("delete from Employee where empId = ?",serviceIdText);
    }

    public ArrayList<Employee> searchEmployeeByRole(String searchText) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT empId, role, contactNumber, serviced, orderId,empType,startTime, endTime FROM Employee WHERE role LIKE ?", "%" + searchText + "%");

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
