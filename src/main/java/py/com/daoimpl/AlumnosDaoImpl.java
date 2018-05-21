package py.com.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import py.com.dao.AlumnosDao;
import py.com.entities.Alumnos;

@Repository
@Transactional
public class AlumnosDaoImpl implements AlumnosDao {
	@Autowired
    SessionFactory session;
	
    public boolean saveOrUpdate(Alumnos alumnos) {
        session.getCurrentSession().saveOrUpdate(alumnos);
        return true;
    }
    
    public List<Alumnos> list() {
        return session.getCurrentSession().createQuery("from Alumnos").list();
    }
    
    public boolean delete(Alumnos alumnos) {
        try {
            session.getCurrentSession().delete(alumnos);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }
}