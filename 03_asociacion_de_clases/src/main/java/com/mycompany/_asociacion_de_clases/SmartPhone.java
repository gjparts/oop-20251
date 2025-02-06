/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._asociacion_de_clases;

/**
 *
 * @author Gerardo
 */
public class SmartPhone {
    //atributos
    private Fabricante marca;
    private String modelo;
    private int almacenamiento;
    private int ram;
    private Bateria bateria;
    public Chip chip1;
    public Chip chip2;
    //constructor
    public SmartPhone(Fabricante marca, String modelo, int almacenamiento,
                      int ram, Bateria bateria, Chip chip1, Chip chip2) {
        //marca no puede ser null porque se asocia por composicion:
        //marca solo se puede asinar al construir ya que no debe cambiar
        if( marca == null )
            throw new IllegalArgumentException("marca no debe ser null");
        else
            this.marca = marca; // se acepta
        
        this.modelo = modelo;
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        
        this.setBateria(bateria);
        //los chip se asocian por agregacion, son opcionales
        //por lo tanto pueden venir null o pueden venir asignados.
        //por tal razon no los validamos
        this.chip1 = chip1;
        this.chip2 = chip2;
    }
    //metodos
    public void setBateria(Bateria bateria) {
        //la bateria se puede cambiar en cualquier momento
        //por eso le hicimos un metodo set
        //bateria no puede ser null porque se asocia por
        //composicion:
        if( bateria == null )
            throw new IllegalArgumentException("bateria no debe ser null");
        else
            this.bateria = bateria; //se acepta
    }
    public Fabricante getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public int getAlmacenamiento() {
        return this.almacenamiento;
    }
    public int getRam() {
        return this.ram;
    }
    public Bateria getBateria() {
        return this.bateria;
    }
    public void imprimir(){
        System.out.println("********** SmartPhone **********");
        System.out.println("Fabricante: "+this.marca.nombre);
        System.out.println("Modelo: "+this.modelo);
        System.out.println("Almacenamiento: "+this.almacenamiento);
        System.out.println("RAM: "+this.ram);
        //Desde el constructor y el metodo set nos aseguramos que
        //la bateria no sea null en estos casos no es necesario
        //a la hora de consumir el objeto validar que sea nulo.
        System.out.println("Bateria:");
        System.out.println("\tMarca: "+this.bateria.getMarca().nombre);
        System.out.println("\tMiliamperios: "+this.bateria.miliamperios);
        //Ahora toca imprimir los chip de llamadas (simcard)
        //la relacion entre SmartPhone y Chip es por agregacion
        //por lo tanto es opcional, no esta obligando a llenarlos
        //lo que puede ocurrir es que chip1 o chip2 puedan llegar
        //a contener valor null, un objeto que apunta a null no se
        //puede leer
        if( this.chip1 != null ){
            //si chip1 es distinto de null entonces lo imprimimos
            System.out.println("Chip1: ");
            System.out.println("\tNumero: "+this.chip1.numeroTelefonico);
            System.out.println("\tOperador: " +this.chip1.getProveedor().nombre);
        }
        if( this.chip2 != null ){
            //si chip2 es distinto de null entonces lo imprimimos
            System.out.println("Chip2: ");
            System.out.println("\tNumero: "+this.chip2.numeroTelefonico);
            System.out.println("\tOperador: " +this.chip2.getProveedor().nombre);
        }
        //a la validacion anterior se le conoce como codigo null safety
        //o sea a prueba de nulos.
    }
    
    
}
