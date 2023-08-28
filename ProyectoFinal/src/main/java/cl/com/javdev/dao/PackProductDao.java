package cl.com.javdev.dao;

import cl.com.javdev.domain.Package_Products;
import org.springframework.data.repository.CrudRepository;

public interface PackProductDao extends CrudRepository<Package_Products, Long> {
}
