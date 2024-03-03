package basics.service;

import java.util.Date;

public class creditCard {
    public creditCard() {
        System.out.println("initialize the card properties maunally");
    }

    private Long creditCardNumber;
    private String creditCardHolder;
    private Date creditCardExpiry;
    private Integer creditCardCvv;
    private Integer creditCardLimit;
    private Date dateOfBilGeneration;
    private Date dateOfBillPayment;
    private Integer creditCardPin;

    public creditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Date dateOfBilGeneration, Date dateOfBillPayment, Integer creditCardPin) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardHolder = creditCardHolder;
        this.creditCardExpiry = creditCardExpiry;
        this.creditCardCvv = creditCardCvv;
        this.creditCardLimit = creditCardLimit;
        this.dateOfBilGeneration = dateOfBilGeneration;
        this.dateOfBillPayment = dateOfBillPayment;
        this.creditCardPin = creditCardPin;
    }

    @Override
    public String toString() {
        return "creditCard{" +
                "creditCardNumber=" + creditCardNumber +
                ", creditCardHolder='" + creditCardHolder + '\'' +
                ", creditCardExpiry=" + creditCardExpiry +
                ", creditCardCvv=" + creditCardCvv +
                ", creditCardLimit=" + creditCardLimit +
                ", dateOfBilGeneration=" + dateOfBilGeneration +
                ", dateOfBillPayment=" + dateOfBillPayment +
                ", creditCardPin=" + creditCardPin +
                '}';
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardHolder() {
        return creditCardHolder;
    }

    public void setCreditCardHolder(String creditCardHolder) {
        this.creditCardHolder = creditCardHolder;
    }

    public Date getCreditCardExpiry() {
        return creditCardExpiry;
    }

    public void setCreditCardExpiry(Date creditCardExpiry) {
        this.creditCardExpiry = creditCardExpiry;
    }

    public Integer getCreditCardCvv() {
        return creditCardCvv;
    }

    public void setCreditCardCvv(Integer creditCardCvv) {
        this.creditCardCvv = creditCardCvv;
    }

    public Integer getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(Integer creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public Date getDateOfBilGeneration() {
        return dateOfBilGeneration;
    }

    public void setDateOfBilGeneration(Date dateOfBilGeneration) {
        this.dateOfBilGeneration = dateOfBilGeneration;
    }

    public Date getDateOfBillPayment() {
        return dateOfBillPayment;
    }

    public void setDateOfBillPayment(Date dateOfBillPayment) {
        this.dateOfBillPayment = dateOfBillPayment;
    }

    public Integer getCreditCardPin() {
        return creditCardPin;
    }

    public void setCreditCardPin(Integer creditCardPin) {
        this.creditCardPin = creditCardPin;
    }
}
