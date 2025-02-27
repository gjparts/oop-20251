package com.mycompany._asociacion_multiplicidad;

import java.util.LinkedList; //importar lista vinculada
public class Persona {
    //atributos
    public String identidad;
    public String nombre;
    public int telefono;
    public Direccion direccion;
    public Empresa empresaLabora;
    public Mascota[] mascotas;
    public LinkedList<Diploma> diplomas; //lista vinculada restringida solo a objetos Diploma
    public Persona conyuge;
    public LinkedList<Persona> hijos; //lista vinculada restringida solo a objetos Persona
    
    //constructor
    public Persona(String identidad, String nombre, int telefono) {
        this.identidad = identidad;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    //metodos
    public void imprimir(){
        System.out.println("***** Perfil de Persona ***** ");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Identidad: "+this.identidad);
        System.out.println("Telefono: "+this.telefono);
        //direccion (probablemente sea null, porque viene por agregacion)
        if( this.direccion != null ){
            System.out.println("Direccion de residencia:");
            System.out.println("\tBarrio: "+this.direccion.getColonia().nombre);
            System.out.println("\tCalle: "+this.direccion.calle);
            System.out.println("\tAvenida: "+this.direccion.avenida);
            System.out.println("\tBloque: "+this.direccion.bloque);
            System.out.println("\tCasa: "+this.direccion.casa);
            System.out.println("\tCodigo Postal: "+this.direccion.getColonia().codigoPostal);
        }
        //empresa donde trabaja
        if( this.empresaLabora != null ){
            System.out.println("Empresa donde labora:");
            System.out.println("\tNombre: "+this.empresaLabora.nombre);
            System.out.println("\tTelefono: "+this.empresaLabora.telefono);
            System.out.println("\tDireccion de la Empresa:");
            System.out.println("\tBarrio: "+this.empresaLabora.getDireccion().getColonia().nombre);
            System.out.println("\tCalle: "+this.empresaLabora.getDireccion().calle);
            System.out.println("\tAvenida: "+this.empresaLabora.getDireccion().avenida);
            System.out.println("\tBloque: "+this.empresaLabora.getDireccion().bloque);
            System.out.println("\tCasa: "+this.empresaLabora.getDireccion().casa);
            System.out.println("\tCodigo Postal: "+this.empresaLabora.getDireccion().getColonia().codigoPostal);
        }
        //coleccion de Mascotas (Array)
        if( this.mascotas != null ){
            System.out.println("Mascotas:");
            for (int i = 0; i < this.mascotas.length; i++) {
                //ignorar la mascota en el i-esimo elemento si es null
                if( this.mascotas[i] != null ){
                    System.out.println("\t* Nombre: "+this.mascotas[i].nombre);
                    System.out.println("\t  Especie: "+this.mascotas[i].especie);
                }
            }
        }
        //coleccion de Diplomas (LinkedList)
        if( this.diplomas != null ){
            System.out.println("Diplomas:");
            for (int i = 0; i < this.diplomas.size(); i++) {
                //solo se imprime aquellos diplomas quw no sean null
                if( this.diplomas.get(i) != null ){
                    System.out.println("\t* Institucion: "+this.diplomas.get(i).institucion);
                    System.out.println("\t  Curso: "+this.diplomas.get(i).nombre);
                }
            }
        }
        //datos del conyuge
        if( this.conyuge != null ){
            System.out.println("Nombre del Conyuge: "+this.conyuge.nombre);
            System.out.println("Telefono del Conyuge: "+this.conyuge.telefono);
        }
        //coleccion de Hijos (LinkedList)
        if( this.hijos != null ){
            System.out.println("Hijos: ");
            for (int i = 0; i < this.hijos.size(); i++) {
                if( this.hijos.get(i) != null ){
                    System.out.println("\t* "+this.hijos.get(i).nombre);
                }
            }
        }
    }
}
