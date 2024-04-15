// Sample loan data
const loanData = [
    { id: 1, name: 'Personal Loan', description: 'A loan for personal use, such as debt consolidation, home improvements, or unexpected expenses.' },
    { id: 2, name: 'Home Loan', description: 'A loan for purchasing a new home or refinancing an existing mortgage.' },
    { id: 3, name: 'Auto Loan', description: 'A loan for purchasing a new or used vehicle.' },
    { id: 4, name: 'Business Loan', description: 'A loan for starting or expanding a business.' },
    { id: 5, name: 'Student Loan', description: 'A loan for financing educational expenses, such as tuition, books, and housing.' },
    { id: 6, name: 'Debt Consolidation Loan', description: 'A loan that combines multiple existing debts into a single loan with a lower interest rate.' },
    { id: 7, name: 'Home Equity Loan', description: 'A loan that uses the equity in your home as collateral.' },
    { id: 8, name: 'Personal Line of Credit', description: 'A revolving line of credit for personal use, similar to a credit card.' },
];

// Function to display loan cards
function displayLoanCards(loans) {
    const loanCardContainer = document.getElementById('loan-card-container');
    loanCardContainer.innerHTML = '';

    const mainContent = document.getElementById('main-content');
    mainContent.style.display = 'none'; // Hide the main content

    loans.forEach(loan => {
        const loanCard = document.createElement('div');
        loanCard.classList.add('loan-card');
        loanCard.textContent = loan.name;

        const loanDescription = document.createElement('div');
        loanDescription.classList.add('loan-description');
        loanDescription.textContent = loan.description;

        loanCard.appendChild(loanDescription);

        loanCard.addEventListener('click', () => {
            loanDescription.style.display = loanDescription.style.display === 'none' ? 'block' : 'none';
        });

        loanCardContainer.appendChild(loanCard);
    });
}

// Function to filter loans based on search input
function filterLoans(searchTerm) {
    const filteredLoans = loanData.filter(loan =>
        loan.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
    displayLoanCards(filteredLoans);
}

// Event listeners
document.getElementById('allLoansLink').addEventListener('click', (e) => {
    e.preventDefault(); // Prevent the link from navigating
    displayLoanCards(loanData);
});

document.getElementById('searchBtn').addEventListener('click', () => {
    const searchTerm = document.getElementById('searchInput').value;
    filterLoans(searchTerm);
});

// Clear loan cards and show main content on initial load
const loanCardContainer = document.getElementById('loan-card-container');
loanCardContainer.innerHTML = '';
const mainContent = document.getElementById('main-content');
mainContent.style.display = 'block'; // Show the main content