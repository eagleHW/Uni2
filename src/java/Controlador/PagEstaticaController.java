
package Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
