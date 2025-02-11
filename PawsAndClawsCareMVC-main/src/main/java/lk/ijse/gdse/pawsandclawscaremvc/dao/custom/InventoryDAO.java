package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.InventoryDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InventoryDAO extends CrudDAO<Inventory> {
     String getNextId() throws SQLException;
     ArrayList<Inventory> getAll() throws SQLException ;
     boolean save(Inventory entity) throws SQLException ;
     boolean update(Inventory entity) throws SQLException ;
     boolean delete(String invenId) throws SQLException ;
     ArrayList<Inventory> searchProductsByCatalog(String searchText) throws SQLException;
     ArrayList<String> getAllInventoryId() throws SQLException ;
     InventoryDto findById(String selectedInvenId) throws SQLException;

}
