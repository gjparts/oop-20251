package com.mycompany._abstraccion1;
public abstract class SerVivo {
    //atributos
    public String especie;
    //constructor
    public SerVivo(String especie){
        this.especie = especie;
    }
    //metodos abstractos (prototipos de funcion)
    public abstract void hablar();
    public abstract void desplazarse();
    public abstract void alimentarse();
    public abstract void dormir();
    //metodos concretos (no son abstractos)
    public void vivir(){
        //para este ejemplo el metodo vivir depende
        //de lo que el programador ponga en los metodos abstractos
        this.desplazarse();
        this.alimentarse();
        this.hablar();
        this.dormir();
    }
    //metodo de instanciacion
    //(devuelve un objeto de una clase que hereda a SerVivo
    //en este caso Humano hereda de SerVivo
    //los metodos de instanciacion SIEMPRE son static porque
    //solo se definen una vez en la clase por ejecucion
    //esto se le conoce como patron Singleton
    public static SerVivo getInstance(){
        return new Humano("Humano generico");
    }
}
