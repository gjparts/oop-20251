package com.mycompany._asociacion_de_clases_factura;
public class Producto {
    //atributos
    public String nombre;
    public CategoriaProducto categoria;
    public float precioVenta;
    //constructor
    public Producto(String nombre, CategoriaProducto categoria, float precioVenta) {
        //la categoria no puede ser null
        if( categoria == null )
            throw new IllegalArgumentException("Categoria de producto no puede ser null");
        else
            this.categoria = categoria; //se acepta
        
        this.nombre = nombre;
        this.precioVenta = precioVenta;
    }
    //metodos
    public CategoriaProducto getCategoria() {
        return this.categoria;
    }
}
