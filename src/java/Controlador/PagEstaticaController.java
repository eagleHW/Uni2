
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

/**
 *
 * Tiene como funcion desplegar las vistas de Politica de Privacidad y Condiciones de Uso.
 * 
 * @author rae
 **/

@Controller
public class PagEstaticaController {

   @RequestMapping(value = "/politicaPrivacidad")
   public String politicaPrivacidad(){
       return "politicaPrivacidad";
   }
   
    @RequestMapping(value = "/condicionesUso")
    public String condicionesUso(){
       return "condicionesUso";
   }
   
}
