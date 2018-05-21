package py.com.dao;

import java.util.List;
import py.com.entities.Alumnos;

public interface AlumnosDao {
	public boolean saveOrUpdate(Alumnos alumnos); 
    public List<Alumnos> list();
    public boolean delete(Alumnos alumnos);
}