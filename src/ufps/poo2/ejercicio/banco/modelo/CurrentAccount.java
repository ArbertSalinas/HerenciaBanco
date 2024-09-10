/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Arbert
 */
public class CurrentAccount extends Account {
    private double overdraft;   

    public CurrentAccount(int a) {
        super(a);
        this.overdraft= 500000;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
    
    @Override
    public void deposit(double sum) {
		if (sum > 0)
			super.deposit(sum);
		else
			throw new ArithmeticException("Account.deposit(...): " + "cannot deposit negative amount.");
    }
    @Override
    public void withdraw(double sum) {
	double availablemont=getBalance()+overdraft;
        if((getBalance()>=0)){
             super.withdraw(sum);
        }   
        else{
                throw new ArithmeticException("Account.withdraw(...): " + "cannot withdraw this amount.");    
        }        
    }
    public boolean overdrafStatus(){
        if(getBalance()<0){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
	return "Acc " + getAccountNumber() + ": " + "balance = " + getBalance()+ ", Overdraft : "+ overdrafStatus();
    }
}
    

