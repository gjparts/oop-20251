package com.mycompany._polimorfismo1;
public class Gato extends Animal {
    //atributos
    public String apodo;
    private boolean tienePelaje;
    //constructor
    public Gato(String apodo, boolean tienePelaje,
            boolean tieneCola){
        //construir la super clase
        super("Gato", "Felino", 4, tieneCola);
        //inicializar atributos de esta clase
        this.apodo = apodo;
        this.tienePelaje = tienePelaje;
    }
    //metodos
    public void ronronear(){
        System.out.println("prrrrrrrrrrrrr");
    }
    //Polimorfismo: reemplazar la respuestra de un metodo heredado
    @Override //anular, superponer, reemplazar
    public void hablar(){
        //Override completo: no se reutiliza nada del metodo heredado
        //o sea se cambia por completo lo que hace el metodo.
        System.out.println("Miau");
    }
    @Override
    public void imprimir(){
        //Override parcial: reutilizar el metodo hererado
        //y le agrega nueva funcionalidad
        super.imprimir(); //mandar a llamar el metodo de la super clase
        //ejecutar nuevo codigo adicional
        System.out.println("Apodo: "+this.apodo);
        System.out.println("Tiene pelaje: "+(this.tienePelaje ? "Si" : "No"));
    }
}
