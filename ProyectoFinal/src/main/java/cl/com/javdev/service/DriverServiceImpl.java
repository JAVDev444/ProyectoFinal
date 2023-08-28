package cl.com.javdev.service;

import cl.com.javdev.dao.DriverDao;
import cl.com.javdev.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverDao driverDao;

    @Override
    @Transactional(readOnly = true)
    public List<Driver> listarDrivers() {
        return (List<Driver>) driverDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Driver driver) {
        driverDao.save(driver);
    }

    @Override
    @Transactional
    public void eliminar(Driver driver) {
        driverDao.delete(driver);
    }

    @Override
    @Transactional(readOnly = true)
    public Driver encontrarDriver(Driver driver) {
    return driverDao.findById(driver.getIdDrivers()).orElse(null);
    }
}
