package org.example;

import java.util.Date;
import java.util.List;

public interface MyBank {
    List<Loan> filterLoansByDateRange(List<Loan> loan, Date startDate,Date endDate);
}
