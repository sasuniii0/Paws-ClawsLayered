package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.PaymentDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.QueryDAO;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    /*public ObservableList<String> getAllOrderIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderId FROM Orders");

        ObservableList<String> orderIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            orderIds.add(resultSet.getString(1));
        }
        return orderIds;
    }*/

   /* public ObservableList<String> getAllReservationIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT resId FROM Reservation");

        ObservableList<String> serviceIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            serviceIds.add(resultSet.getString(1));
        }
        return serviceIds;
    }*/

    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select paymentId from Payment order by paymentId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String subString = lastId.substring(3);
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            return String.format("PAY%03d", newIndex);
        }
        return "PAY001";
    }


    public ArrayList<Payment> getAll() throws SQLException {
       return queryDAO.getAll();
    }

    public boolean save(Payment entity) throws SQLException {
        SQLUtil.execute(
                "INSERT INTO Payment (paymentId, date,amount,method,resId,orderId) VALUES (?, ?, ?, ?, ?, ?)",
                entity.getPaymentId(),
                entity.getDate(),
                entity.getAmount(),
                entity.getMethod(),
                entity.getResId(),
                entity.getOrderId()

        );
        return true;
    }

    /*public void displayCustomerDetailsByResId(String newValue) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT c.custId, c.email FROM Customer c\n" +
                "JOIN Reservation r ON c.custId = r.custId\n" +
                "WHERE r.resId = ?", newValue);

        if (rst.next()) {
            rst.getString(1);
            rst.getString(2);
        }
    }*/

   /* public void displayCustomerDetailsByOrderId(String newValue) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT c.custId, c.email FROM Customer c JOIN Orders o ON c.custId = o.custId WHERE o.orderId = ?", newValue);
        if (rst.next()) {
            rst.getString(1);
            rst.getString(2);
        }
    }*/

    public boolean update(Payment entity) throws SQLException {
        return SQLUtil.execute(
                "update Payment set date=?, amount=?, method=?, resId=?, orderId=? where paymentId =?",
                entity.getDate(),
                entity.getAmount(),
                entity.getMethod(),
                entity.getResId(),
                entity.getOrderId(),
                entity.getPaymentId()
        );
    }

    public boolean delete(String paymentIdTxt) throws SQLException {
        return SQLUtil.execute("delete from Payment where paymentId = ?",paymentIdTxt);
    }

    /*public ArrayList<Payment> searchPaymentsByEmail(String searchText) throws SQLException {
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
    }*/
}
