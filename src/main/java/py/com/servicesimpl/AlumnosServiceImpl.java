package py.com.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.dao.AlumnosDao;
import py.com.entities.Alumnos;
import py.com.services.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	@Autowired
	AlumnosDao alumnoDao;
	
    public boolean saveOrUpdate(Alumnos alumnos) {
        return alumnoDao.saveOrUpdate(alumnos);
    }
    
    public List<Alumnos> list() {
        return alumnoDao.list();
    }
    
    public boolean delete(Alumnos alumnos) {
        return alumnoDao.delete(alumnos);
    }
}