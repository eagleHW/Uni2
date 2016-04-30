/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController implements BeanFactoryAware {

    private UsuarioJDBCTemplate usuarioJDBCTemplate;
    
   @RequestMapping(value = "/")
   public ModelAndView index(){
       return new ModelAndView("index", "command", new Login());
   }
   
   @RequestMapping(value = "/home", method = RequestMethod.POST)
   public String home(@ModelAttribute Login login, 
   ModelMap model) {
             
      model.addAttribute("login", login.getLogin());
      
      //usuarioJDBCTemplate.create("prueba2", "prueba2", "prueba2", "prueba2");
      
      return "home";
   }

    @Override
    public void setBeanFactory(BeanFactory context) throws BeansException {
    
      usuarioJDBCTemplate = (UsuarioJDBCTemplate)context.getBean("usuarioJDBCTemplate");
    
        
    }


           

}