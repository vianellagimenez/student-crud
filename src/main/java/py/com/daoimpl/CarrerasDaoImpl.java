package py.com.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import py.com.dao.CarrerasDao;
import py.com.entities.Carreras;

@Repository
@Transactional
public class CarrerasDaoImpl implements CarrerasDao {
	@Autowired
    SessionFactory session;
	
	public List<Carreras> list() {
        return session.getCurrentSession().createQuery("FROM Carreras ORDER BY descripcion").list();
    }
}