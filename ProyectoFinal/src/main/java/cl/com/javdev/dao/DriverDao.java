package cl.com.javdev.dao;

import cl.com.javdev.domain.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverDao extends CrudRepository<Driver, Long> {
}
