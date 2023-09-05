package cl.com.javdev.service;

import cl.com.javdev.dao.PackProductDao;
import cl.com.javdev.domain.Package_Products;
import cl.com.javdev.domain.Packages;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class PackProductServiceImpl implements PackProductService{
    @Autowired
    private PackProductDao packProductDao;


    public Package_Products addToPackage(Packages packages, Package_Products package_products) {

        package_products.setPackages(packages);

        return packProductDao.save(package_products);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Package_Products> listarPackProduct() {
        return (List<Package_Products>) packProductDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPackProduct(Package_Products packProduct) {
    packProductDao.save(packProduct);
    }

    @Override
    @Transactional
    public void eliminarPackProduct(Package_Products packProduct) {
    packProductDao.delete(packProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public Package_Products encontrarPackProduct(Package_Products packProduct) {
        return packProductDao.findById(packProduct.getIdProducts()).orElse(null);
    }
}
