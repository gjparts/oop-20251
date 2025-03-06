package com.mycompany._herencia2;
import java.util.Calendar;
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
    
}
