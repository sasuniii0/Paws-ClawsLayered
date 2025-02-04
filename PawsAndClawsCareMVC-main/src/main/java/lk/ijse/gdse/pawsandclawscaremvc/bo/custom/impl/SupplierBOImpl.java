package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.SupplierBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.SupplierDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.SupplierDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public ArrayList<SupplierDto> searchSuppliersByNameOrId(String searchText) throws SQLException {
        return null;
    }

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.save(new Supplier(dto.getSupId(), dto.getName(), dto.getContactNumber()));
    }

    @Override
    public String getNextSupId() throws SQLException {
        return supplierDAO.getNextId();
    }

    @Override
    public ArrayList<SupplierDto> getAllSuppliers() throws SQLException {
        ArrayList<Supplier> suppliers = supplierDAO.getAll();
        ArrayList<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier:suppliers){
            supplierDtos.add(new SupplierDto(supplier.getSupId(),supplier.getName(),supplier.getContactNumber()));
        }
        return supplierDtos;
    }

    @Override
    public boolean deleteSupplier(String customerId) throws SQLException {
        return supplierDAO.delete(customerId);
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.update(new Supplier(dto.getSupId(), dto.getName(), dto.getContactNumber()));
    }
}
