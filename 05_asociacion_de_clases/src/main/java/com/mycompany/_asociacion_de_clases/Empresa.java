package com.mycompany._asociacion_de_clases;
public class Empresa {
    //atributos
    public String nombre;
    public String rubro;
    private Direccion direccion;
    public String telefono;
    //constructor
    public Empresa(String nombre, String rubro, Direccion direccion, String telefono) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.setDireccion(direccion);
        this.telefono = telefono;
    }
    //metodos
    public void setDireccion(Direccion direccion) {
        if( direccion == null )
            throw new IllegalArgumentException("Direccion no puede ser null");
        else
            this.direccion = direccion; //se acepta
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
}
