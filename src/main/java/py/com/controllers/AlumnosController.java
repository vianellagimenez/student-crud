package py.com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import py.com.services.AlumnosService; 
import py.com.entities.Alumnos;
import py.com.entities.Carreras;

@Controller
@RequestMapping("alumnos")
public class AlumnosController { 
    @Autowired
    AlumnosService alumnoServices;
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView view = new ModelAndView("alumnos");
        return view;
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody Map<String, Object> getSaved(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        
        Carreras carreras = new Carreras();
        carreras.setId(Integer.parseInt(request.getParameter("carreras_id")));
        
        Alumnos alumnos = new Alumnos();
        
        if (request.getParameter("id") != "") {
        	alumnos.setId(Integer.parseInt(request.getParameter("id")));
		}
        
        alumnos.setApellido(request.getParameter("apellido"));
        alumnos.setCarreras_id(carreras);
        alumnos.setNombre(request.getParameter("nombre"));
        alumnos.setNro_documento(request.getParameter("nro_documento"));
        
        if (alumnoServices.saveOrUpdate(alumnos)) {
            map.put("status", "200");
        	map.put("message", "Los datos del alumno han sido guardados correctamente");
        }
        
        return map;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAll(Alumnos alumnos) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Alumnos> list = alumnoServices.list();
        
        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");
        }
 
        return map;
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(Alumnos alumnos) {
        Map<String, Object> map = new HashMap<String, Object>();
        
        if (alumnoServices.delete(alumnos)) {
            map.put("status", "200");
            map.put("message", "Los datos del alumno han sido eliminados correctamente");
        }
        
        return map;
    }
}