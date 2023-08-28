package cl.com.javdev.service;

import cl.com.javdev.domain.Packages;

import java.util.List;

public interface PackageService {
    public List<Packages> listarPackages();

    public void guardarPackages(Packages packages);
    public void eliminarPackages(Packages packages);
    public Packages encontrarPackages(Packages packages);
}

