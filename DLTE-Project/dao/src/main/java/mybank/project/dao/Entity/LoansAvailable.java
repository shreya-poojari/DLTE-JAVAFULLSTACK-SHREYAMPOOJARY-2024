package mybank.project.dao.Entity;

public class LoansAvailable {
    //entities of loan available
    private int loanNumber;
    private String loanType;
    private String loanName;
    private String loanDescription;
    private double loanRoi;

    //constructor
    public LoansAvailable(int loanNumber, String loanType, String loanName, String loanDescription, double loanRoi) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.loanName = loanName;
        this.loanDescription = loanDescription;
        this.loanRoi = loanRoi;
    }

    public LoansAvailable() {
    }

    //toString
    @Override
    public String toString() {
        return "Loans{" +
                "loanNumber=" + loanNumber +
                ", loanType='" + loanType + '\'' +
                ", loanName='" + loanName + '\'' +
                ", loanDescription='" + loanDescription + '\'' +
                ", loanRoi='" + loanRoi + '\'' +
                '}';
    }

    //getter setter
    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanDescription() {
        return loanDescription;
    }

    public void setLoanDescription(String loanDescription) {
        this.loanDescription = loanDescription;
    }

    public double getLoanRoi() {
        return loanRoi;
    }

    public void setLoanRoi(double loanRoi) {
        this.loanRoi = loanRoi;
    }
}
