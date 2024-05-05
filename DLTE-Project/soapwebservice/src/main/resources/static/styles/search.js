// searchLoans.js
$(document).ready(() => {
    const getLoansByType = (loanType) => {
        $.ajax({
            url: `/mybank/filterLoans?loanType=${loanType}`, // Update the URL to match your controller method
            type: "GET",
            success: function(response) {
                let viewPart = $("#viewSection");
                viewPart.empty();
                if (Array.isArray(response)) {
                    response.forEach((loan) => {
                        // ... (existing code for creating loan cards)
                    });
                } else {
                    viewPart.append(`
                        <div class="alert alert-warning text-center display-2">
                            Error: Invalid response format
                        </div>
                    `);
                }
            },
            error: function(xhr, status, error) {
                let viewPart = $("#viewSection");
                viewPart.empty();
                viewPart.append(`
                    <div class="alert alert-warning text-center display-2">
                        Error: ${xhr.status} - ${error}
                    </div>
                `);
            }
        });
    };

    // Event listener for form submission
    $("#loanTypeForm").submit(function(event) {
        event.preventDefault();
        const loanType = $("#loanTypeInput").val();
        getLoansByType(loanType);
    });
});