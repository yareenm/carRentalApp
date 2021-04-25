/*
Client_Info.java          Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class shows client's information. It finds the correct ID from the array and then set its informations to the text fields, and areas.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client_Info extends JFrame {
    private JLabel moneyL,locationL,countL;
    private JTextField moneyTf,countTf;
    private JTextArea locationArea;
    private String[] loc_Arr;
    
    public Client_Info(Client[] c, String id){
        this.setSize(400,300);
        this.setLocation(500,300); 
        moneyL=new JLabel("Total money:");
        locationL=new JLabel("Locations:");
        countL=new JLabel("Number of times:");
        
       moneyTf=new JTextField(15);
       moneyTf.setEditable(false);
       locationArea=new JTextArea(25,15);
       locationArea.setEditable(false);
       countTf=new JTextField(15);
       countTf.setEditable(false);
       
        Container contain = getContentPane();
        contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
       
        contain.add(moneyL);
        contain.add(moneyTf);
         contain.add(locationL);
        contain.add(locationArea);
         
        contain.add(countL);
        contain.add(countTf);
        
        int i ;
        for(i=0;i<c.length ;i++){
            try{
            this.loc_Arr=c[i].getLocation();
            if(id.equals(c[i].getClientID())){
            moneyTf.setText(String.valueOf(c[i].getTotal_money()));
            countTf.setText(String.valueOf(c[i].getCounter()));
                for(int j=0;loc_Arr[j] != null ;j++){
                locationArea.append(loc_Arr[j]);
                locationArea.append("\n");
                }//print the all the locations. Because of the return and rental locations are equal, I used one location.
            }//if
            }
            catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null,"Null Pointer!","Error",JOptionPane.ERROR_MESSAGE);        
            }
 
        }// search for the relevant client ID in the client array
    }
}
