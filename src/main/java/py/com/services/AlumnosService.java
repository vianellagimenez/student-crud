package py.com.services;

import java.util.List;
import py.com.entities.Alumnos;

public interface AlumnosService {
	public boolean saveOrUpdate(Alumnos alumnos);
    public List<Alumnos> list();
    public boolean delete(Alumnos alumnos);
}