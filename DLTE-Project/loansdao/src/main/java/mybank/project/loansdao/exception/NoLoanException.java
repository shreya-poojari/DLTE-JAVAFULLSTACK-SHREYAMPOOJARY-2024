package mybank.project.loansdao.exception;

public class NoLoanException extends RuntimeException {
    public NoLoanException(String message){
    super(message);
      //  super("no Loan data found");
    }
}
