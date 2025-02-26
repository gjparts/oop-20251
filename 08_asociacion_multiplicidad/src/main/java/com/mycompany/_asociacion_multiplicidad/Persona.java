package com.mycompany._asociacion_multiplicidad;
public class Persona {
    //atributos
    public String identidad;
    public String nombre;
    public int telefono;
    public Direccion direccion;
    public Empresa empresaLabora;
    public Mascota[] mascotas;
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
    }
}
