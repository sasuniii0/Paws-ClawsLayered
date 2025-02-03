package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDetailsDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDetailsDAOImpl implements ServiceDetailsDAO {

    ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();

    public boolean saveReservationDetailsList(ArrayList<ServiceDetailsDto> serviceDetailsDtos) throws SQLException {

        for (ServiceDetailsDto serviceDetailsDto : serviceDetailsDtos) {
            boolean isReservationSaved = saveReservationDetails(serviceDetailsDto);
            System.out.println("isReservationSaved " + isReservationSaved);

            if (!isReservationSaved) {
                return false;
            }
            boolean isServiceUpdated = serviceDAOImpl.bookService(serviceDetailsDto);
            System.out.println("isServiceUpdated " + isServiceUpdated);

            if (!isServiceUpdated) {
                return false;
            }
        }
        return true;
    }

    private boolean saveReservationDetails(ServiceDetailsDto serviceDetailsDto) throws SQLException {
        return  SQLUtil.execute(
                "insert into ServiceDetails values (?,?,?)",
                serviceDetailsDto.getServiceId(),
                serviceDetailsDto.getResId(),
                serviceDetailsDto.getDescription()

        );
    }
}


