/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import DAO.UsuarioDAOImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController implements BeanFactoryAware {
    
    private UsuarioDAOImpl usuarioDAOImpl;
    
   @RequestMapping(value = "/")
   public String index(){
       //return new ModelAndView("index", "command", new Login());
       return "index";
   }
   
    @RequestMapping(value = "/home")
    public String home(HttpSession sesion, ModelMap model) {
             
      model.addAttribute("login", sesion.getAttribute("login"));
      return "home";
    }

   
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(ModelMap model,HttpServletRequest request){
       
        String login = request.getParameter("login"); 
        String password = request.getParameter("password");
    
        boolean acceso = usuarioDAOImpl.login(login, password);
         
       if(acceso){
           
        request.getSession(true).setAttribute("login", login);
        return "redirect:home";

       }else{
           
        model.addAttribute("error", "Login o contraseña incorrecta");
        return "index";   
           
       }
       
    }
      
    @RequestMapping(value = "/logout")
    public String logout(HttpSession sesion){
    
        sesion.invalidate();
        return "redirect:/";
   
    }
    
    @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
    
      usuarioDAOImpl = (UsuarioDAOImpl)context.getBean("usuarioDAOImpl");
        
    }


           

}