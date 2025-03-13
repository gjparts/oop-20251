package com.mycompany._polimorfismo2;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class Document extends File {
    //attributes
    public Author author;
    public Calendar modificationDate;
    public int words;
    //constructor
    public Document(Author author, Calendar modificationDate,
            int words, String name, long size,
            String extension, Calendar creationDate) {
        super(name, size, "Document File", extension, creationDate);
        this.author = author;
        this.modificationDate = modificationDate;
        this.words = words;
    }
    //metodos
    @Override
    public void print(){
        super.print(); //Override parcial
        //Author tiene relacion por agregacion, es publico asi que solo si
        //es distinto de null se va a imprimir
        if( this.author != null )
            System.out.println("Author: "+this.author.name);
        //la fecha de modificion puede llegar a ser null ya que es public y
        //es un objeto, solo se imprime si no es null
        if( this.modificationDate != null ){
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println("Modification date: "+f.format(this.modificationDate.getTime()));
        }
        System.out.println("Words: "+this.words);
    }
}
