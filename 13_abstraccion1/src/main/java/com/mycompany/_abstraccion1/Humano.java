package com.mycompany._abstraccion1;
public class Humano extends SerVivo  {
    //atributos
    public String nombre;
    //constructor
    public Humano(String nombre){
        super("Homo Sapiens"); //construir la super clase
        this.nombre = nombre;
    }
    //implementacion de metodos abstractos
    @Override
    public void hablar() {
        System.out.println("Se comunica en el idioma que prefiere");
    }
    @Override
    public void desplazarse() {
        System.out.println("Camina de forma bipeda");
    }
    @Override
    public void alimentarse() {
        System.out.println("Come todo lo que prefiere");
    }
    @Override
    public void dormir() {
        System.out.println("zzz");
    }
}
