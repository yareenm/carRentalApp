/*
Car.java        Author: Yaren Menemencioğlu ID:21895484
                E-mail: 21895484@mail.baskent.edu.tr
This class is a super class and it defines common attributes. Also, it has functions
for reach to the attributes or change the attributes' values.
*/
import java.util.*;

public class Car {
    protected int count;
    protected String plate;
    

    public Car(){
    count=0;
    plate="";
    }
    
    public Car(int count, String plate) {
        this.count = count;
        this.plate = plate;
        
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    
}
