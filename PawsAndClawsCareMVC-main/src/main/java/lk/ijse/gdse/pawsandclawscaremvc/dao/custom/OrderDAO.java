package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO  extends CrudDAO<Orders> {
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
    ObservableList<String> getAllOrderIds() throws SQLException;

    Object getOrderDate(String newValue) throws SQLException;
   /* String getNextOrderId() throws SQLException;
    String getOrderDateById(String selectedOrderId) throws SQLException;*/

}
