package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrdersDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderManageBO extends SuperBO {
    String getNextOrderId() throws SQLException;
    String getOrderDateById(String selectedOrderId) throws SQLException;
    boolean saveOrderDetailsList(ArrayList<OrderDetailsDto> orderDetailsDtos) throws SQLException;
    boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException;
    boolean saveOrder(OrdersDto dto) throws SQLException;
    ArrayList<OrderDetails> getAllOrder() throws SQLException;
    boolean deleteOrder(String customerId) throws SQLException ;
    boolean updateOrder(OrderDetails dto) throws SQLException;

}
