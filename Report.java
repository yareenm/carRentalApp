/*
Report.java               Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class is used for display the user's informations with the input(ID) taken from the user. It opens another form on the application which it shows that user ID's information.
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Report extends JFrame{
    private JLabel client_IDL, carL;
    private JTextField idTf,carTf;
    private JButton idB,carB;

    public Report(Client[] c, HighPriceCars[] hpc, MidPriceCars[] mpc, LowPriceCars[] lpc){
    this.setSize(200,300);
    this.setLocation(500,200);
    client_IDL =new JLabel("Enter Client ID:");
    carL=new JLabel("Enter Car Plate:");
    idTf=new JTextField(15);    
    carTf=new JTextField(15);
    
    idB=new JButton("Client Info");
    carB=new JButton("Car Info");
    
    Container contain = getContentPane();
    contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
    contain.add(client_IDL);
    contain.add(idTf);
    contain.add(idB);
    contain.add(carL);
    contain.add(carTf);
    contain.add(carB);

    idB.addActionListener(
        new ActionListener() {// first anonymous class
        public void actionPerformed(ActionEvent e) throws MyException {
            if(e.getSource() == idB){
                String id=idTf.getText();
                if(id == ""){
                throw new MyException();
                }
                Client_Info client_form= new Client_Info(c,id);
                client_form.show();
            }  
        } 
    }
   );
    carB.addActionListener(
        new ActionListener() {//second anonymous class
        public void actionPerformed(ActionEvent e) throws MyException {
            if(e.getSource() == carB){
                String car_plate=carTf.getText();
                if(car_plate == ""){
                throw new MyException();
                }
                Car_Info car_form= new Car_Info(hpc,mpc,lpc,car_plate);
                car_form.show();
            }  
        } 
    }
   );
  }//constructor
    
}//report class