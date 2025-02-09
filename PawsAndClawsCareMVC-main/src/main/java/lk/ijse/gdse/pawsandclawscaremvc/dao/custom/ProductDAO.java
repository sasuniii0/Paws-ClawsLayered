package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ProductDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO  extends CrudDAO<Product> {
    boolean reduceQty(OrderDetailsDto orderDetailsDto) throws SQLException;
    ArrayList<String> getAllProductId() throws SQLException;
    ProductDto findById(String selectedProId) throws SQLException ;
    ArrayList<ProductDto> searchProductsByCatalog(String searchText) throws SQLException ;
    ArrayList<ProductDto> getLowStockProducts() throws SQLException;
}
