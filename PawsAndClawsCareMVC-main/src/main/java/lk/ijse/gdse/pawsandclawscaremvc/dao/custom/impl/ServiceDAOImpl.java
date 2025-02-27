package lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ServiceDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDto;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAOImpl implements ServiceDAO {
    public ArrayList<String> getAllItemIds() throws SQLException {
        ResultSet rst = SQLUtil.execute("select serviceId from Service");
        ArrayList<String> serviceId = new ArrayList<>();

        while (rst.next()) {
            serviceId.add(rst.getString(1));
        }
        return serviceId;
    }

    @Override
    public ServiceDto findServiceByEmployeeId(String empId) throws SQLException {
        return null;
    }

    /*public ServiceDto findServiceByEmployeeId(String empId) throws SQLException {
        // Using CrudUtil.execute to execute the query and handle parameters
        ResultSet rst = SQLUtil.execute(
                "SELECT s.serviceId FROM Services s " +
                        "JOIN EmployeeServices es ON s.serviceId = es.serviceId " +
                        "WHERE es.empId = ?", empId);

        // Processing the result
        if (rst.next()) {
            return new ServiceDto(
                    rst.getString("serviceId"),
                    null,
                    null,
                    null,
                    null
            );
        }
        return null;
    }*/



    public String getServiceDescription(String newValue) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT description FROM Service WHERE serviced = ?", newValue);

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return "";
    }
    public String getSelectedServicePrice(String selectedService) throws SQLException {
        ResultSet rst = SQLUtil.execute("select price from Service where serviceId = ?",selectedService);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    public ArrayList<Service> getAll() throws SQLException {
        ResultSet rst = SQLUtil.execute("select * from Service");
        ArrayList<Service> services = new ArrayList<>();
        while (rst.next()) {
            Service service = new Service(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getTime(3),
                    rst.getDouble(4),
                    rst.getString(5)
            );
            services.add(service);
        }
        return services;
    }


    public String getNextId() throws SQLException {
        ResultSet rst = SQLUtil.execute("select serviceId from Service order by serviceId desc limit 1");
        if (rst.next()) {
            String lastId = rst.getString(1);
            String subString = lastId.substring(1);
            int i = Integer.parseInt(subString);
            int newIndex = i + 1;
            return String.format("S%03d", newIndex);
        }
        return "S001";
    }

    public boolean save(Service entity) throws SQLException {
        return SQLUtil.execute("insert into Service values(?,?,?,?,?)",
                entity.getServiceId(),
                entity.getDescription(),
                entity.getDuration(),
                entity.getPrice(),
                entity.getAvailability()
        );
    }

    public boolean update(Service entity) throws SQLException {
        return SQLUtil.execute(
                "update Service set availability=?, duration=?, description=?, price=? where serviceId =?",
                entity.getAvailability(),    // Corrected parameter order
                entity.getDuration(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getServiceId()
        );
    }


    public boolean delete(String serviceIdText) throws SQLException {
        return SQLUtil.execute("delete from Service where serviceId = ?", serviceIdText);
    }

    public ArrayList<String> getAllServiceIds() throws SQLException {
        ArrayList<String> serviceIds = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT serviceId FROM Service WHERE availability = 'Available'");

        while (rst.next()) {
            serviceIds.add(rst.getString("serviceId"));
        }
        return serviceIds;
    }

    public double getPricePerHour(String selectedService) throws SQLException {
        ResultSet rst = SQLUtil.execute("select price from Service where serviceId = ?", selectedService);
        if (rst.next()) {
            return rst.getDouble(1);
        }
        return 0;
    }

    public String getDuration(String selectedService) throws SQLException {
        ResultSet rst = SQLUtil.execute("select duration from Service where serviceId = ?", selectedService);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    public boolean bookService(ServiceDetailsDto serviceDetailsDto) throws SQLException {
        String serviceId = serviceDetailsDto.getServiceId();
        String description = serviceDetailsDto.getDescription();
        String resId = serviceDetailsDto.getResId();
        boolean isServiceAvailable = checkServiceAvailability(serviceId, description);

        if (!isServiceAvailable) {
            return false;
        }

        boolean isServiceUpdated = updateServiceAvailability(serviceId);
        System.out.println("isServiceUpdated" + isServiceUpdated);

        if (!isServiceUpdated) {
            return false;
        }

        boolean isServiceDetailsSaved = saveServiceDetails(serviceDetailsDto);
        System.out.println("isServiceDetailsSaved" + isServiceDetailsSaved);

        if (!isServiceDetailsSaved) {
            return false;
        }

        return true;
    }

    @Override
    public boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) {
        return false;
    }

     /*public boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) {
        String insertQuery = "INSERT INTO ServiceDetail (serviceId, description, resId) VALUES (?, ?, ?)";
        try {
            return SQLUtil.execute(insertQuery, serviceDetailsDto.getServiceId(), serviceDetailsDto.getDescription(), serviceDetailsDto.getResId()); // Return true if service details are saved
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/

     public boolean updateServiceAvailability(String serviceId) throws SQLException {
        String updateQuery = "UPDATE Service SET availability = 'Not AVAILABLE' WHERE serviceId = ?";
        try {
            return SQLUtil.execute(updateQuery, serviceId); // If rows are updated, the service is successfully booked
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     public boolean checkServiceAvailability(String serviceId, String description) throws SQLException {
        String query = "SELECT availability FROM Service WHERE serviceId = ?";
        ResultSet resultSet = SQLUtil.execute(query, serviceId);

        if (resultSet.next()) {
            String status = resultSet.getString(1);
            return status != null && status.equals("Available");
        }

        return false; // If no service found or an error occurs, return false
    }

    public String getServiceDescriptionById(String selectedServiceId) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT description FROM Service WHERE serviceId = ?",selectedServiceId);
        while (rst.next()) {
            return rst.getString(1);
        }
        return rst.getString(1);
    }

    public ArrayList<String> getAllServiceIdDesc() throws SQLException {
        ResultSet rst = SQLUtil.execute("select serviceId ,description from Service");
        ArrayList<String> serviceIds = new ArrayList<>();
        while (rst.next()) {
            String serviceId = rst.getString(1);
            String description = rst.getString(2);
            serviceIds.add(serviceId + "-" + description);
        }
        return serviceIds;
    }
}
