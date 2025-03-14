package com.mycompany._abstraccion1;
public class App {

    public static void main(String[] args) {
        //Las clases abstractas no se pueden instsnciar
        //por medio de new
        //SerVivo ser1 = new SerVivo("Canino");
        
        Gato g1 = new Gato("Naranjoso");
        g1.vivir();
        System.out.println("***********************");
        Humano h1 = new Humano("Gerardo");
        h1.vivir();
        
        //se puede instanciar una clase clase abstracta
        //a traves de un metodo de instanciacion
        //como lo hacian con Calendar.getInstance()
        System.out.println("***********************");
        SerVivo s1 = SerVivo.getInstance();
        System.out.println("Especie del serVivo: "+s1.especie);
        s1.vivir();
        
        //tambien se puede instanciar una clase abstracta
        //por medio de la implementacion de sus metodos abstractos
        //al momento de inicializar el objeto
        SerVivo perro = new SerVivo("Canino"){
            @Override
            public void hablar() {
                System.out.println("Dice guau");
            }
            @Override
            public void desplazarse() {
                System.out.println("Camina de forma cuadrupeda");
            }
            @Override
            public void alimentarse() {
                System.out.println("Come todo lo que se le cruce");
            }
            @Override
            public void dormir() {
                System.out.println("Da un par de vueltas y se duerme");
            } 
        };
        System.out.println("**********************");
        perro.vivir();
    }
}
