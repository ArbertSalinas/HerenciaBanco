/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Arbert
 */
public class SavingsAccount extends Account {
    private double interest;


    public SavingsAccount(int a) {
        super(a);
        this.interest=0.08;    
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    @Override
    public void deposit(double sum) {
	double balancetem=getBalance();
        if (sum > 0){
            sum+=(balancetem*interest);
            super.deposit(sum);
        }else{
            throw new ArithmeticException("Account.deposit(...): " + "cannot deposit negative amount.");
        }
    }
    
    @Override
    public void withdraw(double sum) {
		if (getBalance() >= sum && sum > 0)
			super.withdraw(sum);
		else
			throw new ArithmeticException("Account.withdraw(...): " + "cannot withdraw this amount.");
	}
}
