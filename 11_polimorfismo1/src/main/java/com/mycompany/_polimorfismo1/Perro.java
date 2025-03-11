package com.mycompany._polimorfismo1;
public class Perro extends Animal {
    //atributos
    public String apodo;
    private String raza;
    //constructor
    public Perro(String apodo, String raza, boolean tieneCola){
        //construir la super clase
        super("Perro", "Canino", 4, tieneCola);
        //atributos de esta clase
        this.apodo = apodo;
        this.raza = raza;
    }
    //metodos
    public void jugar(){
        System.out.println("Corre por todos lados, da volteretas.");
    }
    @Override
    public void hablar(){
        System.out.println("Guau"); //Override completo
    }
    @Override
    public void imprimir(){
        super.imprimir(); //Override parcial
        System.out.println("Apodo: "+this.apodo);
        System.out.println("Raza: "+this.raza);
    }
}
