package com.mycompany._asociacion_de_clases;
public class Estudiante {
    //atributos
    public String cuenta;
    public String nombre;
    public String carrera;
    private int edad;
    private Direccion direccion;
    public Cargo trabajo;
    //constructor
    public Estudiante(String cuenta, String nombre, String carrera, int edad, Direccion direccion, Cargo trabajo) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.carrera = carrera;
        this.setEdad(edad);
        this.setDireccion(direccion);
        this.trabajo = trabajo;
    }
    //metodos
    public void setDireccion(Direccion direccion) {
        if( direccion != null )
            this.direccion = direccion; //se acepta
        else
            throw new IllegalArgumentException("Direccion no debe ser null");
    }
    public void setEdad(int edad) {
        if( edad >= 0 )
            this.edad = edad; //se acepta
        else
            throw new IllegalArgumentException("Edad debe de ser >= 0");
    }
    public int getEdad() {
        return this.edad;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    
}
