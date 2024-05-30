/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rc.st10461176poe;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class ST10461176POE {

    //Create new object from the login class
    static Login user = new Login();

    //Declare variables for the main class
    static String full_name, last_name, username, password;

    public static void main(String[] args) {
        //Call methods to create user and login user
        registerUser();
        loginUser();
    }

    static void createUser() {
        //Create a new Login Object and use the overloaded constructor 
        full_name = JOptionPane.showInputDialog("Please enter your full name");
        last_name = JOptionPane.showInputDialog("Please enter your last name");
        username = JOptionPane.showInputDialog("Please set username, Must contain underscore and less than 5 characters.");
        password = JOptionPane.showInputDialog("Please set password, Must be more than 8 characters, digits and special character");
        user = new Login(full_name, last_name, username, password, false);
    }

    static void registerUser() {
        boolean registrationTriger = true;
        do {
            boolean usernameCheck = false;
            boolean passwordCheck = false;
            //Call the create user method for registration
            createUser();
            /*check if password complexity meets requirement 
            update the local variable
             */
            if (user.checkUserName()) {
                usernameCheck = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted," + '\n'
                        + "please ensure that your username contains an underscore" + '\n'
                        + "and is no more than 5 characters in length");
            }
            /*check if password complexity meets requirement 
            update the local variable
             */
            if (user.checkPasswordComplexity()) {
                passwordCheck = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted," + '\n'
                        + "please ensure that the password contains atleast 8 characters," + '\n'
                        + "a capital letter, a number and a special character.");
            }
            if (usernameCheck && passwordCheck) {
                /*username and password are both valid then 
                the user may be registered and communication 
                can be sent to the user
                 */
                JOptionPane.showMessageDialog(null, "Username Succesfully Captured");
                JOptionPane.showMessageDialog(null, "Password Succesfully Captured");
                JOptionPane.showMessageDialog(null, user.registerUser());
                registrationTriger = false;
            } else {
                JOptionPane.showMessageDialog(null, user.registerUser());
            }
        } while (registrationTriger);

    }

    //method to Login the user
    static void loginUser() {
        //Declare local variables for temporary storage for operations
        boolean loginTriger = true;
        String fullname = user.getFullName();
        String lastname = user.getLastName();
        do {
            //Temporary Storae for username and password for logging in
            String username = JOptionPane.showInputDialog("Enter your login username");
            String password = JOptionPane.showInputDialog("Enter your login password");
            if (user.loginUser(username, password)) {//if the username and password entered are correct then the condition is met for user to be logged in.
                JOptionPane.showMessageDialog(null, user.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Welcome " + fullname + " , " + lastname + " it is great to see you again.");
                loginTriger = false;
            } else {
                JOptionPane.showMessageDialog(null, user.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Username or password incorrect please try again");
            }
        } while (loginTriger);
    }
}
