package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PetDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PetManageBO extends SuperBO {
    ArrayList<PetDto> searchPetsByNameOrId(String searchText) throws SQLException;
    boolean savePet(PetDto dto) throws SQLException;
    String getNextPetId() throws SQLException;
    ArrayList<PetDto> getAllPets() throws SQLException;
    boolean deletePet(String customerId) throws SQLException ;
    boolean updatePet(PetDto dto) throws SQLException;

}
