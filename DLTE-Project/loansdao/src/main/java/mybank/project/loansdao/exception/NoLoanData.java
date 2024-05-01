package mybank.project.loansdao.exception;

public class NoLoanData extends RuntimeException{

       public NoLoanData(String message){
            super(message);
    }
}
