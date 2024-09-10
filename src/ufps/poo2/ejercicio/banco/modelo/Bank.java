package ufps.poo2.ejercicio.banco.modelo;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void withdrawAccount(int numbacc, double sum) throws Exception {
	for(Account a: accounts){
            if (a.getAccountNumber()==numbacc){
                a.withdraw(sum);
                return;
            }
        }
    throw new Exception("Account no registered");
    }    
    public void payDividend(int numbacc, double sum) throws Exception {
	for(Account a: accounts){
            if (a.getAccountNumber()==numbacc){
            a.deposit(sum);
            return;
            }
        }
    throw new Exception("Account no registered");
    }
    public double getBalance(int numbacc){
        for(Account a: accounts){
            if (a.getAccountNumber()==numbacc){
                return a.getBalance();
            }
        }
        return 0;
    }
    public void openAccount(char type, int numberacc)throws Exception{
        if(type=='A'){
            openSavingAccount(numberacc); 
        }else if(type=='C'){
            openCurrentAccount(numberacc);
        }else{
            System.err.println("Select a type of account");
        }
    }
    
    public void openSavingAccount(int numberacc){
        SavingsAccount sacc= new SavingsAccount(numberacc);
        accounts.add(sacc);
    }
    public void openCurrentAccount(int numberacc){
        CurrentAccount sacc= new CurrentAccount(numberacc);
        accounts.add(sacc);
    }
    public void closeAccount(int numberacc){
        for(Account s : accounts){
            if(s.getAccountNumber()==numberacc){
                accounts.remove(s);
            }
        }   
    }
    
    public String sendLetterToOverdraftAccounts(){
        String letter="";
        for(Account c : accounts){
            if (c.getBalance()<0){
                letter+=("Sending letter to this "+c.getAccountNumber()+" account\n");
            }
        }
        return letter;
    }
    
}
