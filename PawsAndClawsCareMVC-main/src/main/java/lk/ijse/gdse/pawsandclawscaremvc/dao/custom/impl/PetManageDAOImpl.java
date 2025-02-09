package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.PetDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PetDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetManageDAOImpl implements PetDAO {
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select petId from Pet order by petId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String substring = lastId.substring(1);
            int i = Integer.parseInt(substring);
            int newIdIndex = i + 1;
            return String.format("P%03d", newIdIndex);
        }
        return "P001";
    }

    public ArrayList<Pet> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Pet");
        ArrayList<Pet> entity = new ArrayList<>();

        while (rst.next()) {
            Pet pets = new Pet(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            entity.add(pets);
        }
        return entity;
    }

    public boolean update(Pet entity) throws SQLException {
        return SQLUtil.execute("UPDATE Pet SET name = ?, breed = ?  WHERE petId = ?",
                entity.getName(),
                entity.getBreed(),
                entity.getPetId());
    }

    public boolean save(Pet entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Pet VALUES (?, ?, ?)",
                entity.getPetId(),
                entity.getName(),
                entity.getBreed());
    }

    public boolean delete(String petId) throws SQLException {
        return SQLUtil.execute("DELETE FROM Pet WHERE petId = ?", petId);
    }

    public ArrayList<PetDto> searchPetsByNameOrId(String searchText) throws SQLException {
        ArrayList<PetDto> pets = new ArrayList<>();
        ResultSet rs = SQLUtil.execute("SELECT * FROM Pet WHERE petId LIKE ? OR name LIKE ?",
                "%" + searchText + "%", "%" + searchText + "%");

        while (rs.next()) {
            pets.add(new PetDto(
                    rs.getString("petId"),
                    rs.getString("name"),
                    rs.getString("breed")
            ));
        }
        return pets;
    }
}
