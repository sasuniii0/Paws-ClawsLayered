package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.QueryDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    public ArrayList<Payment> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT p.paymentId,p.date,p.amount,p.method,p.resId,p.orderId,c.custId,c.email\n" +
                "    FROM Payment p LEFT JOIN Reservation r ON p.resId = r.resId LEFT JOIN Customer c On r.custId = c.custId");
        ArrayList<Payment> entity = new ArrayList<>();

        while (rst.next()) {
            Payment payment = new Payment(
                    rst.getString(1),
                    rst.getDate(2).toLocalDate(),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            entity.add(payment);
        }
        return entity;
    }
    public void displayCustomerDetailsByResId(String newValue) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT c.custId, c.email FROM Customer c\n" +
                "JOIN Reservation r ON c.custId = r.custId\n" +
                "WHERE r.resId = ?", newValue);

        if (rst.next()) {
            rst.getString(1);
            rst.getString(2);
        }
    }
    public void displayCustomerDetailsByOrderId(String newValue) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT c.custId, c.email FROM Customer c JOIN Orders o ON c.custId = o.custId WHERE o.orderId = ?", newValue);
        if (rst.next()) {
            rst.getString(1);
            rst.getString(2);
        }
    }
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Reservation r join ServiceDetail s on r.resId = s.resId\n" +
                "WHERE s.serviced = ? AND r.date = ? AND r.dropOffTime = ?;",date,services,dropOffTime);

        return rst.next();
    }
    public ArrayList<Payment> searchPaymentsByEmail(String searchText) throws SQLException {
        ResultSet rst = SQLUtil.execute("select p.paymentId ,p.date,p.amount,p.method,p.resId,p.orderId,c.custId,c.email\n" +
                "from Customer c Join Orders o on c.custId = o.custId\n" +
                "join Payment p on o.orderId = p.orderId\n" +
                "where c.email = ?", searchText);
        ArrayList<Payment> entity = new ArrayList<>();
        while (rst.next()) {
            Payment payment = new Payment(
                    rst.getString(1),
                    rst.getDate(2).toLocalDate(),
                    rst.getDouble(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            entity.add(payment);
        }
        return entity;
    }
    public ServiceDto findServiceByEmployeeId(String empId) throws SQLException {
        // Using CrudUtil.execute to execute the query and handle parameters
        ResultSet rst = SQLUtil.execute(
                "SELECT s.serviceId FROM Services s " +
                        "JOIN EmployeeServices es ON s.serviceId = es.serviceId " +
                        "WHERE es.empId = ?", empId);

        // Processing the result
        if (rst.next()) {
            return new ServiceDto(
                    rst.getString("serviceId"),
                    null,
                    null,
                    null,
                    null
            );
        }
        return null;
    }
}
