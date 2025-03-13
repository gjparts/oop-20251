package com.mycompany._polimorfismo2;

import java.util.Calendar;
public class Media extends File {
    //attributes
    public Author author;
    public int duration;
    //constructor
    public Media(Author author, int duration, String name,
            long size, String extension,
            Calendar creationDate) {
        //construir la super clase
        super(name, size, "Media File", extension, creationDate);
        this.author = author;
        this.duration = duration;
    } 
    //methods
    @Override
    public void print() {
        super.print(); //Override parcial
        //nuevas instrucciones
        if( this.author != null )
            System.out.println("Author: "+this.author.name);
        System.out.println("Duration: "+this.duration+" seconds.");
    }
    
}
