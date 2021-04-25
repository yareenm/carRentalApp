/*
Client.java        Author: Yaren Menemencioğlu ID:21895484
                E-mail: 21895484@mail.baskent.edu.tr

This class is made for users' attributes. It has functions for reach to the attributes or change the attributes' values. It defines user's ID, the number of times that
this client has rented a car, the rental and return locations, and total price for all it's rental.
*/
import java.awt.List;


public class Client {
    private String clientID;
    private int counter;
    private double total_money;
    private String[] location;
        
    
    public Client(){
    counter=0;
    clientID="";
    total_money=0.000;
    location=new String[30];
    }
    
    public Client(int counter, String clientID,double total_Money,String[] location){
    
    this.counter=counter;
    this.clientID=clientID;
    this.total_money=total_Money;
    this.location=location;
    
    }
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double price) {
        this.total_money = price;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String location, int index) {
        this.location[index] = location;
    }

    
}
