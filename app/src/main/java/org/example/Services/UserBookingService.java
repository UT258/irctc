package org.example.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;
import org.example.entities.ticket;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private static final String UserPath="users.json ";
    //now to deserialize the user we use object mapper
    ObjectMapper objectMapper = new ObjectMapper();
    private List<User> userList;
    public UserBookingService( User user) throws IOException
    {
        this.user=user;
       try {
           File file= new File(UserPath);//create file with the user.json path
       }
       catch (Exception e)
       {
              System.out.println("error in file creation");
       }
        loaduser();
         //read the file and store it in the list
    }
    public UserBookingService() throws IOException {
        loaduser();
    }
    public void loaduser()throws IOException {
               File file = new File(UserPath);

        if (!file.exists()) {
            System.out.println("User file not found, creating new list.");
            userList = new ArrayList<>();
            return;
        }

        try {
            userList = objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
            userList = new ArrayList<>();
        }


    }
    public  boolean login(){
        Optional<User> userOptional= userList.stream().filter(user1 -> user1.getName().equals(user.getName())).findFirst();
        //check if the user is present in the list
        if(userOptional.isPresent())
        {
            User user1=userOptional.get();
            return user1.getHashedPassword().equalsIgnoreCase(user.getHashedPassword());
        }
        return false;
    }
    public Boolean register(User user) {
        userList.add(user);
        try {
            objectMapper.writeValue(new File(UserPath), userList);
            return true;
        } catch (IOException e) {

           return false;
        }
    }
    public void fethBooking(){
        List<ticket> ticket=user.getTicketsBooked();
        for(ticket ticket1:ticket)
        {
            System.out.println(ticket1.getTrain().getTrainName());
        }


    }
    public  void cancelTicket(ticket ticket) {
        user.getTicketsBooked().remove(ticket);
        try {
            objectMapper.writeValue(new File(UserPath), userList);
        } catch (IOException e) {
            System.out.println("error in writing to file");
        }
    }
    public  void bookticket(ticket ticket)
    {
        user.getTicketsBooked().add(ticket);
        try {
            objectMapper.writeValue(new File(UserPath), userList);
        } catch (IOException e) {
            System.out.println("error in writing to file");
        }
    }
}
