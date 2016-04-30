/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

 
   @RequestMapping(value = "/")
   public ModelAndView index(){
       return new ModelAndView("index", "command", new Login());
   }
   
   @RequestMapping(value = "/home", method = RequestMethod.POST)
   public String addStudent(@ModelAttribute Login login, 
   ModelMap model) {
             
      model.addAttribute("login", login.getLogin());
      
      return "home";
   }


           

}