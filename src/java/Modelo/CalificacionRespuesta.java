/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 *
 * @author rae
 */
@Entity
@Table(name="Calificacion_Respuesta")
public class CalificacionRespuesta implements Serializable {
    
    @EmbeddedId
    private CalificacionRespuestaPK calificacion_respuesta_pk;
    
    @Column(name="UsuarioNombre_usuario")
    private String login;

    public CalificacionRespuestaPK getPk() {
        return calificacion_respuesta_pk;
    }

    public String getLogin() {
        return login;
    }

    public void setPk(CalificacionRespuestaPK pk) {
        this.calificacion_respuesta_pk = pk;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    @Embeddable
    public class CalificacionRespuestaPK implements Serializable{

        @Column(name="CalificacionIDCalificacion")
        private int id_calificacion;
   
        @Column(name="RespuestaIDRespuesta")
        private int id_respuesta;

        public int getId_calificacion() {
            return id_calificacion;
        }

        public int getId_respuesta() {
            return id_respuesta;
        }

        public void setId_calificacion(int id_calificacion) {
            this.id_calificacion = id_calificacion;
        }

        public void setId_respuesta(int id_respuesta) {
            this.id_respuesta = id_respuesta;
        }
    
        
        
    }        
 

}

