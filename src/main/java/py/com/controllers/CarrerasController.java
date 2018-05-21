package py.com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import py.com.entities.Carreras;
import py.com.services.CarrerasService;

@Controller
@RequestMapping("carreras")
public class CarrerasController {
	@Autowired
	CarrerasService carreraServices;
	
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAll(Carreras carreras) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Carreras> list = carreraServices.list();
        
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
}