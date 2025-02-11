package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.entity.OrderDetails;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails> {
   /* boolean saveOrderDetailsList(ArrayList<OrderDetailsDto> orderDetailsDtos) throws SQLException;

    boolean saveOrderDetail(OrderDetailsDto orderDetailsDto) throws SQLException;*/

     ObservableList<String> getAllOrderIds() throws SQLException ;
     Object getOrderDate(String newValue) throws SQLException ;

}
