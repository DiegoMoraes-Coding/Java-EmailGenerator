package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 500;

    private  int defaultPasswordLenght = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " +firstName + ". \n\nDEPARTMENT CODES:\n1 For sales\n2 For development\n3 For accounting\n4 For none\nEnter department code : ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return  "sales";}
        else if (depChoice == 2) {return "dev";}
        else if (depChoice == 3) {return  "acct";}
        else {return "";}
    }

    //Generate a random password
    private String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%¨&*";
        char[] password = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity () {return  mailboxCapacity;}
    public String getAlternateEmail() {return "Your alternate email is: " + alternateEmail;}
    public String getPassword() {return password;}

    public String showInfo () {
        return "\nDISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}


