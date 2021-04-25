/*
MyException.java          Author: Yaren Menemencioğlu ID:21895484
                          E-mail: 21895484@mail.baskent.edu.tr
It creates user defined exception in the program. It uses runtime exception's function that take string argument and display a message to the user.
 */
public class MyException extends RuntimeException {
    public MyException(){//user defined exception
    super("Enter a valid argument!");
    }
}
