package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.SupplierDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    ArrayList<SupplierDto> searchSuppliersByNameOrId(String searchText) throws SQLException;
    boolean saveSupplier(SupplierDto dto) throws SQLException;
    String getNextSupId() throws SQLException;
    ArrayList<SupplierDto> getAllSuppliers() throws SQLException;
    boolean deleteSupplier(String customerId) throws SQLException ;
    boolean updateSupplier(SupplierDto dto) throws SQLException;

}
