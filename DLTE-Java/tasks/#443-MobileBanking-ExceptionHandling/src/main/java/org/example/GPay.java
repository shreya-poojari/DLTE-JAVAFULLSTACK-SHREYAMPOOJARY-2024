package org.example;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GPay extends Account{
    private String  upiPin;
    private String userName;
  ResourceBundle resourceBundle= ResourceBundle.getBundle("application");
  Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public GPay(Long accountNumber, Double accountBalance, String accountHolder, String  upiPin) {
        super(accountNumber, accountBalance, accountHolder);
        this.upiPin = upiPin;
        this.userName = accountHolder;
    }
    public boolean validatePin(String newPin) throws MyBankException{
        if (!upiPin.equals(newPin)){
            logger.log(Level.WARNING,"INVALID UPI");
            throw new MyBankException("pin.invalid");
        }
        return true;
    }
    public void payBill(String billerName,double BilledAmount,String billType,String upiPin) {
        try {
            validatePin(upiPin);
            if (getAccountBalance() >= BilledAmount) {
                logger.log(Level.INFO, "Bill payment succesful to " + billerName + " of amount" + BilledAmount + " for " + billType);
            } else {
                logger.log(Level.WARNING, "Insufficient Balance");
                throw new MyBankException("pin.invalid");
            }
        } catch (MyBankException exception) {
            logger.log(Level.WARNING, exception.toString());
            throw exception;
        }
    }
}
