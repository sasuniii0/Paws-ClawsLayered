package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.CustomerManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.OrderManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.CustomerDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ProductDAO;
import lk.ijse.gdse.pawsandclawscaremvc.db.DBConnection;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrdersDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManageBOImpl implements OrderManageBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);

    @Override
    public String getNextOrderId() throws SQLException {
        return "";
    }

    @Override
    public String getOrderDateById(String selectedOrderId) throws SQLException {
        return "";
    }

    @Override
    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDto> orderDetailsDtos) throws SQLException {
        return false;
    }

    @Override
    public boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException {
        return false;
    }

    public boolean saveOrder(OrdersDto ordersDto) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false); // 1

            boolean isOrderSaved = SQLUtil.execute(
                    "INSERT INTO Orders (orderId, custId, date) VALUES (?, ?, ?)",
                    ordersDto.getOrderId(),
                    ordersDto.getCustomerId(),
                    ordersDto.getOrderDate()
            );
            if (isOrderSaved) {
                boolean isOrderDetailListSaved = orderDetailsDAO.saveOrderDetailsList(ordersDto.getOrderDetailsDtos());
                if (isOrderDetailListSaved) {
                    connection.commit(); // 2
                    return true;
                }
            }
            connection.rollback(); // 3
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true); // 4
        }
    }

    @Override
    public ArrayList<OrderDetails> getAllOrder() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteOrder(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(OrderDetails dto) throws SQLException {
        return false;
    }
}
