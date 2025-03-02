package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.QueryDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ReservationDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select resId from Reservation order by resId desc limit 1");

        if (rst.next()) {
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIndex = i + 1;
            return String.format("R%03d", newIndex);
        }
        return "R001";
    }

    public ObservableList<String> getAllReservationIds() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT resId FROM Reservation");

        ObservableList<String> serviceIds = FXCollections.observableArrayList();
        while (resultSet.next()) {
            serviceIds.add(resultSet.getString(1));
        }
        return serviceIds;
    }

   /* public ObservableList<String> getAllCustomerId() throws SQLException {
        ResultSet rs = SQLUtil.execute("SELECT custId FROM Customer");

        ObservableList<String> customerIdList = FXCollections.observableArrayList();
        while (rs.next()) {
            customerIdList.add(rs.getString("custId"));
        }
        return customerIdList;
    }*/

    /*public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Reservation r join ServiceDetail s on r.resId = s.resId\n" +
                "WHERE s.serviced = ? AND r.date = ? AND r.dropOffTime = ?;",date,services,dropOffTime);

       return rst.next();
    }*/

    @Override
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<String> getAvailableEmployee() throws SQLException {
        ArrayList<String> availableEmployees = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(
                "select empId,role from Employee"
        );
        while (rst.next()) {
            String empId = rst.getString(1);
            String roll = rst.getString(2);
            availableEmployees.add(empId + " " + roll);
        }
        return availableEmployees;
    }

    /*public ArrayList<String> getAvailableEmployee() throws SQLException {
        ArrayList<String> availableEmployees = new ArrayList<>();
        ResultSet rst = SQLUtil.execute(
                "select empId,role from Employee"
        );
        while (rst.next()) {
            String empId = rst.getString(1);
            String roll = rst.getString(2);
            availableEmployees.add(empId + " " + roll);
        }
        return availableEmployees;

    }*/

    /*public String getSelectedServicePrice(String selectedService) throws SQLException {
        ResultSet rst = SQLUtil.execute("select price from Service where serviceId = ?",selectedService);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }*/

    @Override
    public boolean save(Reservation dto) throws SQLException {
        String sql = "INSERT INTO Reservation (resId, dropOffTime, custId, date) VALUES (?, ?, ?, ?)";
        return SQLUtil.execute(dto.getResId(),dto.getDropOffTime() ,dto.getCustId(),dto.getDate());
    }

   /* @Override
    public String getNextId() throws SQLException {
        return "";
    }*/

    @Override
    public ArrayList<Reservation> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Reservation");
        ArrayList<Reservation> reservations = new ArrayList<>();
        while (rst.next()) {
            reservations.add(new Reservation(rst.getString(1), rst.getTime(2), rst.getString(3), rst.getDate(4)));
        }
        return reservations;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return SQLUtil.execute("DELETE FROM Reservation WHERE resId = ?", customerId);
    }

    @Override
    public boolean update(Reservation dto) throws SQLException {
        return SQLUtil.execute("UPDATE Reservation SET dropOffTime = ?, custId = ?, date = ? WHERE resId = ?", dto.getDropOffTime(), dto.getCustId(), dto.getDate(), dto.getResId());
    }

    /*public boolean saveReservation(ReservationDto reservationDto) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            boolean isReservationSaved = SQLUtil.execute("insert into Reservation (resId,dropOffTime,custId,date) values (?,?,?,?)",
                    reservationDto.getResId(),
                    reservationDto.getDropOffTime(),
                    reservationDto.getCustId(),
                    reservationDto.getDate()
                    );
            if (isReservationSaved) {
                boolean isServiceDetailsSaved = serviceDetailsDAOImpl.saveReservationDetailsList(reservationDto.getServiceDetailsDtos());
                System.out.println("detail table " + isServiceDetailsSaved);

                if (isServiceDetailsSaved) {
                    connection.commit();
                    return true;
                }
            }
            System.out.println("res table " + isReservationSaved);
            connection.rollback();
            return false;
        }catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally{
            connection.setAutoCommit(true);
        }
    }*/
}
