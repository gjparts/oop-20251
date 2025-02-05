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
    
    
    
}
