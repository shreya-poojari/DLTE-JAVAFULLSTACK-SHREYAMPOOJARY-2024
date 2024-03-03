package org.example;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBankDatabase<T> implements Activity<T> {
    T[] bankDataBase;

    @Override
    public String createNewData(T object) {
        int size = bankDataBase.length;
        for (int index = 0; index < size; index++)
            if (bankDataBase[index] == null) {
                bankDataBase[index] = object;
                return "credit card has been added";
            }
        throw new BankException();
    }

    @Override
    public T readData(int position) {
        int size = bankDataBase.length;
        if (position >= 0 && position < size) {
            return bankDataBase[position];
        }
        return null;
    }

    @Override
    public void updateData(int position, T object) {
        int size = bankDataBase.length;
        if (position >= 0 && position < size) {
            bankDataBase[position] = object;
            return;
        }
    }

    @Override
    String deletedata(int position) {
        int size = bankDataBase.length;
        Object obj = null;
        if (position >= 0 && position < size) {
            obj = bankDataBase[position];
            bankDataBase[position] = null;
            return obj + " deleted";
        }
        throw new BankException();
    }
}