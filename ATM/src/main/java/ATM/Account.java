package ATM;

/**
 * @author Pauline Chicoye
 */
public class Account {
    private double balance;
    private double withSum;
    private double depSum;
    private final int HUND_BILL = 100; 
    private final int FIFTY_BILL = 50; 
    private final int TWENTY_BILL = 20; 
    private final int TEN_BILL = 10; 
    private final int FIVE_BILL = 5; 
    private final int NIP = 1111;

    Account(double bal) {
        bal = balance;
    }
    
    public void setBalance (double b){
        this.balance = b;
    }
    public void setWithSum (double w){
        this.withSum = w;
    }
    public  void setDepSum (double d){
        this.depSum = d;
    }
    public double getBalance(){
        return balance;
    }
    public double getWithSum(){
        return withSum;
    }
    public double getDepSum(){
        return depSum;
    }
    public int nip(){
        return NIP;
    }
    public String balance(){
        return "Your current balance is " + getBalance();
    }
    public String incorrectNip(){
        return "Incorrect Nip. Try Again.";
    }
    public String correctNip(){
        return "Correct Nip.";
    }
    public double deposit(){
        return balance += depSum;
    }
    public String currDep(){
        return "Your current balance is now " + deposit();
    }
    public double withdraw(){
        return balance -= withSum;
    }
    public String currWith(){
        return "Your current balance is now " + withdraw();
    }
    public int toHundBills(){
        int hB =((int)withSum / HUND_BILL);
        return hB;
    }
    public int sousHund(){
        int sousH = ((int)withSum - (HUND_BILL * toHundBills()));
        return sousH;
    }
    public int toFiftyBills(){
        int fB = sousHund() / FIFTY_BILL;
        return fB;
    }
    public int sousFifty(){
        int sousFif = (sousHund() - (FIFTY_BILL * toFiftyBills()));
        return sousFif;
    }
    public int toTwentyBills(){
        int tB = (sousFifty() / TWENTY_BILL);
        return tB;
    }
    public int sousTwenty(){
        int sousTwe = (sousFifty() - (TWENTY_BILL * toTwentyBills()));
        return sousTwe;
    }
    public int toTenBills(){
        int tT = (sousTwenty() / TEN_BILL);
        return tT;
    }
    public int sousTen(){
        int sousTen = (sousTwenty() - (TEN_BILL * toTenBills()));
        return sousTen;
    }
    public int toFiveBills(){
        int fB = (sousTen() / FIVE_BILL);
        return fB;
    }
    
}
