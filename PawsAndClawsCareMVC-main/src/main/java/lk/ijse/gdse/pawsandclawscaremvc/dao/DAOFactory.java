package lk.ijse.gdse.pawsandclawscaremvc.dao;

import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    private static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory= new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,INVENTORY,ORDER,ORDER_DETAILS,PAYMENT,PET,PRODUCT,RESERVATION,SERVICE,SERVICE_DETAILS,SUPPLIER,USER
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER -> {
                return new CustomerDAOImpl();
            }
            case RESERVATION -> {
                return new ReservationDAOImpl();
            }
            case SUPPLIER -> {
                return new SupManageDAOImpl();
            }
            case SERVICE -> {
                return new ServiceDAOImpl();
            }
            case PRODUCT -> {
                return new ProductManageDAOImpl();
            }
            case PET -> {
                return new PetManageDAOImpl();
            }
            case PAYMENT -> {
                return new PaymentDAOImpl();
            }
            case ORDER_DETAILS -> {
                return new OrderDetailsDAOImpl();
            }
            case INVENTORY -> {
                return new InvenManageDAOImpl();
            }
            case EMPLOYEE -> {
                return new EmpManageDAOImpl();
            }
            case USER -> {
                return new UserDAOImpl();
            }
            case ORDER -> {
                return new OrderManageDAOImpl();
            }
            case SERVICE_DETAILS -> {
                return new ServiceDetailsDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
