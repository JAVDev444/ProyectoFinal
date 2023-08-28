package cl.com.javdev.dao;

import cl.com.javdev.domain.Trucks;
import org.springframework.data.repository.CrudRepository;

public interface TruckDao extends CrudRepository <Trucks, Long>{

}
