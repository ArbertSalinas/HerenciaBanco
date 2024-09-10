/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
import javax.swing.JOptionPane;
public class BancoControlador {
    private BancoVista frame;
    private Bank negocio;

    public BancoControlador(BancoVista frame) {
        this.frame=frame;
        this.negocio=new Bank();
    }

    public void applyTransaction() {
        try{
            if((!(frame.getRbRetirar().isSelected())&&!(frame.getRbDividendos().isSelected())) ||frame.getTxtNumeroCuentaAcciones().getText().equals("") || frame.getTxtValor().getText().equals("")){
                throw new Exception("Please fill in all fields");           
            }else{
                String acn=frame.getTxtNumeroCuentaAcciones().getText();
                int acnum =Integer.parseInt(acn);
                String val= frame.getTxtValor().getText();
                double value=Double.parseDouble(val);
                if(frame.getRbRetirar().isSelected()){
                    negocio.withdrawAccount(acnum, value);
                    frame.getTaMensajes().setText("Withdrawal in account " + acn);
                }if(frame.getRbDividendos().isSelected()){
                    negocio.payDividend(acnum, value);
                    frame.getTaMensajes().setText("Pay dividend in account " + acn);
                }cancelTransaction();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ArithmeticException e){
            frame.getTaMensajes().setText(e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelTransaction() {
        frame.getTxtNumeroCuentaAcciones().setText("");
        frame.getTxtValor().setText("");
        frame.getButtonGroupAcciones().clearSelection();
    }

    public void openAccount() {
        try{
            if((!(frame.getRbAhorros().isSelected())&&!(frame.getRbCorriente().isSelected())) ||frame.getTxtNumeroCuenta().getText().equals("") || frame.getTxtSaldoCuenta().getText().equals("")){
                throw new Exception("Please fill in all fields");           
            }else{
                String acn=frame.getTxtNumeroCuenta().getText();
                int acnum =Integer.parseInt(acn);
                String val= frame.getTxtSaldoCuenta().getText();
                double value=Double.parseDouble(val);
                if(frame.getRbAhorros().isSelected()){
                    negocio.openSavingAccount(acnum);
                    negocio.payDividend(acnum, value);
                    frame.getTaMensajes().setText("Open Saving Account "+acn+" Succesfully");
                }if(frame.getRbCorriente().isSelected()){
                    negocio.openCurrentAccount(acnum);
                    negocio.payDividend(acnum, value);
                    frame.getTaMensajes().setText("Open Current Account "+acn+" Succesfully");
                }cancelOpenning();
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ArithmeticException e){
            frame.getTaMensajes().setText(e.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public void cancelOpenning() {
        frame.getTxtNumeroCuenta().setText("");
        frame.getTxtSaldoCuenta().setText("");
        frame.getButtonGroupTipos().clearSelection();
    }

    public void sendLetters() {
        frame.getTaMensajes().setText(negocio.sendLetterToOverdraftAccounts());
    }
    
    
}
