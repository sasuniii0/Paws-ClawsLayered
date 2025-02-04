package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    boolean searchUser(String email, String password);
    boolean updateUser(String selectedEmail, String password);
    boolean save(UserDto dto) throws SQLException;
    String getNextId() throws SQLException;
    ArrayList<UserDto> getAll() throws SQLException;
    boolean delete(String customerId) throws SQLException ;
    boolean update(UserDto dto) throws SQLException;

}
