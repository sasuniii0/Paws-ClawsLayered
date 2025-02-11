package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO  extends CrudDAO<Orders> {
   /* String getNextOrderId() throws SQLException;
    String getOrderDateById(String selectedOrderId) throws SQLException;*/

     ObservableList<String> getAllOrderIds() throws SQLException;
     Object getOrderDate(String newValue) throws SQLException ;

    }
