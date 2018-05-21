package py.com.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.dao.CarrerasDao;
import py.com.entities.Carreras;
import py.com.services.CarrerasService;

@Service
public class CarrerasServiceImpl implements CarrerasService {
	@Autowired
	CarrerasDao carreraDao;
	
	public List<Carreras> list() {
        return carreraDao.list();
    }
}