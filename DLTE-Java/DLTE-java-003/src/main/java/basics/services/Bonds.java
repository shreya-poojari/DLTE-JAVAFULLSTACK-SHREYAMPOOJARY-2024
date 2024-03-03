package basics.services;

public class Bonds {
    private Integer maturity;
    private String bondName;
    private Double InterestRate;
    private String taxStatus;
    private String BondHolder;
    private Integer period;

    public Bonds(Integer maturity, String bondName, Double interestRate, String taxStatus, String bondHolder, Integer period) {
        this.maturity = maturity;
        this.bondName = bondName;
        this.InterestRate = interestRate;
        this.taxStatus = taxStatus;
        this.BondHolder = bondHolder;
        this.period = period;
    }

    public Integer getMaturity() {
        return maturity;
    }

    public void setMaturity(Integer maturity) {
        this.maturity = maturity;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public Double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.InterestRate = interestRate;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getBondHolder() {
        return BondHolder;
    }

    public void setBondHolder(String bondHolder) {
        this.BondHolder = bondHolder;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}


