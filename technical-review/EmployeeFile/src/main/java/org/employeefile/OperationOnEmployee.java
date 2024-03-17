package org.employeefile;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class OperationOnEmployee {
    static File myfile= new File("employee.doc");

    public OperationOnEmployee() throws IOException {
//        System.out.println("inside constructor");
        if (myfile.exists()){
            System.out.println("File present");
        }
        else
            System.out.println("file absent");
    }
    public void writeIntoFile(ArrayList<Object> employee){
        readFromFile();
//        System.out.println("Inside write");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            System.out.println("file written");
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException expection){
            System.out.println(expection);
        }
    }
    public ArrayList<Objects> readFromFile(){
        try{
            //Employee employee=new Employee();
//           System.out.println("inside read");
            ArrayList<Objects> employeeArray=new ArrayList<>();
            FileInputStream fileInputStream=new FileInputStream(myfile);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            employeeArray.addAll((ArrayList<Objects>) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
            return employeeArray;
        }
        catch (IOException | ClassNotFoundException  ioException){
            System.out.println(ioException);
        }
        return null;
    }
}
