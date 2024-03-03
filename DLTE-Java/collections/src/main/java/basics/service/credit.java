package basics.service;

public class credit {
    private Integer cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    public credit(Integer cardNumber, String cardHolder, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCaedHolder() {
        return cardHolder;
    }

    public void setCaedHolder(String caedHolder) {
        this.cardHolder = caedHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
