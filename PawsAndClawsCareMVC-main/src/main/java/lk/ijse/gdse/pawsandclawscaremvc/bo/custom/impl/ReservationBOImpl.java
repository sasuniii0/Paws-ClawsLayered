package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.CustomerManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ReservationBO;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ServiceBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.CustomerDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ReservationDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.db.DBConnection;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ReservationDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Reservation;
import lk.ijse.gdse.pawsandclawscaremvc.entity.ServiceDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    ServiceDetailsDAO serviceDetailsDAO = (ServiceDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE_DETAILS);
    ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
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
        return (ObservableList<String>) customerDAO.getAllCustomerIds();
    }

    @Override
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        return reservationDAO.checkServiceAvailability(services,date,dropOffTime);
    }

    @Override
    public ArrayList<String> getAvailableEmployee() throws SQLException {
        return reservationDAO.getAvailableEmployee();
    }

    @Override
    public String getSelectedServicePrice(String selectedService) throws SQLException {
        return reservationDAO.getSelectedServicePrice(selectedService);
    }

    @Override
    public String getNextReservationId() throws SQLException {
        return reservationDAO.getNextId();
    }

    @Override
    public ArrayList<ServiceDetailsDto> getAllReservation() throws SQLException {
        ArrayList<ServiceDetails> all = serviceDetailsDAO.getAll();
        ArrayList<ServiceDetailsDto> serviceDetailsDtos = new ArrayList<>();
        for (ServiceDetails serviceDetails : all) {
            serviceDetailsDtos.add(new ServiceDetailsDto(serviceDetails.getServiceId(),serviceDetails.getDescription(),serviceDetails.getResId()));
        }
        return serviceDetailsDtos;
    }

    @Override
    public boolean deleteReservation(String customerId) throws SQLException {
        return reservationDAO.delete(customerId);
    }

    @Override
    public boolean updateReservation(ReservationDto dto) throws SQLException {
        return reservationDAO.update(new Reservation(dto.getResId(),dto.getDropOffTime(),dto.getCustId(),dto.getDate()));
    }
}
