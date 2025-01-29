/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._primero;

/**
 * Define a un empleado.
 * @author Gerardo Portillo
 * @since  2025-01-28
 */
public class Empleado {
    //atributos
    public String nombre;
    private int edad;
    private char genero;
    private float salario;
    private char contrato;
    //constructores
    /**
     * Construye un nuevo objeto de clase Empleado
     * @param nombre    nombre del empleado
     * @param edad      edad del empleado en numeros enteros
     * @param genero    genero puede ser M = Masculino, F = Femenino, X = Otros
     * @param salario   el salario del empleado en numeros float
     * @param contrato  el contrato puede ser P = Permanente, T = Temporal
     */
    public Empleado(String nombre, int edad, char genero, float salario, char contrato){
        this.nombre = nombre;
        this.setEdad(edad); //el valor de cada atributo privado se establece por medio de set
        this.setGenero(genero);
        this.setSalario(salario);
        this.setContrato(contrato);
    }
    /**
     * Construye un nuevo objeto de clase Empleado
     * @param nombre    nombre del empleado
     * @param edad      edad del empleado en numeros enteros
     * @param genero    genero puede ser M = Masculino, F = Femenino, X = Otros
     */
    public Empleado(String nombre, int edad, char genero){
        this.nombre = nombre;
        this.setEdad(edad);
        this.setGenero(genero);
        this.salario = 0.00f;
        this.contrato = 'P';
    }
    //metodos
    /**
     * Imprime el perfil del empleado
     */
    public void imprimir(){
        System.out.println("******** PERFIL DE EMPLEADO ********");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Edad: "+this.edad);
        System.out.println("Genero: "+this.genero);
        System.out.println("Salario: "+this.salario);
        System.out.println("Contrato: "+this.contrato);
    }
    //los metodos get normalmente son del mismo tipo de dato del atributo a leer
    /**
     * Retorna la edad del empleado
     * @return un numero entero
     */
    public int getEdad(){
        return this.edad;
    }
    //los metodos set normalmente son void porque no deberian retornar informacion
    //ya que solo se usan para escribir, llevan un solo parametro que generalmente
    //es del tipo de dato del atributo a afectar.
    /**
     * Establece la edad del empleado
     * @param edad un numero entero >= 0
     */
    public void setEdad(int edad){
        //edad solo permite numeros >= 0
        if( edad >= 0 )
            this.edad = edad; //se acepta
        else
            throw new IllegalArgumentException("La edad debe ser un numero >= 0");
    }
    /**
     * Retorna el genero del empleado
     * @return un valor char que puede ser:
     * <ul>
     *  <li>F para femenino</li>
     *  <li>M para masculino</li>
     *  <li>X para otros</li>
     * </ul>
     */
    public char getGenero(){
        return this.genero;
    }
    /**
     * Establece el genero del empleado
     * @param genero un valor char que puede ser:
     * <ul>
     *  <li>F para femenino</li>
     *  <li>M para masculino</li>
     *  <li>X para otros</li>
     * </ul>
     */
    public void setGenero(char genero){
        if( genero == 'M' || genero == 'F' || genero == 'X' )
            this.genero = genero; //se acepta
        else
            throw new IllegalArgumentException("Genero debe ser M, F, X");
    }
    /**
     * Retorna el salario del empleado
     * @return un valor float
     */
    public float getSalario(){
        return this.salario;
    }
    /**
     * Establece el salario del empleado
     * @param salario un valor float >= 0
     */
    public void setSalario(float salario){
        if( salario >= 0 )
            this.salario = salario; //se acepta
        else
            throw new IllegalArgumentException("Salario debe ser >= 0");
    }
    /**
     * Retorna el tipo de contrato del empleado
     * @return un valor char que puede ser:
     * <ul>
     *  <li>P para Permanente</li>
     *  <li>T para Temporal</li>
     * </ul>
     */
    public char getContrato(){
        return this.contrato;
    }
    /**
     * Establece el tipo de contrato del empleado
     * @param contrato un valor char que puede ser:
     * <ul>
     *  <li>P para Permanente</li>
     *  <li>T para Temporal</li>
     * </ul>
     */
    public void setContrato(char contrato){
        if( contrato == 'T' || contrato == 'P' )
            this.contrato = contrato;
        else
            throw new IllegalArgumentException("Contrato debe ser T, P");
    }
}
