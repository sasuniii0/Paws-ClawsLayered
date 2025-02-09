package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
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
}
