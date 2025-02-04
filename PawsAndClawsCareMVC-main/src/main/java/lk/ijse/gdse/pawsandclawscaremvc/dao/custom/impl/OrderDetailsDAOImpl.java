package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetailsList(ArrayList<OrderDetailsDto> orderDetailsDtos) throws SQLException {
        for (OrderDetailsDto orderDetailsDto : orderDetailsDtos) {
            boolean isOrderDetailsSaved = saveOrderDetail(orderDetailsDto);
            if (!isOrderDetailsSaved) {
                return false;
            }

            boolean isItemUpdated = ProductManageDAOImpl.reduceQty(orderDetailsDto);
            if (!isItemUpdated) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException {
        return SQLUtil.execute(
                "INSERT INTO OrderDetails VALUES (?, ?, ?, ?)",
                orderDetailsDto.getOrderId(),
                orderDetailsDto.getProId(),
                orderDetailsDto.getQuantity(),
                orderDetailsDto.getPrice()
        );
    }

    @Override
    public boolean save(OrderDetails dto) throws SQLException {
        return false;
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
