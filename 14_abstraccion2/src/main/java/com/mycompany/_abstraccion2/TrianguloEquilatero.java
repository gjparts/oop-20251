package com.mycompany._abstraccion2;
public class TrianguloEquilatero extends Figura {
    //atributos
    private double altura;
    private double base;
    //constructor
    public TrianguloEquilatero(double altura, double base) {
        super("Triangulo Equilatero");
        this.altura = altura;
        this.base = base;
    }
    //implementar los metodos abstractos
    @Override
    public double calcularArea() {
        return this.base*this.altura/2.0;
    }
    @Override
    public double calcularPerimetro() {
        return 3*this.base;
    }
    //metodos
    public double getAltura() {
        return this.altura;
    }
    public double getBase() {
        return this.base;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setBase(double base) {
        this.base = base;
    }
}
