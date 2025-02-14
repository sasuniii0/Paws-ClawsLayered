package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.InventoryDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InvenManageBO extends SuperBO {
     ArrayList<InventoryDto> searchProductsByCatalog(String searchText) throws SQLException;
     ArrayList<String> getAllInventoryId() throws SQLException;
     InventoryDto findById(String selectedInvenId) throws SQLException;
    boolean saveInventory(InventoryDto dto) throws SQLException;
    String getNextInventoryId() throws SQLException;
    ArrayList<InventoryDto> getAllInventory() throws SQLException;
    boolean deleteItem(String customerId) throws SQLException ;
    boolean updateInventory(InventoryDto dto) throws SQLException;
}
