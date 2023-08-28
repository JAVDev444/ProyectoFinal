package cl.com.javdev.dao;

import cl.com.javdev.domain.Driver;
import cl.com.javdev.domain.Packages;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PackageDao extends CrudRepository<Packages, Long> {
}

