package basics.service;

public interface MyBank {
    loan[] Loan=new loan[10];
    void addNewLoan();
    void CheckAvailableLoans();
    void CheckOnlyClosedLoans();
}
