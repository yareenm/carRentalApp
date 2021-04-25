/*
RentalGUI.java        Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class generates the main form of our application. It shows the other forms whenever user click the relevant button.
It initialize the client array and send it to the other forms.
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RentalGUI extends JFrame{
    private JLabel welcomeL;
    private JButton reservationB,reportB,exitB;
    MyEventHandler event_Handler = new MyEventHandler();
    private Client[] c = new Client[30];
    private int i;
    private HighPriceCars[] hpc= new HighPriceCars[10];
    private MidPriceCars[] mpc= new MidPriceCars[10];
    private LowPriceCars[] lpc= new LowPriceCars[10];
    
    public RentalGUI(){
    
    while(i<c.length){
    c[i]=new Client();
    i++;
    } 
    for(int i=0 ; i<10 ; i++) {
        hpc[i]=new HighPriceCars();
        mpc[i]=new MidPriceCars();
        lpc[i]=new LowPriceCars();
    }
    
        
    welcomeL=new JLabel("Welcome to the Car Rental Form\n");
    reservationB = new JButton("Make a Reservation");
    reportB = new JButton("Show the Report");
    exitB= new JButton("Exit");
    
    Container container = getContentPane();
    
    FlowLayout layout = new FlowLayout();//yerleşim düzzenleyicileri
    container.setLayout(layout);
    container.add(welcomeL);
    
    container.add(reservationB);
    container.add(reportB);
    container.add(exitB);
    
    
    reservationB.addActionListener(event_Handler);
    reportB.addActionListener(event_Handler);
    exitB.addActionListener(event_Handler);
    }
   
    
    public class MyEventHandler implements ActionListener{ //inner class
    
    public void actionPerformed(ActionEvent ae){
        Reservation reservation_Form= new Reservation(c,hpc,mpc,lpc);
        if(ae.getSource() == reservationB){ // for open the reservation form
        reservation_Form.show();
        }
        else if(ae.getSource()==reportB){//for open the report form
        Report report_Form= new Report(reservation_Form.getC(),reservation_Form.getHpc(),reservation_Form.getMpc(),reservation_Form.getLpc());
        report_Form.show();

        }   
        else{//otherwise, exit the program.
        System.exit(0);
        }
    
    }
    
    }

}
