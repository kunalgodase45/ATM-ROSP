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

    public void menu() {
        System.out.println("Enter Your Choice: \n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Mini Statement");
        System.out.println("5. PIN Change");
        System.out.println("6. Transfer Funds");
        System.out.println("7. Exit");

        int option = sc.nextInt();

        
        switch (option) {
            case 1 -> CheckBalance();  
            case 2 -> DepositMoney();  
            case 3 -> WithdrawMoney();  
            case 4 -> MiniStatement(); 
            case 5 -> PinChange();  
            case 6 -> transferFunds(); 
            case 7 -> exitATM(); 
            default -> {
                System.out.println("Choose a Valid Option: "); 
                menu(); 
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
