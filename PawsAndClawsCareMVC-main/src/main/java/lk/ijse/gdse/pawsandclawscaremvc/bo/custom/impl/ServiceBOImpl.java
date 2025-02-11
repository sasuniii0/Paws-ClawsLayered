package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ServiceBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Service;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceBOImpl implements ServiceBO {
    ServiceDAO serviceDAO = (ServiceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE);
    @Override
    public ArrayList<String> getAllItemIds() throws SQLException {
        return null;
    }

    @Override
    public ServiceDto findServiceByEmployeeId(String empId) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<String> getAllServiceIds() throws SQLException {
        return null;
    }

    @Override
    public double getPricePerHour(String selectedService) throws SQLException {
        return 0;
    }

    @Override
    public String getDuration(String selectedService) throws SQLException {
        return "";
    }

    @Override
    public boolean bookService(ServiceDetailsDto serviceDetailsDto) throws SQLException {
        return false;
    }

    @Override
    public boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) {
        return false;
    }

    @Override
    public boolean updateServiceAvailability(String serviceId) throws SQLException {
        return false;
    }

    @Override
    public boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException {
        return false;
    }

    @Override
    public boolean checkServiceAvailability(String serviceId, String description) throws SQLException {
        return serviceDAO.checkServiceAvailability(serviceId,description);
    }

    @Override
    public String getServiceDescriptionById(String selectedServiceId) throws SQLException {
        return serviceDAO.getServiceDescriptionById(selectedServiceId);
    }

    @Override
    public ArrayList<String> getAllServiceIdDesc() throws SQLException {
        return serviceDAO.getAllServiceIdDesc();
    }

    @Override
    public boolean saveService(ServiceDto dto) throws SQLException {
        return serviceDAO.save(new Service(dto.getServiceId(), dto.getDescription(), dto.getDuration(), dto.getPrice(), dto.getAvailability()));
    }

    @Override
    public String getNextServiceId() throws SQLException {
        return serviceDAO.getNextId();
    }

    @Override
    public ArrayList<ServiceDto> getAllServices() throws SQLException {
        ArrayList<Service> services= serviceDAO.getAll();
        ArrayList<ServiceDto> serviceDtos = new ArrayList<>();
        for (Service service : services){
            serviceDtos.add(new ServiceDto(service.getServiceId(),service.getDescription(),service.getDuration(),service.getPrice(),service.getAvailability()));
        }
        return serviceDtos;
    }

    @Override
    public boolean deleteService(String customerId) throws SQLException {
        return serviceDAO.delete(customerId);
    }

    @Override
    public boolean updateService(ServiceDto dto) throws SQLException {
        return serviceDAO.update(new Service(dto.getServiceId(), dto.getDescription(), dto.getDuration(), dto.getPrice(), dto.getAvailability()));
    }
}
