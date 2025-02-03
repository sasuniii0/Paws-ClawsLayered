package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.InvenManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.InventoryDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.InventoryDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Inventory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryManageBOImpl implements InvenManageBO {
    InventoryDAO inventoryDAO = (InventoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INVENTORY);
    @Override
    public ArrayList<InventoryDto> searchProductsByCatalog(String searchText) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<String> getAllInventoryId() throws SQLException {
        return null;
    }

    @Override
    public InventoryDto findById(String selectedInvenId) throws SQLException {
        return null;
    }

    @Override
    public boolean saveInventory(InventoryDto dto) throws SQLException {
        return inventoryDAO.save(new Inventory(dto.getInventoryId(), dto.getStockUpdate(), dto.getInventoryCategory(), dto.getAvailabilityStatus()));
    }

    @Override
    public String getNextInventoryId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<InventoryDto> getAllInventory() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteItem(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean updateInventory(InventoryDto dto) throws SQLException {
        return false;
    }
}
