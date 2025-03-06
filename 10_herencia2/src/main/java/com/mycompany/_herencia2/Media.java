package com.mycompany._herencia2;

import java.util.Calendar;
public class Media extends File {
    //atributes
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
}
