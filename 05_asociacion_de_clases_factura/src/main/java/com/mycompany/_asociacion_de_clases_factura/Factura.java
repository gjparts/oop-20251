package com.mycompany._asociacion_de_clases_factura;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
public class Factura {
    //atributos
    public int numero;
    public Calendar fecha;
    public Cliente cliente;
    private Producto producto1;
    public Producto producto2;
    public Producto producto3;
    public Producto producto4;
    //constructor
    public Factura(int numero, Calendar fecha, Cliente cliente, Producto producto1) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.setProducto1(producto1);
    }
    //metodos
    //a producto1 lo podemos cambiar en cualquier momento
    //por eso le haremos un metodo set, aparte que no puede ser null
    public void setProducto1(Producto producto1) {
        if( producto1 == null )
            throw new IllegalArgumentException("producto1 no puede ser null");
        else
            this.producto1 = producto1; //se acepta
    }
    public Producto getProducto1() {
        return this.producto1;
    }
    public Producto getProducto2() {
        return this.producto2;
    }
    public Producto getProducto3() {
        return this.producto3;
    }
    public Producto getProducto4() {
        return this.producto4;
    }
    public void imprimir(){
        System.out.println("*** Factura ***");
        System.out.println("Numero: "+this.numero);
        //aunque en el diagrama no lo mencionan; pero la fecha
        //al ser public puede venir null y un objeto Calendar
        //que es null no se puede leer
        //por lo tanto deberiamos validar que si fecha es null
        //no la imprimimos
        if( this.fecha != null ){
            System.out.print("Fecha: ");
            SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
            System.out.println(formato.format(this.fecha.getTime()));
        }
        //si cliente es null entonces se imprime consumidor final y no va rtn
        if( this.cliente == null )
            System.out.println("Cliente: Consumidor Final");
        else{
            System.out.println("Cliente: "+this.cliente.nombre);
            System.out.println("RTN: "+this.cliente.rtn);
        }
        //suma de los productos de la factura, ignorarmos los que son
        //null; excepto producto1 que ese siempre viene lleno
        float subtotal = 0;
        System.out.println("Producto\tPrecio");
        System.out.println(this.producto1.nombre+"\t"+this.producto1.precioVenta);
        subtotal += this.producto1.precioVenta;
        //productos del 2 al 4 pueden llegar a estar null
        if( this.producto2 != null ){
            System.out.println(this.producto2.nombre+"\t"+this.producto2.precioVenta);
            subtotal += this.producto2.precioVenta;
        }
        if( this.producto3 != null ){
            System.out.println(this.producto3.nombre+"\t"+this.producto3.precioVenta);
            subtotal += this.producto3.precioVenta;
        }
        if( this.producto4 != null ){
            System.out.println(this.producto4.nombre+"\t"+this.producto4.precioVenta);
            subtotal += this.producto4.precioVenta;
        }
        //resultados
        DecimalFormat f = new DecimalFormat();
        f.setMaximumFractionDigits(2);
        f.setMinimumFractionDigits(2);
        
        System.out.println("Subtotal: "+f.format(subtotal) );
        System.out.println("ISV 15%: "+f.format(subtotal*0.15) );
        System.out.println("Total: "+f.format(subtotal*1.15) );
    }
}

