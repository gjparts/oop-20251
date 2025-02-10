package com.mycompany._calendar;

import java.util.Calendar;
import java.text.SimpleDateFormat;
public class App {

    public static void main(String[] args) {
        /*Clase Calendar: es una clase abstracta y por lo tanto
        no se puede instanciar de forma convencional.
        Calendar ofrece el metodo getInstance() para poder
        crear un objeto de clase Calendar basado en la
        fecha/hora y calendario de la computadora donde se
        ejecuta el programa.*/
        Calendar f1 = Calendar.getInstance();
        //imprimir la fecha que hay en f1:
        System.out.println(f1.getTime());
        //lo anterior imprime la fecha en el formato configurado
        //para JAVA en el equipo actual
        //puede extraer partes de la fecha:
        System.out.println("Año de f1: "+f1.get( Calendar.YEAR ));
        //en JAVA cuando se extrae el mes de un Calendar por medio
        //de get, devuelve 0 para enero y 11 para diciembre.
        System.out.println("Mes de f1: "+f1.get( Calendar.MONTH ));
        System.out.println("Dia del mes de f1: "+f1.get( Calendar.DATE ));
        System.out.println("Dia de la semana de f1: "+f1.get( Calendar.DAY_OF_WEEK ));
        System.out.println("Hora de f1: "+f1.get( Calendar.HOUR ));
        System.out.println("Minuto de f1: "+f1.get( Calendar.MINUTE ));
        System.out.println("Segundo de f1: "+f1.get( Calendar.SECOND ));
        /*Puede usar un formateador para presentar la fecha usando
        una mascara lo que facilita mas imprimir fechas. La mascara de entrada
        la puede formar usando los siguientes caracteres:
        YYYY    año a 4 digitos
        YY      año en 2 digitos
        MM      mes a 2 digitos
        M       mes sin formato
        MMM     nombre del mes abreviado
        MMMM    nombre del mes completo
        dd      dia a 2 digitos
        d       dia sin formato
        HH      hora a 2 digitos en formato 24 horas
        hh      hora a 2 digitos en formato 12 horas
        mm      minuto a 2 digitos
        ss      segundo a 2 digitos
        aa      indicador de meridiano AM/PM
        */
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        System.out.println( formato.format( f1.getTime() ) );
        //podemos crear Calendar con fecha y hora fijas
        Calendar f2 = Calendar.getInstance();
        f2.set(1982,9,15,7,33,0);
        System.out.println("f2: "+formato.format(f2.getTime()));
        //puede modificar solo un elemento de una fecha por medio de set
        //poner el segundo de f2 con el valor 45
        f2.set( Calendar.SECOND, 45);
        System.out.println("f2: "+formato.format(f2.getTime()));
        //operaciones aritmeticas con fechas
        //sumar 42 años a f2
        f2.add( Calendar.YEAR , 42);
        System.out.println("f2: "+formato.format(f2.getTime()));
        //restar 30 minutos a f2
        f2.add( Calendar.MINUTE, -30);
        System.out.println("f2: "+formato.format(f2.getTime()));
    }
}
