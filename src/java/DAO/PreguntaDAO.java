/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Pregunta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rae
 */
public interface PreguntaDAO {
    
    public void create(Pregunta pregunta,String login, int id_carrera);

    public Pregunta get(int pregunta_id);
    
    public List get(int offset, int limit);
    
    public int num_answers(int id_pregunta);
    
    public void reportar_pregunta(int id_pregunta);
    
    public List buscar(String palabra_clave, String usuario, Date fecha, int id_carrera );
    
}
