package org.example.entities;

import java.util.Date;

public class ticket {
   private String ticketID;
   private String userID;
   private String source;
   private String destination;
   private Date dateofTravel;
   private Train train;

   public String getTicketID() {
      return ticketID;
   }

   public void setTicketID(String ticketID) {
      this.ticketID = ticketID;
   }

   public ticket(String ticketID, String userID, String source, String destination, Date dateofTravel, Train train) {
      this.ticketID = ticketID;
      this.userID = userID;
      this.source = source;
      this.destination = destination;
      this.dateofTravel = dateofTravel;
      this.train = train;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String getSource() {
      return source;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public String getDestination() {
      return destination;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }

   public Date getDateofTravel() {
      return dateofTravel;
   }

   public void setDateofTravel(Date dateofTravel) {
      this.dateofTravel = dateofTravel;
   }

   public Train getTrain() {
      return train;
   }

   public void setTrain(Train train) {
      this.train = train;
   }
}