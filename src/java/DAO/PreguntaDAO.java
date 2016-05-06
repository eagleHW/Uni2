/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Pregunta;

/**
 *
 * @author rae
 */
public interface PreguntaDAO {
    
    public void create(Pregunta pregunta);

    public Pregunta get(int pregunta_id);
    
}
