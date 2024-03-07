package org.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {
    public void writeIntoFile(String filename, String employeeDetails) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
        byte[] data = employeeDetails.getBytes();
        fileOutputStream.write(data);
    }

    public String readFromFile(String filename) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        return new String(data);
    }
}

