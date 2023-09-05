package cl.com.javdev.service;

import cl.com.javdev.dao.TruckDao;
import cl.com.javdev.domain.Trucks;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService{
    @Autowired
    private TruckDao truckDao;

    @Override
    @Transactional(readOnly = true)
    public List<Trucks> listarTrucks() {

        return (List<Trucks>)truckDao.findAll();
    }

    @Override
    @Transactional
    public void guardarTruck(Trucks truck) {
    truckDao.save(truck);
    }

    @Override
    @Transactional
    public void eliminar(Trucks truck) {
    truckDao.delete(truck);
    }

    @Override
    @Transactional(readOnly = true)
    public Trucks encontrarTruck(Trucks truck) {
    return truckDao.findById(truck.getIdTrucks()).orElse(null);
    }
}
