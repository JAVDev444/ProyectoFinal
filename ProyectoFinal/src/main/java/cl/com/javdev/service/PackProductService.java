package cl.com.javdev.service;

import cl.com.javdev.domain.Package_Products;
import cl.com.javdev.domain.Packages;

import java.util.List;

public interface PackProductService {
    public List<Package_Products> listarPackProduct();
    public void guardarPackProduct(Package_Products packProduct);
    public void eliminarPackProduct(Package_Products packProduct);
    public Package_Products encontrarPackProduct(Package_Products packProduct);
}
