package basics.services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CreditCard {
    public CreditCard(){
        System.out.println("Initialize the card properties manually");
    }

    public CreditCard(Long CreditCardNumber,String CreditCardHolder,Date CreditCardExpiry, Integer CreditCardLimit, Integer CreditCardCvv, Integer dateOfBillGeneration, Integer DAteOfBillPayment, Integer CreditCardPin){
        this.CreditCardNumber = CreditCardNumber;
        this.CreditCardHolder = CreditCardHolder;
        this.CreditCardExpiry = CreditCardExpiry;
        this.CreditCardCvv = CreditCardCvv;
        this.CreditCardLimit = CreditCardLimit;
        this.dateOfBillGeneration = dateOfBillGeneration;
        this.CreditCardPin = CreditCardPin;
    }
    public Long getCreditCardNumber(){
        return CreditCardNumber;
    }
    public Void
}
