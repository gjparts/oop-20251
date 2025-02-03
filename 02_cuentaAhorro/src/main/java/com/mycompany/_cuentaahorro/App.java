/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._cuentaahorro;

/**
 *
 * @author Gerardo
 */
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        /*CuentaAhorro cue1 = new CuentaAhorro("Gerardo", "1234567890");
        System.out.println("Saldo de cue1: "+cue1.getSaldo());
        cue1.depositar(1000);
        System.out.println("Saldo de cue1: "+cue1.getSaldo());
        cue1.retirar(500);
        System.out.println("Saldo de cue1: "+cue1.getSaldo());*/
        //suponga que el cliente tiene 3 cuentas al iniciar en el cajero automatico:
        CuentaAhorro c1 = new CuentaAhorro("Gerardo", "456000123");
        CuentaAhorro c2 = new CuentaAhorro("Gerardo", "456000787");
        CuentaAhorro c3 = new CuentaAhorro("Gerardo", "456001234");
        
        //variable bandera para control de la cuenta en la que se esta trabajando
        CuentaAhorro actual = c1;
        
        Scanner s = new Scanner(System.in);
        int opcion;
        
        do{
            System.out.println("------------ BANCA ROTA: Tu Banca amiga ------------");
            System.out.println("Bienvenido: "+actual.nombreCliente);
            System.out.println("Cuenta actual: "+actual.numeroCuenta);
            System.out.println("1) Depositar");
            System.out.println("2) Retirar");
            System.out.println("3) Consultar saldo");
            System.out.println("4) Seleccionar otra cuenta de ahorro");
            System.out.println("5) Salir");
            System.out.print("Digite el numero de opcion: ");
            opcion = s.nextInt();
            if( opcion == 1 ){
                System.out.print("Digite el monto a depositar: ");
                try{
                    actual.depositar( s.nextFloat() );
                }catch(Exception ex){
                    System.out.println( ex.getMessage() );
                }
            }
            if( opcion == 2 ){
                System.out.print("Digite el monto a retirar: ");
                try{
                    actual.retirar( s.nextFloat() );
                }catch(Exception ex){
                    System.out.println( ex.getMessage() );
                }
            }
            if( opcion == 3 ) System.out.println("Saldo Actual: "+actual.getSaldo());
            if( opcion == 4 ){
                //seleccionar cuenta de ahorro
                System.out.println("*************************");
                System.out.println("\t1) "+c1.numeroCuenta);
                System.out.println("\t2) "+c2.numeroCuenta);
                System.out.println("\t3) "+c3.numeroCuenta);
                System.out.print("Digite el numero del item de la cuenta deseada: ");
                int seleccion = s.nextInt();
                if( seleccion == 1 ) actual = c1;
                if( seleccion == 2 ) actual = c2;
                if( seleccion == 3 ) actual = c3;
                if( seleccion < 1 || seleccion > 3 ) System.out.println("Cuenta no valida.");
            }
            if( opcion == 5 ) System.out.println("Retire su tarjeta, hasta luego.");
        }while(opcion != 5);
        
    }
}
