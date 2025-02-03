package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Pet;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PetDAO  extends CrudDAO<Pet> {
     ArrayList<Pet> searchPetsByNameOrId(String searchText) throws SQLException ;
}
