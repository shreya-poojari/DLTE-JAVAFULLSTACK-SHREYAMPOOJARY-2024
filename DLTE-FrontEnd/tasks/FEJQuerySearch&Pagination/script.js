// Sample loan data
const loanData = [
    { id: 1, name: 'Personal Loan', loanType: 'Personal', description: 'A loan for personal use, such as debt consolidation, home improvements, or unexpected expenses.' },
    { id: 2, name: 'Home Loan', loanType: 'Mortgage', description: 'A loan for purchasing a new home or refinancing an existing mortgage.' },
    { id: 3, name: 'Auto Loan', loanType: 'Auto', description: 'A loan for purchasing a new or used vehicle.' },
    { id: 4, name: 'Business Loan', loanType: 'Business', description: 'A loan for starting or expanding a business.' },
    { id: 5, name: 'Student Loan', loanType: 'Education', description: 'A loan for financing educational expenses, such as tuition, books, and housing.' },
    { id: 6, name: 'Debt Consolidation Loan', loanType: 'Personal', description: 'A loan that combines multiple existing debts into a single loan with a lower interest rate.' },
    { id: 7, name: 'Home Equity Loan', loanType: 'Mortgage', description: 'A loan that uses the equity in your home as collateral.' },
    { id: 8, name: 'Personal Line of Credit', loanType: 'Personal', description: 'A revolving line of credit for personal use, similar to a credit card.' },
  ];
  
  let currentPage = 1;
  const itemsPerPage = 2;
  
  // Function to display loan table
  function displayLoanTable(loans) {
    const loanTableBody = document.getElementById('loanTableBody');
    loanTableBody.innerHTML = '';
  
    const mainContent = document.getElementById('main-content');
    mainContent.style.display = 'none';
  
    const loanTableContainer = document.getElementById('loan-table-container');
    loanTableContainer.style.display = 'block';
  
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentLoans = loans.slice(startIndex, endIndex);
  
    currentLoans.forEach(loan => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${loan.name}</td>
        <td>${loan.loanType}</td>
        <td>${loan.description}</td>
      `;
      loanTableBody.appendChild(row);
    });
  
    const totalPages = Math.ceil(loans.length / itemsPerPage);
    const currentPageNum = document.getElementById('currentPageNum');
    currentPageNum.innerHTML = `<a class="page-link" href="#">${currentPage}</a>`;
  
    const prevPageBtn = document.getElementById('prevPageBtn');
    const nextPageBtn = document.getElementById('nextPageBtn');
  
    prevPageBtn.addEventListener('click', () => {
      if (currentPage > 1) {
        currentPage--;
        displayLoanTable(loans);
      }
    });
  
    nextPageBtn.addEventListener('click', () => {
      if (currentPage < totalPages) {
        currentPage++;
        displayLoanTable(loans);
      }
    });
  }
  
  // Function to filter loans based on search input
  function filterLoans(searchTerm) {
    const filteredLoans = loanData.filter(loan =>
      loan.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      loan.loanType.toLowerCase().includes(searchTerm.toLowerCase())
    );
    currentPage = 1; // Reset to first page
    displayLoanTable(filteredLoans);
  }
  
  // Event listeners
  document.getElementById('allLoansLink').addEventListener('click', (e) => {
    e.preventDefault();
    currentPage = 1; // Reset to first page
    displayLoanTable(loanData);
  });
  
  document.getElementById('searchBtn').addEventListener('click', () => {
    const searchTerm = document.getElementById('searchInput').value;
    filterLoans(searchTerm);
  });