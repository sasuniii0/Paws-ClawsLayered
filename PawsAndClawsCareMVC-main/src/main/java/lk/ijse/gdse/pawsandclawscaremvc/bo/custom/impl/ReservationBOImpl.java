package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ReservationBO;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ServiceBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ReservationDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.db.DBConnection;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ReservationDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.ServiceDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    ServiceDetailsDAO serviceDetailsDAO = (ServiceDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE_DETAILS);
    ServiceBO serviceBO = (ServiceBO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    public boolean saveReservation(ReservationDto reservationDto) throws SQLException {
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
                boolean isServiceDetailsSaved = serviceDetailsDAO.save(new ServiceDetails());
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
    }

    @Override
    public ObservableList<String> getAllCustomerId() throws SQLException {
        return null;
    }

    @Override
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<String> getAvailableEmployee() throws SQLException {
        return null;
    }

    @Override
    public String getSelectedServicePrice(String selectedService) throws SQLException {
        return "";
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<ServiceDetailsDto> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ServiceDetailsDto dto) throws SQLException {
        return false;
    }
}
