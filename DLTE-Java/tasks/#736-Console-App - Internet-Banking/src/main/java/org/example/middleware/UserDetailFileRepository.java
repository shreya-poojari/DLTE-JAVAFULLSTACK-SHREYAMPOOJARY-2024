package org.example.middleware;

import org.example.entity.userDetails;
import org.example.exceptions.UserDetailException;
import  org.example.remotes.UserDetailRepository;

import java.io.*;
import java.util.*;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class UserDetailFileRepository implements UserDetailRepository{

    private String filePath;
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("Userdetails");
    private Logger logger=Logger.getLogger(UserDetailFileRepository.class.getName());
    private List<userDetails> userDetailsList;
    private static Scanner scanner=new Scanner(System.in);

    public  UserDetailFileRepository(String url){
        filePath=url;
        userDetailsList = new ArrayList<>();
        try{
            File file = new File(filePath);
            if (!file.exists()){
                file.createNewFile();
            }
            FileHandler fileHandler=new FileHandler("credit-card-logs.txt",true);
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    private void writeIntoFile() {
        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(filePath)))
        {
         objectOutputStream.writeObject(userDetailsList);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void readFromFile(){
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(filePath))){
            userDetailsList=(List<userDetails>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public void addUsers() {
        readFromFile();
        userDetailsList.add(new userDetails("shreya","shreya@123",new Date(2002,12,25),"moodbidri","shreya@gmail.com",8765432345L));
        userDetailsList.add(new userDetails("sinchana","sinchana@123",new Date(2002,8,5),"mulki","sinchana@gmail.com",9876545678L));
        userDetailsList.add(new userDetails("annapoorna","annapoorna@123",new Date(2002,7,6),"karkala","annapoorna@gmail.com",4567898765L));
        userDetailsList.add(new userDetails("swati","swati@123",new Date(2002,2,15),"udupi","swati@gmail.com",7765789765L));
        userDetailsList.add(new userDetails("snehal","snehal@123",new Date(2002,11,20),"padubidri","snehal@gmail.com",5478523698L));
        userDetailsList.add(new userDetails("kavya","kavya@123",new Date(2002,7,15),"biloor","kavya@gmail.com",5478523698L));
        writeIntoFile();
    }

    @Override
    public void save(userDetails UserDetail) {
        readFromFile();
        if (userDetailsList.stream().anyMatch(u-> u.getUserName().equals(UserDetail.getUserName()))){
       // userDetails object=userDetailsList.stream().filter(each->each.getUserName().equals(UserDetail.getUserName())).findFirst().orElse(null);
        //if (object!=null){
            logger.log(Level.WARNING,UserDetail.getUserName()+resourceBundle.getString("details.exists"));
            throw new UserDetailException(resourceBundle.getString("details.exists"));
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

    @Override
    public Object verifyPassword(String username, String password) {
        readFromFile();
        userDetails account=userDetailsList.stream().filter(each->each.getUserName().equals(username)).findFirst().orElse(null);
        try{
            if (account==null){
                System.out.println(resourceBundle.getString("username.not.found"));
                logger.log(Level.WARNING,resourceBundle.getString("username.not.found"));
                return null;
            }else if (!account.getPassword().equals(password)){
                logger.log(Level.WARNING, resourceBundle.getString("password.not.matched"));
                System.out.println(resourceBundle.getString("password.not.matched"));
                throw new UserDetailException();
            }else
                return account;
        }catch(UserDetailException userDatailException){
            for (int attempts=2;attempts<=3;){
                System.out.println(resourceBundle.getString("login.fail")+" Only "+(3-attempts+1)+" attempts left");
                logger.log(Level.WARNING,resourceBundle.getString("login.fail"));
                System.out.println(userDatailException);
                String pass=scanner.next();
                if (account.getPassword().equals(pass)){
                    System.out.println(resourceBundle.getString("login.success"));
                    logger.log(Level.INFO,resourceBundle.getString("login.success"));
                    return account;
                }else {
                    attempts++;
                }if (attempts>3){
                    System.out.println(resourceBundle.getString("accounts.no.more.attempts"));
                    logger.log(Level.WARNING,resourceBundle.getString("accounts.no.more.attempts"));
                }
            }
        }
        return null;
    }

    @Override
    public List<userDetails> getAllUserDetails() {
        readFromFile();
        return new ArrayList<>(userDetailsList);
    }
}

