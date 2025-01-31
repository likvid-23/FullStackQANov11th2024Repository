package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialisationDemo
{
    public static void main(String[] args) {
        readObjectfromFile();
    }
     private static void readObjectfromFile()
     {
         FileInputStream fin=null;
         ObjectInputStream in=null;
         Student obj1=null;
         try {
             fin=new FileInputStream("D:\\Serialization Files\\Student.ser");
             in=new ObjectInputStream(fin);
           obj1=  (Student) in.readObject();
           obj1.showRollNo();
           obj1.showFirstName();
           obj1.showLastName();
         } catch (Exception e) {
             e.printStackTrace();
         }
         finally {
             try
             {
                 fin.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
}
