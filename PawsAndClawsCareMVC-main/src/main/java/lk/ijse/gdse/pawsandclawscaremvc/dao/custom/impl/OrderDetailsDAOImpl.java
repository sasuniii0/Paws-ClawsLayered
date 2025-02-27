package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public boolean save(OrderDetails dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO OrderDetails VALUES (?, ?, ?, ?)", dto.getOrderId(), dto.getProId(), dto.getQuantity(), dto.getPrice());
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetails dto) throws SQLException {
        return false;
    }

    @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        return orderDAO.getAllOrderIds();
    }

    @Override
    public Object getOrderDate(String newValue) throws SQLException {
        return orderDAO.getOrderDate(newValue);
    }

   /* @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT orderId FROM Orders");

        ObservableList<String> orderIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            orderIds.add(resultSet.getString(1));
        }
        return orderIds;
    }

    @Override
    public Object getOrderDate(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT date FROM Orders WHERE orderId = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getDate(1);
        }
        return "";
    }*/
}
