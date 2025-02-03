package lk.ijse.gdse.pawsandclawscaremvc.dao;

import lk.ijse.gdse.pawsandclawscaremvc.dto.CustomerDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
     boolean save(T dto) throws SQLException;
     String getNextId() throws SQLException;
     ArrayList<T> getAll() throws SQLException;
     boolean delete(String customerId) throws SQLException ;
     boolean update(T dto) throws SQLException;
}
