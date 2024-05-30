/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc.st10461176poe;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Makoro ST10461176
 */
public class Login {
    //Declare Private variables for encapsulation
    private String username, password, full_name, last_name;
    private boolean loginStatus;

    //Default Contructor
    public Login() {
        this.full_name = full_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    //Overloaded Constructor
    public Login(String full_name, String last_name, String username, String password, boolean loginStatus) {
        setFullName(full_name);
        setLastName(last_name);
        setUsername(username);
        setPassword(password);
        setLoginStatus(loginStatus);
    }

    //Setter Methods
    public void setFullName(String full_name) {
        this.full_name = full_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    //Getter Methods
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getFullName() {
        return this.full_name;
    }
    public String getLastName() {
        return this.last_name;
    }
    
    //Method to check username is valid
    public boolean checkUserName() {

        if (this.username.contains("_") && this.username.length() <= 5) {
            return true;
        } else {
            return false;
        }

    }
    //Method to check password for special characters using regex pattern and matcher and length
    public boolean checkPasswordComplexity() {

        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean special = false;

        Pattern specialCharacter = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = specialCharacter.matcher(this.password);
        int len;
        char ch;
        len = this.password.length();
        if (len >= 8) {
            for (int c = 0; c < len; c++) {
                ch = this.password.charAt(c);
                if (Character.isDigit(ch)) {
                    digit = true;
                }
                if (Character.isLowerCase(ch)) {
                    lowercase = true;
                }
                if (Character.isUpperCase(ch)) {
                    uppercase = true;
                }
                if (hasSpecial.find()) {
                    special = true;
                }

            }
        }

        if (uppercase && lowercase && digit && special) {
            return true;
        } else {
            return false;
        }

    }
    //Methof to Register user
    public String registerUser() {
        if (!checkUserName()) {
            return "username incorrectly formatted";
        }
        if (!checkPasswordComplexity()) {
            return "Password Does not meet the complexity requirements";
        }
        return "User Has been registered succefully";
    }
    //Method to Login and check user credentials
    public boolean loginUser(String username, String password) {
        if ((getUsername().matches(username)) && (getPassword().matches(password))) {
            this.loginStatus = true;
            return true;
        } else {

            return false;
        }

    }
    //Method for returning login status
    public String returnLoginStatus() {
        if (this.loginStatus) {
            return "Login Successful";
        } else {
            return "Login Failed";
        }

    }

}

