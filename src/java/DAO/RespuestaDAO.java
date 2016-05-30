/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Respuesta;

/**
 *
 * @author rae
 */
public interface RespuestaDAO {

    public void create(Respuesta respuesta,String login, int id_pregunta);

    public void aceptar_repuesta(int id_pregunta, int id_respuesta);
    
}
