/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.PreguntaDAOImpl;
import DAO.UsuarioDAOImpl;
import Modelo.Pregunta;
import Modelo.Usuario;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
public class UsuarioController implements BeanFactoryAware {
    
    private UsuarioDAOImpl usuarioDAOImpl;
    private PreguntaDAOImpl preguntaDAOImpl;
    
    @RequestMapping(value = "/registrarUsuario")
    public ModelAndView registarUsuario() {
      return new ModelAndView("registrarUsuario", "command", new Usuario());       
    }
   
    @RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST )
    public String guardarUsuario(@ModelAttribute Usuario usuario, HttpServletRequest request){
       
        String password;
        
        Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        password = encoderMD5.encodePassword(usuario.getContraseña(),"aes2016-1");
        
        usuario.setContraseña(password);
        usuario.setRango("nuevo");
        usuario.setBloqueado(0);
        usuario.setId_carrera(1);

        usuarioDAOImpl.create(usuario);
        
        request.getSession(true).setAttribute("login", usuario.getLogin());
        
        return "redirect:home";
    }
    
    @RequestMapping(value = "/perfilUsuario")
    public ModelAndView perfilUsuario(ModelMap model, HttpSession sesion) {
        
      Usuario usuario = usuarioDAOImpl.get((String)sesion.getAttribute("login"));
        
      model.addAttribute("nombre", usuario.getNombre());
      model.addAttribute("apellido_paterno", usuario.getApellido_paterno());
      model.addAttribute("apellido_materno", usuario.getApellido_materno());
      model.addAttribute("contraseña", usuario.getContraseña());
      model.addAttribute("correo", usuario.getCorreo());
      model.addAttribute("facebook", usuario.getFacebook());
      model.addAttribute("whatsapp", usuario.getWhatsapp());
      
      return new ModelAndView("perfilUsuario", "command", new Usuario());       
    }
    
    @RequestMapping(value = "/guardarCambiosUsuario", method = RequestMethod.POST )
    public String guardarModificacionUsuario(@ModelAttribute Usuario usuario, HttpSession sesion){
    
        String[] columnas = {"nombre","apellido_paterno","apellido_materno","contraseña","correo","facebook","whatsapp" };
        String[] valores = {usuario.getNombre(),usuario.getApellido_paterno(), usuario.getApellido_materno(),
                usuario.getContraseña(),usuario.getCorreo(),usuario.getFacebook(), usuario.getWhatsapp().toString()};
        
        usuarioDAOImpl.update((String)sesion.getAttribute("login"), columnas, valores);
        
        return "redirect:perfilUsuario";
    }
    
    @RequestMapping(value = "/realizarPregunta")
    public ModelAndView realizarPregunta(){
        return new ModelAndView("realizarPregunta","command",new Pregunta());
        
    }
    
    @RequestMapping(value="/guardarPregunta", method = RequestMethod.POST )
    public String guardarPregunta(@ModelAttribute Pregunta pregunta, HttpSession sesion){
        
        pregunta.setLogin((String)sesion.getAttribute("login"));
        pregunta.setFecha(new Date());
        pregunta.setDesactivada(0);
        pregunta.setReportada(0);
        pregunta.setRevisada(0);
        pregunta.setId_respuesta_satisfactoria(0);
        pregunta.setCarrera(1);
        
        preguntaDAOImpl.create(pregunta);
        
        return "redirect:mostrarPregunta/" + pregunta.getId_pregunta();
    }
    
    
    @RequestMapping(value="/mostrarPregunta/{id}")
    public String mostrarPregunta(@PathVariable("id") int pregunta_id, ModelMap model){
    
        Pregunta pregunta = preguntaDAOImpl.get(pregunta_id);
        
        model.addAttribute("titulo", pregunta.getTitulo());
        model.addAttribute("descripcion", pregunta.getDescripcion());
        
        return "mostrarPregunta";
    }
    
    
   @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
      usuarioDAOImpl = (UsuarioDAOImpl)context.getBean("usuarioDAOImpl");
      preguntaDAOImpl = (PreguntaDAOImpl) context.getBean("preguntaDAOImpl");
    }    

    
}
