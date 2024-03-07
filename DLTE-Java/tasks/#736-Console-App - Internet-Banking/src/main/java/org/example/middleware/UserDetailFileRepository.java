package org.example.middleware;

import org.example.entity.userDetails;
import org.example.exceptions.UserDetailException;
import  org.example.remotes.UserDetailRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class UserDetailFileRepository implements UserDetailRepository{

    private String filePath;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("userdetails");
    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private List<userDetails> userDetailsList=new ArrayList<>();
    public  UserDetailFileRepository(String url){
        filePath=url;
        try{
            FileHandler fileHandler=new FileHandler("credit-card-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }catch (IOException ioException){}
    }
    private void writeIntoFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(userDetailsList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioException) {
        }
    }
    private void readFromFile(){
        try{
            FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            userDetailsList=(List<userDetails>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException | ClassNotFoundException ioException){}
    }

    @Override
    public void save(userDetails UserDetail) {
        readFromFile();
        userDetails object=userDetailsList.stream().filter(each->each.getUserName().equals(UserDetail.getUserName())).findFirst().orElse(null);
        if (object!=null){
            logger.log(Level.WARNING,UserDetail.getUserName()+resourceBundle.getString("details.exists"));
            throw new UserDetailException();
        }
        userDetailsList.add(UserDetail);
        writeIntoFile();
        logger.log(Level.INFO,UserDetail.getUserName()+resourceBundle.getString("details.saved"));
        System.out.println(UserDetail.getUserName()+resourceBundle.getString("details.saved"));
    }

    @Override
    public void update(userDetails UserDetail) {
     readFromFile();
     userDetails matched=userDetailsList.stream().filter(each->each.getUserName().equals(UserDetail.getUserName())).findFirst().orElse(null);
     if (matched == null){
         logger.log(Level.WARNING,UserDetail.getUserName()+resourceBundle.getString("details.notExists"));
         throw new UserDetailException(resourceBundle.getString("details.noMatches"));
     }
     int index=userDetailsList.indexOf(matched);
     userDetailsList.set(index,UserDetail);
     writeIntoFile();
     logger.log(Level.FINE,resourceBundle.getString("details.update.ok"));
        System.out.println(resourceBundle.getString("details.update.ok"));
    }
}
