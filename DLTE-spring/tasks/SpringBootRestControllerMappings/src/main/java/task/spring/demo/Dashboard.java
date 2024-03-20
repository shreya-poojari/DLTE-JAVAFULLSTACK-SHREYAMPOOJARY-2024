package task.spring.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Loans")
public class Dashboard {
    private List<Loan> loanList=new ArrayList<>();
public Dashboard(){
    loanList.add(new Loan(1,"Shreya",2500));
    loanList.add(new Loan(2,"snehal",5000));
    loanList.add(new Loan(3,"Dhanush",6000));
}
@GetMapping("/{index}")
public Loan getloan(@PathVariable int index) {
    if (index >= 0 && index < loanList.size()) {
        return loanList.get(index);
    } else {
        throw new IllegalArgumentException("Invalid index");
    }
}
    @PostMapping("/loanadd")
    public Loan addLoan(@RequestBody Loan loan) {
        loanList.add(loan);
        return loan;
    }
}
