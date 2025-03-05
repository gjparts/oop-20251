package com.mycompany._herencia2;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class File {
    //atributes
    public String name;
    public long size;
    private String type; //MIME type
    public String extension;
    public Calendar creationDate;
    //constructor
    public File(String name, long size, String type,
                String extension, Calendar creationDate) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.extension = extension;
        this.creationDate = creationDate;
    }
    //methods
    public String getType() {
        return this.type;
    }
    public void print(){
        System.out.println("******* FILE *******");
        System.out.println("Name: "+this.name);
        System.out.println("Size: (bytes) "+this.size);
        System.out.println("Type: "+this.type);
        System.out.println("Extension: "+this.extension);
        if( this.creationDate != null ){
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            System.out.println("Creation date: "+f.format(this.creationDate.getTime()));
        }
    }
}
