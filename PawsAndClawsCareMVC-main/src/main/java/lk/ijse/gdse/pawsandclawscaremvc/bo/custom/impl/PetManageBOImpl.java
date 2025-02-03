package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.PetManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.PetDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PetDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Pet;

import java.sql.SQLException;
import java.util.ArrayList;

public class PetManageBOImpl implements PetManageBO {
    PetDAO petDAO = (PetDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PET);

    @Override
    public ArrayList<PetDto> searchPetsByNameOrId(String searchText) throws SQLException {
        return null;
    }

    @Override
    public boolean savePet(PetDto dto) throws SQLException {
        return petDAO.save(new Pet(dto.getPetId(), dto.getName(), dto.getBreed()));
    }

    @Override
    public String getNextPetId() throws SQLException {
        return petDAO.getNextId();
    }

    @Override
    public ArrayList<PetDto> getAllPets() throws SQLException {
        ArrayList<Pet> pets = petDAO.getAll();
        ArrayList<PetDto> petDtos = new ArrayList<>();
        for (Pet pet : pets){
            pets.add(new Pet(pet.getPetId(),pet.getName(),pet.getBreed()));
        }
        return petDtos;
    }

    @Override
    public boolean deletePet(String customerId) throws SQLException {
        return petDAO.delete(customerId);
    }

    @Override
    public boolean updatePet(PetDto dto) throws SQLException {
        return petDAO.update(new Pet(dto.getPetId(), dto.getName(),dto.getBreed()));
    }
}
