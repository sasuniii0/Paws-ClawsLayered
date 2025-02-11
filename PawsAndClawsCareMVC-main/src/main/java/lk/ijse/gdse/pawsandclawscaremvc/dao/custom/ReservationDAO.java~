package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO  extends CrudDAO<Reservation> {
     boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;
     ArrayList<String> getAvailableEmployee() throws SQLException;
     double getSelectedServicePrice(String selectedService) throws SQLException;
}
