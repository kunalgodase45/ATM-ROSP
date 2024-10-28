import java.util.*;

class ATM {
    float Balance; 
    int PIN = 1019; 
    ArrayList<String> miniStatement = new ArrayList<>();  
    Scanner sc = new Scanner(System.in); 
    int pinAttempts = 0; 

    HashMap<String, Float> accounts = new HashMap<>();

    public ATM() {
        accounts.put("12345", 10000f); 
        accounts.put("67890", 20000f);  
    }

    public void checkpin() {
        System.out.println("Please Enter Your PIN: ");
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN) { 
            pinAttempts = 0;  
            menu();  
        } else {  
            pinAttempts++;  
            if (pinAttempts >= 3) {  
                System.out.println("Too many invalid attempts! Exiting...");
            } else {
                System.out.println("Invalid PIN! Attempts left: " + (3 - pinAttempts));
                checkpin();  
            }
        }
    }
}

public class ATMTASK {
    public static void main(String[] args) {
        ATM obj = new ATM(); 
        obj.checkpin();  
    }
}
