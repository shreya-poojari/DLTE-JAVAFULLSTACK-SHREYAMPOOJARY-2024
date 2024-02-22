package basics.services;

import lombok.Data;
import java.util.Date;
@Data
public class CreditCard {
    public CreditCard(){
        System.out.println("Initialize the card properties manually");
    }

    public CreditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Date dateOfBillGeneration, Date dateOfBillPayment, Integer creditCardPin) {
        CreditCardNumber = creditCardNumber;
        CreditCardHolder = creditCardHolder;
        CreditCardExpiry = creditCardExpiry;
        CreditCardCvv = creditCardCvv;
        CreditCardLimit = creditCardLimit;
        DateOfBillGeneration = dateOfBillGeneration;
        DateOfBillPayment = dateOfBillPayment;
        CreditCardPin = creditCardPin;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "CreditCardNumber=" + CreditCardNumber +
                ", CreditCardHolder='" + CreditCardHolder + '\'' +
                ", CreditCardExpiry=" + CreditCardExpiry +
                ", CreditCardCvv=" + CreditCardCvv +
                ", CreditCardLimit=" + CreditCardLimit +
                ", DateOfBillGeneration=" + DateOfBillGeneration +
                ", DateOfBillPayment=" + DateOfBillPayment +
                ", CreditCardPin=" + CreditCardPin +
                '}';
    }

    public Long getCreditCardNumber() {
        return CreditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getCreditCardHolder() {
        return CreditCardHolder;
    }

    public void setCreditCardHolder(String creditCardHolder) {
        CreditCardHolder = creditCardHolder;
    }

    public Date getCreditCardExpiry() {
        return CreditCardExpiry;
    }

    public void setCreditCardExpiry(Date creditCardExpiry) {
        CreditCardExpiry = creditCardExpiry;
    }

    public Integer getCreditCardCvv() {
        return CreditCardCvv;
    }

    public void setCreditCardCvv(Integer creditCardCvv) {
        CreditCardCvv = creditCardCvv;
    }

    public Integer getCreditCardLimit() {
        return CreditCardLimit;
    }

    public void setCreditCardLimit(Integer creditCardLimit) {
        CreditCardLimit = creditCardLimit;
    }

    public Date getDateOfBillGeneration() {
        return DateOfBillGeneration;
    }

    public void setDateOfBillGeneration(Date dateOfBillGeneration) {
        DateOfBillGeneration = dateOfBillGeneration;
    }

    public Date getDateOfBillPayment() {
        return DateOfBillPayment;
    }

    public void setDateOfBillPayment(Date dateOfBillPayment) {
        DateOfBillPayment = dateOfBillPayment;
    }

    public Integer getCreditCardPin() {
        return CreditCardPin;
    }

    public void setCreditCardPin(Integer creditCardPin) {
        CreditCardPin = creditCardPin;
    }

    private Long CreditCardNumber;
    private String CreditCardHolder;
    private Date CreditCardExpiry;
    private Integer CreditCardCvv;
    private Integer CreditCardLimit;
    private Date DateOfBillGeneration;
    private Date DateOfBillPayment;
    private Integer CreditCardPin;
}
