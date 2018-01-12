package com.pojo;
// Generated 12/01/2018 12:21:09 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Grado generated by hbm2java
 */
public class Grado  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Integer valor;
     private Set alumnogrados = new HashSet(0);

    public Grado() {
    }

    public Grado(String nombre, Integer valor, Set alumnogrados) {
       this.nombre = nombre;
       this.valor = valor;
       this.alumnogrados = alumnogrados;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Set getAlumnogrados() {
        return this.alumnogrados;
    }
    
    public void setAlumnogrados(Set alumnogrados) {
        this.alumnogrados = alumnogrados;
    }




}

