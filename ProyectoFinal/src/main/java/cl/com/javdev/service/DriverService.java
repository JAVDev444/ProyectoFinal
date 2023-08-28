package cl.com.javdev.service;

import cl.com.javdev.domain.Driver;

import java.util.List;

public interface DriverService {
    public List<Driver> listarDrivers();
    public void guardar(Driver driver);
    public void eliminar(Driver driver);
    public Driver encontrarDriver(Driver driver);
}
