package cl.com.javdev.service;

import cl.com.javdev.dao.PackageDao;
import cl.com.javdev.domain.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService{
    @Autowired
    private PackageDao packageDao;

    @Override
    @Transactional(readOnly = true)
    public List<Packages> listarPackages() {
        return (List<Packages>) packageDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPackages(Packages packages) {
    packageDao.save(packages);
    }

    @Override
    @Transactional
    public void eliminarPackages(Packages packages) {
    packageDao.delete(packages);
    }

    @Override
    @Transactional(readOnly = true)
    public Packages encontrarPackages(Packages packages) {
        return packageDao.findById(packages.getIdPackages()).orElse(null);
    }
}
