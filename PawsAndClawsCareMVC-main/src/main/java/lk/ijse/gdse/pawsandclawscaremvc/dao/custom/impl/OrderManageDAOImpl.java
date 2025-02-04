package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDAO;
import lk.ijse.gdse.pawsandclawscaremvc.db.DBConnection;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrdersDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManageDAOImpl implements OrderDAO {
    private final OrderDetailsDAOImpl orderDetailsDAOImpl = new OrderDetailsDAOImpl();
    @Override
    public String getNextOrderId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("O%03d", newIdIndex);
        }
        return "O001";
    }

//    public boolean saveOrder(OrdersDto ordersDto) throws SQLException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        try {
//            connection.setAutoCommit(false); // 1
//
//            boolean isOrderSaved = SQLUtil.execute(
//                    "INSERT INTO Orders (orderId, custId, date) VALUES (?, ?, ?)",
//                    ordersDto.getOrderId(),
//                    ordersDto.getCustomerId(),
//                    ordersDto.getOrderDate()
//            );
//            if (isOrderSaved) {
//                boolean isOrderDetailListSaved = orderDetailsDAOImpl.saveOrderDetailsList(ordersDto.getOrderDetailsDtos());
//                if (isOrderDetailListSaved) {
//                    connection.commit(); // 2
//                    return true;
//                }
//            }
//            connection.rollback(); // 3
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            connection.rollback();
//            return false;
//        } finally {
//            connection.setAutoCommit(true); // 4
//        }
//    }

    @Override
    public String getOrderDateById(String selectedOrderId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT date FROM Orders WHERE orderId = ?", selectedOrderId);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean save(Orders dto) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Orders dto) throws SQLException {
        return false;
    }
}
