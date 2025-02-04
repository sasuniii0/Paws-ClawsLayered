package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.UserBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {
    @Override
    public boolean searchUser(String email, String password) {
        return false;
    }

    @Override
    public boolean updateUser(String selectedEmail, String password) {
        return false;
    }

    @Override
    public boolean save(UserDto dto) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<UserDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException {
        return false;
    }
}
