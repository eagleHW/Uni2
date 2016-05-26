/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rae
 */
@Entity
@Table(name="Carrera")
public class Carrera implements Serializable {
    
    @Id 
    @Column(name="IDCarrera")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carrera;
 
    @Column(name="Nombre")
    private String carrera;

    @OneToMany(mappedBy="carrera")
    private List<Usuario> usuarios = new LinkedList<Usuario>();
    
    @OneToMany(mappedBy="carrera")
    private List<Pregunta> preguntas = new LinkedList<Pregunta>();
    
    public int getId_carrera() {
        return id_carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    
    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

}
