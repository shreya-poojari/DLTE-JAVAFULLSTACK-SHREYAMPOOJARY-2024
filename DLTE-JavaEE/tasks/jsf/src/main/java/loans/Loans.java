package loans;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

import java.util.List;

@ManagedBean
@RequestScoped
public class Loans {
    private Long loanNumber;
    private Double loanAmount;
    private String loanDate;
    private String loanStatus;
    private String borrowerName;
    private Long borrowerContact;
    private List<Loans> loanList;

    public Loans(Long loanNumber, Double loanAmount, String loanDate, String loanStatus, String borrowerName, Long borrowerContact) {
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.loanStatus = loanStatus;
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
    }
    public Loans() {

    }
//to string
    @Override
    public String toString() {
        return "Loans{" +
                "loanNumber=" + loanNumber +
                ", loanAmount=" + loanAmount +
                ", loanDate='" + loanDate + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerContact=" + borrowerContact +
                '}';
    }

//getter and setter
    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getBorrowerContact() {
        return borrowerContact;
    }

    public void setBorrowerContact(Long borrowerContact) {
        this.borrowerContact = borrowerContact;
    }

    @PostConstruct
    public void initLoans() {
        loanList = new ArrayList<>();
        loanList.add(new Loans(2000L, 100.0, "01/01/2024", "open", "Shreya", 7414569635L));
        loanList.add(new Loans(2001L, 200.0, "02/01/2024", "open", "Dhanush", 9637531594L));
        loanList.add(new Loans(2002L, 300.0, "03/02/2024", "open", "Snehal", 8529637419L));
        loanList.add(new Loans(2003L, 400.0, "04/02/2024", "closed", "Sumanth", 9517534568L));
    }

    //add loan
    public void addLoan(Loans loan) {
        loanList.add(loan);
    }
//closed loan
    public List<Loans> getClosedLoans() {
        List<Loans> closedLoans = new ArrayList<>();
        for (Loans loan : loanList) {
            if (loan.getLoanStatus().equalsIgnoreCase("closed")) {
                closedLoans.add(loan);
            }
        }
        return closedLoans;
    }
//delete loan
    public void deleteLoan(Long loanNumber) {
        loanList.removeIf(loan -> loan.getLoanNumber().equals(loanNumber));
    }
//all
    public String allLoans(){
        return loanList.toString();
    }

}