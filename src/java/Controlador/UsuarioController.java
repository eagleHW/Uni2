/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.CarreraDAOImpl;
import DAO.UsuarioDAOImpl;
import Modelo.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *^[a-z]+([\s]*[a-z])*$
 * 
 * 
 * @author rae
 */
@Controller
public class UsuarioController implements BeanFactoryAware {
    
    private UsuarioDAOImpl usuarioDAOImpl;
    private CarreraDAOImpl carreraDAOImpl;
    
    @RequestMapping(value = "/registroUsuario")
    public ModelAndView registroUsuario(ModelMap model, HttpSession sesion) {
              
        model.addAttribute("command",new Usuario());
        model.addAttribute("carreras", carreraDAOImpl.getCarreras());
                
      return new ModelAndView("registroUsuario", model);       
    }
   
    @RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST )
    public String guardarUsuario(Usuario usuario,HttpServletRequest request, HttpSession sesion){
               
        String password;
        
        Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
        password = encoderMD5.encodePassword(usuario.getContraseña(),"aes2016-1");
      
        // Se uso id_carrera y no carrera por que chocaba con el atributo carrera en Usuario
        String id_carrera = request.getParameter("id_carrera");
      
         System.out.println("Antes -------------------------" + usuario.getLogin());
        usuario.setContraseña(password);
        usuario.setRango("nuevo");
        usuario.setBloqueado(0);
        
        usuarioDAOImpl.create(usuario, Integer.parseInt(id_carrera));

        System.out.println("Despues -------------------------" + usuario.getLogin());
        
        request.getSession(true).setAttribute("login", usuario.getLogin());
        
        return "redirect:home";
    }
    
    @RequestMapping(value = "/perfilUsuario")
    public ModelAndView perfilUsuario(ModelMap model, HttpSession sesion) {
      
        if(sesion.getAttribute("login") == null){
          return new ModelAndView("inicioSesion");
        } 
        
      Usuario usuario = usuarioDAOImpl.get((String)sesion.getAttribute("login"));
        
      model.addAttribute("nombre", usuario.getNombre());
      model.addAttribute("apellido_paterno", usuario.getApellido_paterno());
      model.addAttribute("apellido_materno", usuario.getApellido_materno());
      model.addAttribute("correo", usuario.getCorreo());
      model.addAttribute("facebook", usuario.getFacebook());
      model.addAttribute("whatsapp", usuario.getWhatsapp());
      
      model.addAttribute("id_carrera", usuario.getCarrera().getId_carrera());    
      model.addAttribute("carreras", carreraDAOImpl.getCarreras());
      
      return new ModelAndView("perfilUsuario", "command", new Usuario());       
    }
    
    @RequestMapping(value = "/guardarCambiosUsuario", method = RequestMethod.POST )
    @ResponseBody
    public String guardarModificacionUsuario(@ModelAttribute Usuario usuario, HttpServletRequest request ,HttpSession sesion){
    
        if(sesion.getAttribute("login") == null){
          return "Acceso Denegado";
        } 
        
        String[] columnas = {"nombre","apellido_paterno","apellido_materno","id_carrera","correo","facebook","whatsapp" };
        String[] valores = {usuario.getNombre(),usuario.getApellido_paterno(),usuario.getApellido_materno(), 
            request.getParameter("id_carrera") , usuario.getCorreo(),usuario.getFacebook(), usuario.getWhatsapp().toString()};
        
        usuarioDAOImpl.update((String)sesion.getAttribute("login"), columnas, valores);
        
        return "ok";
    }

    @RequestMapping(value = "/guardarCambiosContrasena", method = RequestMethod.POST )
    @ResponseBody
    public String guardaModificacionContraseña(HttpServletRequest request ,HttpSession sesion){
     
        if(sesion.getAttribute("login") == null){
          return "Acceso Denegado";
        }
        
        boolean contraseña_correcta = usuarioDAOImpl.login((String)sesion.getAttribute("login"), 
                                            request.getParameter("contrasena_anterior"));
        
        if(contraseña_correcta){
            String password;
            Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
            password = encoderMD5.encodePassword(request.getParameter("contrasena_nueva"),"aes2016-1");

            String[] columnas = {"contraseña"};
            String[] valores = {password};

            usuarioDAOImpl.update((String)sesion.getAttribute("login"), columnas, valores);

            return "ok";
        }
        
        return "error";
    }
   
    
   @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
      usuarioDAOImpl = (UsuarioDAOImpl)context.getBean("usuarioDAOImpl");
      carreraDAOImpl = (CarreraDAOImpl) context.getBean("carreraDAOImpl");
    }    

    
}
