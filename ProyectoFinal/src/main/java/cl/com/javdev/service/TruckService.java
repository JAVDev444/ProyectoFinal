package cl.com.javdev.service;

import cl.com.javdev.domain.Trucks;

import java.util.List;

public interface TruckService {
    public List<Trucks> listarTrucks();
    public void guardarTruck(Trucks trucks);
    public void eliminar(Trucks trucks);
    public Trucks encontrarTruck(Trucks trucks);
}

