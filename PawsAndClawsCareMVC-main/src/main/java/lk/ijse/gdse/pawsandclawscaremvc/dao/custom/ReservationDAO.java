package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.SQLUtil;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationDAO  extends CrudDAO<Reservation> {
     boolean checkServiceAvailability(String services, String date, String dropOffTime) throws SQLException;
     ArrayList<String> getAvailableEmployee() throws SQLException;
     String getSelectedServicePrice(String selectedService) throws SQLException;
}
