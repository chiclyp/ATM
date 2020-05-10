package ATM;

import java.util.Scanner;

/**
 * @author Pauline Chicoye
 */
public class ATM {
    public static void main(String[] args) {
        Account details = new Account(0);
        details.setBalance(2500.00);
        System.out.println("Hello. This is the virtual ATM machine");
        System.out.println("Please input your full name");
        
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
       
        System.out.println("Welcome "+ name + ".");
        System.out.println("Please input your 4 digit nip.");
        int nip = scan.nextInt();
        
        while (nip != details.nip()){
            System.out.println(details.incorrectNip());
            nip = scan.nextInt();
        }
        
        if (nip == details.nip()){
            System.out.println(details.correctNip());
        }
        
        System.out.println("Please input the number of option you would "
                + "like to select");
        System.out.println("(1) Deposit");
        System.out.println("(2) Withdrawal");
        System.out.println("(3) See Balance");
        
        int choice = scan.nextInt();
        String answer = "";
        String yes = "yes";
        
        switch (choice){
            case 1:
                System.out.println("What will be the amount deposited today?");
                double deposit = scan.nextDouble();
                
                System.out.println("Are you sure you want " + deposit + 
                        " deposited in your account?");
                answer = scan.next();
                
                while (!answer.equalsIgnoreCase(yes)){
                    System.out.println("Please enter new amount");
                    deposit = scan.nextDouble();
                    
                    System.out.println("Are you sure you want " + deposit + 
                        " deposited in your account?");
                    answer = scan.next();
                }
                if (answer.equalsIgnoreCase(yes)){
                    details.setDepSum(deposit);
                    System.out.println(details.currDep());
                }
                

                break;
            case 2:
                System.out.println("What will be the amount withdrawled today?");
                double withdrawal = scan.nextDouble();
                System.out.println("Are you sure you want " + withdrawal + 
                        "withdrawled in your account?");
                answer = scan.next();
                break;
            case 3:
                System.out.println(details.balance()+"$");
                break;   
        }
        
      
        
    }
    
}
