/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.CarreraDAOImpl;
import DAO.PreguntaDAOImpl;
import Modelo.Pregunta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        
        if(sesion.getAttribute("login") == null){
          return new ModelAndView("inicioSesion");
        } 
        
        model.addAttribute("login", sesion.getAttribute("login"));
        model.addAttribute("command",new Pregunta());
        model.addAttribute("carreras", carreraDAOImpl.getCarreras());    
        
        return new ModelAndView("publicarPregunta",model);
    }
    
    @RequestMapping(value="/guardarPregunta", method = RequestMethod.POST )
    public String guardarPregunta(@ModelAttribute Pregunta pregunta, HttpServletRequest request ,HttpSession sesion){
        
        if(sesion.getAttribute("login") == null){
          return "redirect:/";
        } 
        
        pregunta.setFecha(new Date());
        pregunta.setDesactivada(0);
        pregunta.setReportada(0);
        pregunta.setRevisada(0);
        pregunta.setId_respuesta_satisfactoria(null);
        
        preguntaDAOImpl.create(pregunta,(String)sesion.getAttribute("login"), Integer.parseInt(request.getParameter("id_carrera")));
        
        return "redirect:mostrarPregunta?id=" + pregunta.getId_pregunta();
    }
    
    
    @RequestMapping(value="/mostrarPregunta", params = "id")
    public String mostrarPregunta(@RequestParam(value = "id") int pregunta_id, ModelMap model, HttpSession sesion){
    
         if(sesion.getAttribute("login") == null){
          return "redirect:/";
        } 
      
        Pregunta pregunta = preguntaDAOImpl.get(pregunta_id);
        
        if(pregunta == null){
            return "pagina_no_existente";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("login", (String)sesion.getAttribute("login"));
        model.addAttribute("pregunta", pregunta);
        model.addAttribute("respuestas", pregunta.getRespuestas());
        model.addAttribute("sdf",sdf);
        
        return "mostrarPregunta";
    }
    
    @RequestMapping(value="/mostrarPreguntas", method = RequestMethod.GET , params = "index")
    public String mostrarPreguntas(@RequestParam(value = "index") int index, ModelMap model){
        
        List<Pregunta> preguntas = preguntaDAOImpl.get(index*4, 4);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("preguntas", preguntas );
        model.addAttribute("sdf",sdf);
        
        String descripcion;
        String titulo;
             
        for(Pregunta pregunta : preguntas ) {
               
            descripcion = pregunta.getDescripcion();
            titulo = pregunta.getTitulo();
            
            if(descripcion.length() < 255){
                pregunta.setDescripcion(descripcion + "<br><br>");
            }else{
                pregunta.setDescripcion(descripcion.substring(0, 255) + " ....");
            }
            
            if(pregunta.getTitulo().length() > 67){
                pregunta.setTitulo(titulo.substring(0, 67) + " ....");
            }
                      
        }
        
        return "listaPreguntas";
    }
    
    @RequestMapping(value="/reportarPregunta", method = RequestMethod.POST)
    @ResponseBody
    public String reportarPregunta(HttpServletRequest request){
          
        int id_pregunta = Integer.valueOf(request.getParameter("id_pregunta"));    
        preguntaDAOImpl.reportar_pregunta(id_pregunta);
        
        return "ok";
        
    }
    
    @RequestMapping(value="/buscarPregunta", method= RequestMethod.GET)
    public ModelAndView buscarPregunta(HttpSession sesion, ModelMap model){
        
        if(sesion.getAttribute("login") == null){
          return new ModelAndView("inicioSesion");
        } 
        
        model.addAttribute("login", sesion.getAttribute("login"));
        model.addAttribute("carreras", carreraDAOImpl.getCarreras());    
        
        return new ModelAndView("buscarPregunta",model);
    }
    
    
    @RequestMapping(value="/realizarBusqueda", method= RequestMethod.POST)
    public ModelAndView realizarBusqueda(ModelMap model, HttpServletRequest request){
        
        String palabra_clave = request.getParameter("palabra_clave");
        String usuario = request.getParameter("usuario");
        String fecha = request.getParameter("fecha");
        String id_carrera = request.getParameter("id_carrera");
    
        Date fecha_formato = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if(!fecha.equals("")){
            
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fecha_formato = formatter.parse(fecha);
            } catch (ParseException ex) {
                System.out.println("Error de formato");
            }
      
        }
        
        model.addAttribute("sdf",sdf);
        model.addAttribute("preguntas", preguntaDAOImpl.buscar(palabra_clave, 
                            usuario,fecha_formato, Integer.valueOf(id_carrera)));
        
        return new ModelAndView("listaPreguntas",model);
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




     