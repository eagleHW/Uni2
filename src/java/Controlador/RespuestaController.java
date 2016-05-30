/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.PreguntaDAOImpl;
import DAO.RespuestaDAOImpl;
import Modelo.Respuesta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rae
 */
@Controller
public class RespuestaController implements BeanFactoryAware {

    private RespuestaDAOImpl respuestaDAOImpl;
    private PreguntaDAOImpl preguntaDAOImpl;
    
    @RequestMapping(value = "/guardarRespuesta", method = RequestMethod.POST )
    public ModelAndView guardarRespuesta(ModelMap model,HttpServletRequest request, HttpSession sesion){

        if(sesion.getAttribute("login") == null){
          return new ModelAndView("inicioSesion");
        } 
        
        int id_pregunta = Integer.valueOf(request.getParameter("id_pregunta"));
        String descripcion =  request.getParameter("nueva_respuesta");
        Respuesta respuesta = new Respuesta();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        model.addAttribute("login", (String)sesion.getAttribute("login"));
        model.addAttribute("pregunta", preguntaDAOImpl.get(id_pregunta));
        model.addAttribute("id_pregunta",request.getParameter("id_pregunta"));
        model.addAttribute("num_respuesta",  preguntaDAOImpl.num_answers(id_pregunta) + 1);
      
        model.addAttribute("sdf",sdf);
        
        respuesta.setDescripcion(descripcion);
        respuesta.setFecha(new Date());
        respuesta.setEvaluacion(0);
        respuesta.setReportada(0);
        respuesta.setId_pregunta_satisfactoria(null);
        
        respuestaDAOImpl.create(respuesta, (String)sesion.getAttribute("login") , id_pregunta);
        
        // Va despues de create para que ya tenga asignado el id
        model.addAttribute("respuesta", respuesta);
        
        return new ModelAndView("nuevaRespuesta",model);
     
    }

    @RequestMapping(value = "/aceptarRespuesta", method = RequestMethod.POST )
    @ResponseBody
    public String aceptarRespuesta(HttpServletRequest request){
        
        int id_pregunta = Integer.valueOf(request.getParameter("id_pregunta"));
        int id_respuesta = Integer.valueOf(request.getParameter("id_respuesta"));
        
        respuestaDAOImpl.aceptar_repuesta(id_pregunta, id_respuesta);
        
        return "ok";
    }
    
    @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
        preguntaDAOImpl = (PreguntaDAOImpl) context.getBean("preguntaDAOImpl");
        respuestaDAOImpl = (RespuestaDAOImpl) context.getBean("respuestaDAOImpl");
    }
    
}
