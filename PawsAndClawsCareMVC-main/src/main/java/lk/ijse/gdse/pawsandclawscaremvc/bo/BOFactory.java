package lk.ijse.gdse.pawsandclawscaremvc.bo;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory= new BOFactory():boFactory;
    }
    public enum BOTypes{
        CUSTOMER,EMPLOYEE,INVENTORY,ORDERS,PAYMENT,PET,PRODUCT,RESERVATION,SERVICE,SUPPLIER
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER -> {
                return new CustomerManageBOImpl();
            }
            case EMPLOYEE -> {
                return new EmpManageBOImpl();
            }
            case INVENTORY -> {
                return new InventoryManageBOImpl();
            }
            case ORDERS -> {
                return new OrderManageBOImpl();
            }
            case PAYMENT -> {
                return new PaymentBOImpl();
            }
            case PET -> {
                return new PetManageBOImpl();
            }
            case PRODUCT -> {
                return new ProductManageBOImpl();
            }
            case SERVICE -> {
                return new ServiceBOImpl();
            }
            case SUPPLIER -> {
                return new SupplierBOImpl();
            }
            case RESERVATION -> {
                return new ReservationBOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
