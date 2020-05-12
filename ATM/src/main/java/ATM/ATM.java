package ATM;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * A program that serves as a virtual ATM machine, this is my end of semester
 * assignment.
 *
 * @author Pauline Chicoye
 */
public class ATM {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //To add the time and date in my ATM machine.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //Setting up the account with 2500$ as balance
        Account details = new Account(0);
        details.setBalance(2500.00);

        //Getting user's credentials.
        System.out.println("Hello. This is the virtual ATM machine");
        System.out.println("Please input your full name");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        System.out.println("Welcome " + name + ".");
        System.out.println("Please input your 4 digit nip.");
        int nip = scan.nextInt();

        //Verification of correct nip
        while (nip != details.nip()) {
            System.out.println(details.incorrectNip());
            nip = scan.nextInt();
        }

        if (nip == details.nip()) {
            System.out.println(details.correctNip());
        }

        //Giving the user the choice of option
        System.out.println("Please input the number of the option you would "
                + "like to select.");
        System.out.println("(1) Deposit");
        System.out.println("(2) Withdrawal");
        System.out.println("(3) See Balance");
        int choice = scan.nextInt();

        String yes = "yes";

        //Swtich case.
        switch (choice) {
            //Deposit Option.
            case 1:
                System.out.println("What will be the amount deposited today?");
                double deposit = scan.nextDouble();

                System.out.println("Are you sure you want " + deposit
                        + " deposited in your account? (Yes/No)");
                String answer = scan.next();

                //If user says no.
                while (!answer.equalsIgnoreCase(yes)) {
                    System.out.println("Please enter new amount");
                    deposit = scan.nextDouble();

                    System.out.println("Are you sure you want " + deposit
                            + " deposited in your account? (Yes/No)");
                    answer = scan.next();
                }

                //If user says yes.
                if (answer.equalsIgnoreCase(yes)) {
                    details.setDepSum(deposit);
                    System.out.println(details.currDep());
                }
                break;

            //Withdraw Option.    
            case 2:
                System.out.println("What will be the amount withdrawled today?");
                double withdrawal = scan.nextDouble();

                System.out.println("Are you sure you want " + withdrawal
                        + " withdrawled in your account? (Yes/No)");
                answer = scan.next();

                //If user says no.
                while (!answer.equalsIgnoreCase(yes)) {
                    System.out.println("Please enter new amount");
                    withdrawal = scan.nextDouble();

                    System.out.println("Are you sure you want " + withdrawal
                            + " withdrawled from your account? (Yes/No)");
                    answer = scan.next();
                }

                //If ussr says yes.
                if (answer.equalsIgnoreCase(yes)) {
                    details.setWithSum(withdrawal);

                    //Challenge. Limit number of bills.
                    System.out.println("Here are your Withdraw Details:");
                    System.out.println("Number of 100 bills received: "
                            + details.toHundBills());
                    System.out.println("Number of 50 bills received: "
                            + details.toFiftyBills());
                    System.out.println("Number of 20 bills received: "
                            + details.toTwentyBills());
                    System.out.println("Number of 10 bills received: "
                            + details.toTenBills());
                    System.out.println("Number of 5 bills received: "
                            + details.toFiveBills());

                    //The rest of balance printed.
                    System.out.println(details.currWith());
                }
                break;

            //To see balance option.  
            case 3:
                System.out.println(details.balance() + "$");
                break;
        }
        int i;
        System.out.println("Your transaction has been made.");
        System.out.println("---------------------------------------------------"
                            + "----------------------------");

        //Loop for quote.
        for (i = 0; i < 2; i++) {
            System.out.println("Here is your random quote of the day");
            System.out.println("\"Nothing in the universe can stop you from "
                    + "letting go and stating over\"");
            System.out.println("-----------------------------------------------"
                    + "--------------------------------");
            i++;
        }

        String at = "@";
        String emYes = "yes";

        //Option to send receipt to email.
        System.out.println("Would you like the receipt to be sent to your email? "
                + "(Yes/No)");
        String ans = scan.next();

        //If user says yes.
        if (ans.equalsIgnoreCase(emYes)) {
            System.out.println("Please input your email");
            String email = scan.next();

            //If email is invalid.
            while (!email.contains(at)) {
                System.out.println("Invalid Email. Try Again");
                email = scan.next();
            }

            System.out.println("The email has been sent to " + email);
        }

        //End of program. Salutations.
        System.out.println("Have a nice day. Goodbye!");
        System.out.println(dtf.format(now));
    }
}
