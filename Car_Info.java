/*
Car_Info.java        Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class shows relevant car's information. It finds the correct plate from the array and then set its informations to the text field.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Car_Info extends JFrame{
    private JLabel countL;
    private JTextField countTf;
    private int i,counter=0;
    
     public Car_Info(HighPriceCars[] hpc, MidPriceCars[] mpc, LowPriceCars[] lpc, String car_plate){
        this.setSize(400,300);
        this.setLocation(500,300); 
        countL=new JLabel("Number of times:");
        countTf=new JTextField(30);
        countTf.setEditable(false);
        Container contain = getContentPane();
        contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
        contain.add(countL);
        contain.add(countTf);
        
       if(hpc[0].getPlate() != ""){
        for(i=0;i<hpc.length-1 ;i++){
            try{
            if(car_plate.equals(hpc[i].getPlate())){
               counter++;
            }//if
            }
            catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"No existance!","Error",JOptionPane.ERROR_MESSAGE);        
            }
 
        }//search the car's plate in high price cars 
       }
       if(mpc[0].getPlate() != ""){
        for(i=0;i<mpc.length-1 ;i++){
            try{
            if(car_plate.equals(mpc[i].getPlate())){
            counter++;
            }//if
            }
            catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"No existance!","Error",JOptionPane.ERROR_MESSAGE);        
            }
 
        }//search the car's plate in mid price cars
       }
       if(lpc[0].getPlate() != ""){
        for(i=0;i<lpc.length-1 ;i++){
            try{
            if(car_plate.equals(lpc[i].getPlate())){
            counter++;
            }//if
            }
            catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"No existance!","Error",JOptionPane.ERROR_MESSAGE);        
            }
            
        }//search the car's plate in low price cars
       }
       countTf.setText(String.valueOf(counter)); // then set the total number of rental of that relevant car.
     }
    
}
