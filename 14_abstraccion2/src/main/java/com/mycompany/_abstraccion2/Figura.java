package com.mycompany._abstraccion2;
public abstract class Figura {
    //atributo
    private String nombre;
    //constructor
    public Figura(String nombre){
        this.nombre = nombre;
    }
    //metodos abstractos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    //metodos concreto
    public String getNombre(){
        return this.nombre;
    }
}
