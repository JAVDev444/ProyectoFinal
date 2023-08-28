package cl.com.javdev.service;

import cl.com.javdev.domain.Trucks;

import java.util.List;

public interface TruckService {
    public List<Trucks> listarTrucks();
    public void guardarTruck(Trucks truck);
    public void eliminar(Trucks truck);
    public Trucks encontrarTruck(Trucks truck);
}

