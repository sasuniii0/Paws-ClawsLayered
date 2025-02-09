package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.SupplierDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.SupplierDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupManageDAOImpl implements SupplierDAO {
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select supId from Supplier order by supId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(3);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("SUP%03d", newIdIndex);
        }
        return "SUP001";
    }

    public ArrayList<Supplier> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Supplier");
        ArrayList<Supplier> entity = new ArrayList<>();

        while (rst.next()) {
            Supplier supplier = new Supplier(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            entity.add(supplier);
        }
        return entity;
    }

    public boolean save(Supplier entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Supplier VALUES (?, ?, ?)",
                entity.getSupId(),
                entity.getName(),
                entity.getContactNumber());
    }


    public boolean update(Supplier entity) throws SQLException {
        return SQLUtil.execute("UPDATE Supplier SET name = ?, contactNumber = ?  WHERE supId = ?",
                entity.getName(),
                entity.getContactNumber(),
                entity.getSupId());
    }


    public boolean delete(String supId) throws SQLException {
        return SQLUtil.execute("DELETE FROM Supplier WHERE supId = ?", supId);
    }


    public ArrayList<SupplierDto> searchSuppliersByNameOrId(String searchText) throws SQLException {
        ArrayList<SupplierDto> suppliers = new ArrayList<>();
        ResultSet rs = SQLUtil.execute("SELECT * FROM Supplier WHERE supId LIKE ? OR name LIKE ?",
                "%" + searchText + "%", "%" + searchText + "%");

        while (rs.next()) {
            suppliers.add(new SupplierDto(
                    rs.getString("supId"),
                    rs.getString("name"),
                    rs.getString("contactNumber")
            ));
        }
        return suppliers;
    }

}
