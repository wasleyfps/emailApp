import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternativeEmail;
    private String companySuffix = "corporation.com";
    
    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: "+ this.firstName + this.lastName);
        
        // Call a method asking for the department - return department  
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        
        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        
        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        System.out.println("Your email is: " + email);
    }
    
    // Ask for department
    private String setDepartment() {
        System.out.println("DEPARMENTS CODES: \n1 for sales \n2 for development \n3 for Accouting \n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "sales";
        }
        else if (depChoice == 2){
            return "dev";
        }
        else if (depChoice == 3){
            return "acct";
        }
        else{
            return "";
        }
    };

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHJKLMNOPRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String (password);
    }
    
    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    
    // Set the email alternative
    public void setEmailAlternative(String altEmail){
        this.alternativeEmail = altEmail;
    }
    
    // Change the password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlernativeEmail(){
        return alternativeEmail;
    }
    public String getPassword(){
        return password;
    }
    
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + " " + 
                "\nCOMPANY EMAIL: " + email + " " + 
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
