/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.CarreraDAOImpl;
import DAO.PreguntaDAOImpl;
import Modelo.Pregunta;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rae
 */
@Controller
public class PreguntaController implements BeanFactoryAware {
    
    private PreguntaDAOImpl preguntaDAOImpl;
    private CarreraDAOImpl carreraDAOImpl;
    
    @RequestMapping(value = "/publicarPregunta")
    public ModelAndView publicarPregunta(HttpSession sesion, ModelMap model){
        model.addAttribute("login", sesion.getAttribute("login"));
        model.addAttribute("command",new Pregunta());
        model.addAttribute("carreras", carreraDAOImpl.getCarreras());        
        return new ModelAndView("publicarPregunta",model);
    }
    
    @RequestMapping(value="/guardarPregunta", method = RequestMethod.POST )
    public String guardarPregunta(@ModelAttribute Pregunta pregunta, HttpServletRequest request ,HttpSession sesion){
        
        pregunta.setFecha(new Date());
        pregunta.setDesactivada(0);
        pregunta.setReportada(0);
        pregunta.setRevisada(0);
        pregunta.setId_respuesta_satisfactoria(null);
        
        preguntaDAOImpl.create(pregunta,(String)sesion.getAttribute("login"), Integer.parseInt(request.getParameter("id_carrera")));
        
        return "redirect:mostrarPregunta/" + pregunta.getId_pregunta();
    }
    
    
    @RequestMapping(value="/mostrarPregunta/{id}")
    public String mostrarPregunta(@PathVariable("id") int pregunta_id, ModelMap model){
    
        Pregunta pregunta = preguntaDAOImpl.get(pregunta_id);
        
        model.addAttribute("titulo", pregunta.getTitulo());
        model.addAttribute("descripcion", pregunta.getDescripcion());
        
        return "mostrarPregunta";
    }
    
    @RequestMapping(value="/mostrarPreguntas/{index}", method = RequestMethod.GET )
    public String mostrarPreguntas(@PathVariable("index") int index, ModelMap model){
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("preguntas", preguntaDAOImpl.get(index*5, 5));
        model.addAttribute("sdf",sdf);
        
        return "home_pregunta";
    }
    
    @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
        preguntaDAOImpl = (PreguntaDAOImpl) context.getBean("preguntaDAOImpl");
        carreraDAOImpl = (CarreraDAOImpl) context.getBean("carreraDAOImpl");
    }

    // Metodo para pruebas, borrar para codigo de produccion
    private void genera_preguntas(int numero_preguntas){
        
        Pregunta pregunta;
        for (int i = 1; i <= numero_preguntas ; i++) {
            pregunta = new Pregunta();
            pregunta.setTitulo("Título pregunta " + i);
            pregunta.setDescripcion(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor "
                  + "incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud "
                  + "exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute "
                  + "iure reprehenderit in.");
            pregunta.setFecha(new Date());
            pregunta.setDesactivada(0);
            pregunta.setReportada(0);
            pregunta.setRevisada(0);
            pregunta.setId_respuesta_satisfactoria(null);
            preguntaDAOImpl.create(pregunta,"reneaves",3);
        }
    }
    
}




     