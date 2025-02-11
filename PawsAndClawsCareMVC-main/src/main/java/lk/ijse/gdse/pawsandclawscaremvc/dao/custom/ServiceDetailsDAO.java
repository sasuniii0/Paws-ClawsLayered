package lk.ijse.gdse.pawsandclawscaremvc.dao.custom;

import lk.ijse.gdse.pawsandclawscaremvc.dao.CrudDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ServiceDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.ServiceDetails;

public interface ServiceDetailsDAO  extends CrudDAO<ServiceDetails> {
     boolean saveServiceDetails(ServiceDetailsDto serviceDetailsDto) ;
    }
