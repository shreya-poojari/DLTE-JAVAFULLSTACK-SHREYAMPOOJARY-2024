package org.example;

public class Activity<T> {
    String createNewData(T object);
    T readData(int accNumber);
    void updateData(int index,T object);
    String deletedata(int index);
}
