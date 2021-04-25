/*
MidPriceCars.java        Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
This class inherits from Car class. In despite of common attributes in Car class, it has unique price range which is differs from other car models.
It has 2 constructor (default and with parameter) which they are use "super()" function to use base class's constructor(default and with parameter). 
*/
import java.util.Random;


public class MidPriceCars extends Car{ //min 150 max 200
    private double price;
    private Random r = new Random();
    public MidPriceCars(){
    super();
    price=100;
    }
    public MidPriceCars(double price, int count, String plate) {
       super(count,  plate);
       this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {   
        this.price= (double)(r.nextInt(51)+150);
 
    }
 
    public void setPlate() {
        String plate = "06 ABC "+ (int) r.nextInt(5);
       
        super.setPlate(plate);
    }
    @Override
    public String getPlate() {
        return super.getPlate(); 
    }
    
}
