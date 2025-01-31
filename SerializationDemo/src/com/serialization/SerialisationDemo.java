package com.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialisationDemo {
    public static void main(String[] args) {
        serialisationDemo();

    }
    private static void serialisationDemo()
    {
        FileOutputStream fout=null;
        ObjectOutputStream out=null;
        Student obj=null;
        try {
            fout = new FileOutputStream("D:\\Serialization Files\\Student.ser");
            out = new ObjectOutputStream(fout);
            obj=new Student(11,"Likith","Bhushan");
            out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
