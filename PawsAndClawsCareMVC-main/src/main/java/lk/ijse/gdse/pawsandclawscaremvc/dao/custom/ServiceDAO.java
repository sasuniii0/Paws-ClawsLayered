package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceDAO  extends CrudDAO<Service> {
    ArrayList<String> getAllItemIds() throws SQLException;
    ServiceDto findServiceByEmployeeId(String empId) throws SQLException;
    ArrayList<String> getAllServiceIds() throws SQLException ;
    double getPricePerHour(String selectedService) throws SQLException ;
    String getDuration(String selectedService) throws SQLException;
    boolean bookService(ServiceDetailsDto serviceDetailsDto) throws SQLException ;
    boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) ;
    boolean updateServiceAvailability(String serviceId) throws SQLException ;
    boolean checkServiceAvailability(String serviceId, String description) throws SQLException ;
    String getServiceDescriptionById(String selectedServiceId) throws SQLException ;
    ArrayList<String> getAllServiceIdDesc() throws SQLException ;
    String getSelectedServicePrice(String selectedService) throws SQLException;
}
