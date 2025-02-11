package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.ServiceDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDetailsDAOImpl implements ServiceDetailsDAO {
    ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    public boolean saveReservationDetailsList(ArrayList<ServiceDetailsDto> serviceDetailsDtos) throws SQLException {

        for (ServiceDetailsDto serviceDetailsDto : serviceDetailsDtos) {
            boolean isReservationSaved = saveReservationDetails(serviceDetailsDto);
            System.out.println("isReservationSaved " + isReservationSaved);

            if (!isReservationSaved) {
                return false;
            }
            boolean isServiceUpdated = serviceDAO.bookService(serviceDetailsDto);
            System.out.println("isServiceUpdated " + isServiceUpdated);

            if (!isServiceUpdated) {
                return false;
            }
        }
        return true;
    }
    public boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) {
        String insertQuery = "INSERT INTO ServiceDetail (serviceId, description, resId) VALUES (?, ?, ?)";
        try {
            return SQLUtil.execute(insertQuery, serviceDetailsDto.getServiceId(), serviceDetailsDto.getDescription(), serviceDetailsDto.getResId()); // Return true if service details are saved
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean saveReservationDetails(ServiceDetailsDto serviceDetailsDto) throws SQLException {
        return  SQLUtil.execute(
                "insert into ServiceDetails values (?,?,?)",
                serviceDetailsDto.getServiceId(),
                serviceDetailsDto.getResId(),
                serviceDetailsDto.getDescription()

        );
    }

    @Override
    public boolean save(ServiceDetails dto) throws SQLException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException {
        return "";
    }

    @Override
    public ArrayList<ServiceDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String customerId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ServiceDetails dto) throws SQLException {
        return false;
    }
}


