/*
Test.java                 Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class is an application class which contains main function. It's for create a reference for the RentalGUI class which is the main form of our application. 
*/
import javax.swing.*;


public class Test {
    
    public static void main(String [] args){
        try{
        RentalGUI gui= new RentalGUI();
        gui.setSize(200,250); 
        gui.setTitle("Car Rental Application");
        gui.setVisible(true);
        gui.setLocation(800,300);   
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception exp){
        exp.getStackTrace();
        } // In case of an any exception happens.
    
      }
}
