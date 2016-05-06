/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author rae
 */

@Entity
@Table(name="Calificacion")
public class Calificacion {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IdCalificacion")
    private int id_calicicacion;
    
    @Column(name="Valor")
    private int valor;

    public int getId_calicicacion() {
        return id_calicicacion;
    }

    public int getValor() {
        return valor;
    }
    
    public void setId_calicicacion(int id_calicicacion) {
        this.id_calicicacion = id_calicicacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
