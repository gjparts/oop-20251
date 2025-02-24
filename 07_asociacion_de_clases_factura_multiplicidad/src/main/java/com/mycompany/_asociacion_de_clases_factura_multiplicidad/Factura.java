package com.mycompany._asociacion_de_clases_factura_multiplicidad;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
public class Factura {
    //atributos
    public int numero;
    public Calendar fecha;
    public Cliente cliente;
    private Producto[] productos; //multiplicidad: eliminar los grupos repetitivos

    //constructor
    public Factura(int numero, Calendar fecha, Cliente cliente, Producto[] productos) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.setProductos(productos);
    }
    //metodos
    public void setProductos(Producto[] productos){
        //el diagrama dice que al menos debe haber un producto en el arreglo
        //de productos
        //primer nos aseguramos que el arreglo no venga null
        if( productos == null )
            throw new IllegalArgumentException("Arreglo de productos no debe ser null");
        else{
            //debe de venir al menos un producto
            if( productos.length == 0 )
                throw new IllegalArgumentException("Arreglo de productos debe tener al menos un producto.");
            else{
                //el primer elemento del arreglo no debe de ser null
                if( productos[0] == null )
                    throw new IllegalArgumentException("Primer producto no puede ser null");
                else
                    this.productos = productos; //se acepta el arreglo
            }
        }
    }
    public Producto[] getProductos() {
        return this.productos;
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
        //recorrer la coleccion de Productos
        for( int i = 0; i < productos.length; i++ ){
            //si el i-esimo Producto es null lo ignoramos
            if( this.productos[i] != null ){
                System.out.println( this.productos[i].nombre+"\t"+this.productos[i].precioVenta );
                subtotal += this.productos[i].precioVenta;
            }
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

