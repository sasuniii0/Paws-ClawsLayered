package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.PaymentBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.PaymentDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.PaymentDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public ObservableList<String> getAllOrderIds() throws SQLException {
        return null;
    }

    @Override
    public ObservableList<String> getAllReservationIds() throws SQLException {
        return null;
    }

    @Override
    public void displayCustomerDetailsByResId(String newValue) throws SQLException {

    }

    @Override
    public void displayCustomerDetailsByOrderId(String newValue) throws SQLException {

    }

    @Override
    public ArrayList<PaymentDto> searchPaymentsByEmail(String searchText) throws SQLException {
        return null;
    }

    @Override
    public boolean savePayment(PaymentDto dto) throws SQLException {
        return paymentDAO.save(new Payment(dto.getPaymentId(),dto.getDate(),dto.getAmount(),dto.getMethod(), dto.getResId(), dto.getOrderId(), dto.getCustId(), dto.getEmail()));
    }

    @Override
    public String getNextPaymentId() throws SQLException {
        return paymentDAO.getNextId();
    }

    @Override
    public ArrayList<PaymentDto> getAllPayment() throws SQLException {
        ArrayList<Payment> payments = paymentDAO.getAll();
        ArrayList<PaymentDto> paymentDtos = new ArrayList<>();
        for (Payment payment : payments){
            paymentDtos.add(new PaymentDto(payment.getPaymentId(),payment.getDate(),payment.getAmount(),payment.getMethod(),payment.getResId(),payment.getOrderId(),payment.getCustId(),payment.getEmail()));
        }
        return paymentDtos;
    }

    @Override
    public boolean deletePayment(String customerId) throws SQLException {
        return paymentDAO.delete(customerId);
    }

    @Override
    public boolean updatePayment(PaymentDto dto) throws SQLException {
        return paymentDAO.update(new Payment(dto.getPaymentId(),dto.getDate(),dto.getAmount(),dto.getMethod(), dto.getResId(), dto.getOrderId(), dto.getCustId(), dto.getEmail()));
    }
}
