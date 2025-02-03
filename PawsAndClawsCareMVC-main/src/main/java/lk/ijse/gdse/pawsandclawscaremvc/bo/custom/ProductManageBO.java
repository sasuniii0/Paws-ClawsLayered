package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ProductDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductManageBO extends SuperBO {
    boolean reduceQty(OrderDetailsDto orderDetailsDto) throws SQLException;
    ArrayList<String> getAllProductId() throws SQLException;
    ProductDto findById(String selectedProId) throws SQLException ;
    ArrayList<ProductDto> searchProductsByCatalog(String searchText) throws SQLException ;
    ArrayList<ProductDto> getLowStockProducts() throws SQLException;
    boolean saveProduct(ProductDto dto) throws SQLException;
    String getNextProductId() throws SQLException;
    ArrayList<ProductDto> getAllProducts() throws SQLException;
    boolean deleteItem(String customerId) throws SQLException ;
    boolean updateProduct(ProductDto dto) throws SQLException;

}
