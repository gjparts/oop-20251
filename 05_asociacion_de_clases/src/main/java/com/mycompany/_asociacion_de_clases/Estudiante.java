package com.mycompany._asociacion_de_clases;
public class Estudiante {
    //atributos
    public String cuenta;
    public String nombre;
    public String carrera;
    private int edad;
    private Direccion direccion;
    public Cargo trabajo;
    //constructor
    public Estudiante(String cuenta, String nombre, String carrera, int edad, Direccion direccion, Cargo trabajo) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.carrera = carrera;
        this.setEdad(edad);
        this.setDireccion(direccion);
        this.trabajo = trabajo;
    }
    //metodos
    public void setDireccion(Direccion direccion) {
        if( direccion != null )
            this.direccion = direccion; //se acepta
        else
            throw new IllegalArgumentException("Direccion no debe ser null");
    }
    public void setEdad(int edad) {
        if( edad >= 0 )
            this.edad = edad; //se acepta
        else
            throw new IllegalArgumentException("Edad debe de ser >= 0");
    }
    public int getEdad() {
        return this.edad;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    public void imprimir(){
        System.out.println("****** Estudiante ******");
        System.out.println("Cuenta: "+this.cuenta);
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Carrera: "+this.carrera);
        System.out.println("Edad: "+this.edad);
        //como la direccion no puede ser null gracias al metodo set
        //entonces no es necesario validarla
        System.out.println("Direccion:");
        System.out.println("\tCalle: "+this.direccion.calle);
        System.out.println("\tAvenida: "+this.direccion.ave);
        System.out.println("\tCasa: "+this.direccion.casa);
        //en la Direccion el Barrio tampoco lo hemos permitido null
        //por eso tampoco lo validamos
        System.out.println("\tBarrio: "+this.direccion.getBarrio().nombre);
        System.out.println("\tCiudad: "+this.direccion.getBarrio().ciudad);
        System.out.println("\tMunicipio: "+this.direccion.getBarrio().municipio);
        System.out.println("\tPais: "+this.direccion.getBarrio().pais);
        //trabajo es un atributo publico y opcional de llenar
        //por lo tanto puede venir null, asi que lo validamos
        if( this.trabajo != null ){
            System.out.println("Informacion Laboral:");
            System.out.println("\tCargo: "+this.trabajo.descripcion);
            System.out.println("\tEmpresa o Negocio: "+this.trabajo.getEmpresa().nombre);
            System.out.println("\tJornada: "+this.trabajo.getJornadaDescripcion());
            System.out.println("\tSalario: "+this.trabajo.getSalario());
            System.out.println("\tCiudad: "+this.trabajo.getEmpresa().getDireccion().getBarrio().ciudad);
        }
    }
}
