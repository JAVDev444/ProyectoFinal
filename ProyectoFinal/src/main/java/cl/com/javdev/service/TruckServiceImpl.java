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
    public void guardarTruck(Trucks trucks) {
    truckDao.save(trucks);
    }

    @Override
    @Transactional
    public void eliminar(Trucks trucks) {
    truckDao.delete(trucks);
    }

    @Override
    @Transactional(readOnly = true)
    public Trucks encontrarTruck(Trucks trucks) {
    return truckDao.findById(trucks.getIdTrucks()).orElse(null);
    }
}
