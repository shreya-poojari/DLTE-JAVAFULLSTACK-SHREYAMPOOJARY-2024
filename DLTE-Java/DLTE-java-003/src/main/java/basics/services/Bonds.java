package basics.services;

public class Bonds {
    private Integer maturity;
    private Double InterestRate;
    private String taxStatus;
    private String BondHolder;
    private Integer period;

    public Bonds(Integer maturity, Double interestRate, String taxStatus, String bondHolder, Integer period) {
        this.maturity = maturity;
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

    public Double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(Double InterestRate) {
        this.InterestRate = InterestRate;
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


