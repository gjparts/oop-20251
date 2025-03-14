package com.mycompany._abstraccion1;
public class Gato extends SerVivo {
    //atributos
    public String apodo;
    //constructor
    public Gato(String apodo){
        //construir la super clase
        super("Felino");
        this.apodo = apodo;
    }
    //implementacion de los metodos abstractos (obligatorio)
    @Override
    public void dormir(){
        System.out.println("Busca un rincon y se duerme");
    }
    @Override
    public void alimentarse(){
        System.out.println("Come alimentos para gatos");
    }
    @Override
    public void desplazarse(){
        System.out.println("Camina silencioso");
    }
    @Override
    public void hablar(){
        System.out.println("Dice miau");
    }
}
