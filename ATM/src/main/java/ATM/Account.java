package ATM;

/**
 * @author Pauline Chicoye
 */
public class Account {
    private double balance;
    private double withSum;
    private double depSum;
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
    
    
    
}
