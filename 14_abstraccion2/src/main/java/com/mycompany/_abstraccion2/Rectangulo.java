package com.mycompany._abstraccion2;
public class Rectangulo extends Figura {
    //atributos
    private double largo;
    private double ancho;
    //constructor
    public Rectangulo(double largo, double ancho){
        super("Rectangulo");
        this.largo = largo;
        this.ancho = ancho;
    }
    //implementar los metodos abstractos
    @Override
    public double calcularArea() {
        return this.largo*this.ancho;
    }
    @Override
    public double calcularPerimetro() {
        return 2*this.largo+2*this.ancho;
    }
    //metodos
    public double getLargo() {
        return this.largo;
    }
    public double getAncho() {
        return this.ancho;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
}

