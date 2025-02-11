package lk.ijse.gdse.pawsandclawscaremvc.bo.custom;

import lk.ijse.gdse.pawsandclawscaremvc.bo.SuperBO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceBO extends SuperBO {
    ArrayList<String> getAllItemIds() throws SQLException;
    ServiceDto findServiceByEmployeeId(String empId) throws SQLException;
    ArrayList<String> getAllServiceIds() throws SQLException ;
    double getPricePerHour(String selectedService) throws SQLException ;
    String getDuration(String selectedService) throws SQLException;
    boolean bookService(ServiceDetailsDto serviceDetailsDto) throws SQLException ;
    boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) ;
    boolean updateServiceAvailability(String serviceId) throws SQLException ;
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;

    boolean checkServiceAvailability(String serviceId, String description) throws SQLException ;
    String getServiceDescriptionById(String selectedServiceId) throws SQLException ;
    ArrayList<String> getAllServiceIdDesc() throws SQLException ;
    boolean saveService(ServiceDto dto) throws SQLException;
    String getNextServiceId() throws SQLException;
    ArrayList<ServiceDto> getAllServices() throws SQLException;
    boolean deleteService(String customerId) throws SQLException ;
    boolean updateService(ServiceDto dto) throws SQLException;

}
