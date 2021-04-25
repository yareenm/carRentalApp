/*
Reservation.java          Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class is designed for rental reservation. It initializes some attributes such as user's ID, total money for paid or the number of times car/user rental a car, etc.
It has combo box, radio buttons, check box and other JFrame features. It checks the ID first, find the index of it, and then initializes the relevant client's information.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reservation extends JFrame{
    private JLabel location1L,location2L,free_ChargedL,price_ChargedL,idL,total_priceL,car_plateL,daysL;
    private JTextField location1Tf,location2Tf,idTf,total_priceTf,car_plateTf,daysTf;
    private JButton okB;
    private JPanel panel1,panel2;
    private JComboBox<String> combo = new JComboBox<>(new String[] {"Low Priced Cars" ,"Medium Priced Cars" , "High Priced Cars"});
    private JRadioButton checkf1, checkf2 ,checkf3 ,checkf4 ,checkf5 ,checkf6 ;
    private JCheckBox checkp1,checkp2,checkp3,checkp4;     
    private Client[] c;
    private int count=0,index=0,counterL=0,counterM=0,counterH=0,counter=0;
    private HighPriceCars[] hpc;
    private MidPriceCars[] mpc;
    private LowPriceCars[] lpc;
    
    
    public Reservation(Client[] c, HighPriceCars[] hpc, MidPriceCars[] mpc, LowPriceCars[] lpc){
    this.setSize(700,500);
    this.setLocation(500,200);
    okB= new JButton("MAKE THE RENTAL");
    location1L=new JLabel("Enter the location:");
    location2L =new JLabel("Return Location:");
    location1Tf = new JTextField(15);
    location2Tf=new JTextField(15);
    location2Tf.setEditable(false);
    idL=new JLabel("Enter ID:");
    idTf=new JTextField(15); 
    total_priceL=new JLabel("Total Price:");
    total_priceTf=new JTextField(15);
    total_priceTf.setEditable(false);
    car_plateL=new JLabel("Car Plate:");
    car_plateTf=new JTextField(15);
    car_plateTf.setEditable(false);
    daysL=new JLabel("How many days?(+25$ per day):");
    daysTf=new JTextField(15);
    
    setC(c);
    this.lpc=lpc;
    this.mpc=mpc;
    this.hpc=hpc;
    
    panel1 = new JPanel();
    panel2 = new JPanel();
    
    free_ChargedL=new JLabel("Free Choices");
    checkf1 = new JRadioButton("Auto Car");
    checkf2 = new JRadioButton("Manuel Car");  
    checkf3 = new JRadioButton("Smoker Car");  
    checkf4 = new JRadioButton("Non-Smoker Car");  
    checkf5 = new JRadioButton("2 Doors Car");
    checkf6 = new JRadioButton("4 Doors Car");
    
    ButtonGroup group = new ButtonGroup();
    group.add(checkf1);group.add(checkf2);
    ButtonGroup group1 = new ButtonGroup();
    group1.add(checkf3);group1.add(checkf4);
    ButtonGroup group2 = new ButtonGroup();
    group2.add(checkf5);group2.add(checkf6);
    
    price_ChargedL=new JLabel("Charges Extras");
    checkp1=new JCheckBox("Roof Rack +10$");
    checkp2=new JCheckBox("Trailer +10$");
    checkp3=new JCheckBox("Snow Chains +10$");
    checkp4=new JCheckBox("Child Seat +10$");
    combo.setName("Models Of Cars");
    panel1.add(checkf1);panel1.add(checkf2);panel1.add(checkf3);panel1.add(checkf4);panel1.add(checkf5);panel1.add(checkf6);
    panel2.add(checkp1);panel2.add(checkp2);panel2.add(checkp3);panel2.add(checkp4);
    
    Container contain = getContentPane();
    contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
    contain.add(location1L);
    contain.add(location1Tf);
    contain.add(location2L);
    contain.add(location2Tf);
    contain.add(combo);
    contain.add(idL);
    contain.add(idTf);
    contain.add(free_ChargedL);
    contain.add(panel1);
    contain.add(price_ChargedL);
    contain.add(panel2);
    contain.add(daysL);
    contain.add(daysTf);
    contain.add(okB);
    contain.add(total_priceL);
    contain.add(total_priceTf);
    contain.add(car_plateL);
    contain.add(car_plateTf);
    
    
    MyItemListener mil=new MyItemListener();
    checkp1.addItemListener(mil);
    checkp2.addItemListener(mil);
    checkp3.addItemListener(mil);
    checkp4.addItemListener(mil);
    MyEventHandler meh = new MyEventHandler();
    okB.addActionListener(meh);
    }//default constructor
    
    public class MyItemListener implements ItemListener{ 
    public void itemStateChanged(ItemEvent e) { //first inner class
    Object source = e.getItemSelectable();
    
        if (e.getStateChange() == ItemEvent.SELECTED){
        count++;
        }// calculate the exact number of extra charged features.
    }
}

   public class MyEventHandler implements ActionListener{ 
    public void actionPerformed(ActionEvent ae){ //second inner class
    
    if(ae.getSource() == okB){
       location2Tf.setText(String.valueOf(location1Tf.getText()));
       int num_Days=Integer.parseInt(daysTf.getText());
       int i = combo.getSelectedIndex(); //getting selected index to find out the car type that user wants.
       
       if(0==i){
       lpc[counterL].setPrice();
       lpc[counterL].setPlate();  
       counter++;
       if(counter-1==0){ // base case
       double money= lpc[counterL].getPrice() + (count *10) + (25*num_Days) ;
       try{
       c[0].setLocation(location1Tf.getText(), 0);
       c[0] = new Client(c[0].getCounter()+1,idTf.getText(),c[0].getTotal_money()+money,c[0].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(c[0].getTotal_money()));
       lpc[counterL].setCount(1);
       counterL++;
       index++;
       }
       else{
       double money= lpc[counterL].getPrice() + (count *10) + (25*num_Days);
       if(idTf.getText() ==""){
       throw new MyException();
       }
       index=check_ID(idTf.getText(),c); //In case same client makes a reservation, check the client's ID with the previous ones.
       try{
       c[index] = new Client(c[index].getCounter()+1,idTf.getText(),c[index].getTotal_money()+money,c[index].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(money));
       lpc[counterL].setCount(lpc[counterL].getCount()+1);
       counterL++;
       }//else
       car_plateTf.setText(String.valueOf(lpc[counterL-1].getPlate()));
       }//If index=0, then it's a low price car.
       else if(i==1){
       counter++;
       mpc[counterM].setPlate();  
       mpc[counterM].setPrice();
       if(counter-1==0){ // base case
       double money= mpc[counterM].getPrice() + (count *10) + (25*num_Days);
       try{
       c[0].setLocation(location1Tf.getText(), 0);
       c[0] = new Client(c[0].getCounter()+1,idTf.getText(),c[0].getTotal_money()+money,c[0].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(c[0].getTotal_money()));
       mpc[counterM].setCount(1);
       index++;
       counterM++;
       }
       else{
       double money= mpc[counterM].getPrice() + (count *10) + (25*num_Days);
       if(idTf.getText() ==""){
       throw new MyException();
       }
       index=check_ID(idTf.getText(),c); //In case same client makes a reservation, check the client's ID with the previous ones.
       try{
       c[index] = new Client(c[index].getCounter()+1,idTf.getText(),c[index].getTotal_money()+money,c[index].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(money));
       mpc[counterM].setCount(mpc[counterM].getCount()+1);
       counterM++;
       }//else
       car_plateTf.setText(String.valueOf(mpc[counterM-1].getPlate()));
        }//If index=1, then it's a medium price car.
       else{
       counter++;
       hpc[counterH].setPlate();  
       hpc[counterH].setPrice();
       if(counter-1==0){ // base case
       double money= hpc[counterH].getPrice() + (count *10) + (25*num_Days) ;
       try{
       c[0].setLocation(location1Tf.getText(), 0);
       c[0] = new Client(c[0].getCounter()+1,idTf.getText(),c[0].getTotal_money()+money,c[0].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(c[0].getTotal_money()));
       hpc[counterH].setCount(1);
       index++;
       counterH++;
       }
       else{
       double money= hpc[counterH].getPrice() + (count *10) + (25*num_Days);
       if(idTf.getText() ==""){
       throw new MyException();
       }
       index=check_ID(idTf.getText(),c); //In case same client makes a reservation, check the client's ID with the previous ones.
       try{
       c[index] = new Client(c[index].getCounter()+1,idTf.getText(),c[index].getTotal_money()+money,c[index].getLocation());
       }
       catch(NullPointerException npe){
       JOptionPane.showMessageDialog(null,"The reference does not exits!","Error",JOptionPane.ERROR_MESSAGE);       
       }
       total_priceTf.setText(String.valueOf(money));
       hpc[counterH].setCount(counterH+1);
       counterH++;
       }//else
       car_plateTf.setText(String.valueOf(hpc[counterH-1].getPlate()));
        }//otherwise, it's a high price car.
      
    }//Make a reservation button
  }
 }//actionlistener class   
   
   public int check_ID(String id, Client[] c){
   int i=0;
   String[] arr;
   for(i=0;i<counter-1 ;i++){
   if(id.equals(c[i].getClientID())){
   counter--;
   addLocation(location1Tf.getText(),i,c[i].getCounter());
   return i;
    }
   }
   addLocation(location1Tf.getText(),i,0);
       return i; 
    }//It checks the ID taken as an input and compare it with the rest of the array. If it founds equality, it returns that index number.

    public void setC(Client[] c) {
        this.c = c;
    }

    public Client[] getC() {
        return c;
    }

    public HighPriceCars[] getHpc() {
        return hpc;
    }

    public MidPriceCars[] getMpc() {
        return mpc;
    }

    public LowPriceCars[] getLpc() {
        return lpc;
    }
    
    public void addLocation(String location, int index,int num){
    c[index].setLocation(location, num);
    }
}//reservation class
