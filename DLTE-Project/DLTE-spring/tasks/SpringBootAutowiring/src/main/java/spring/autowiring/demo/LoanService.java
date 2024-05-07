package spring.autowiring.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface LoanService {
    List<Loan> loansList= Stream.of(new Loan(34234L,2000L,"closed","home","Shreya",9876543423L),
            new Loan(87654L,5000L,"open","home","Snehal",46756789876L),
            new Loan(65432L,5430L,"closed","personal","Kavya",6547689856L),
            new Loan(98765L,1000L,"open","bill","Dhanush",1234567876L)).collect(Collectors.toList());
    List<Loan> findALL();
}
