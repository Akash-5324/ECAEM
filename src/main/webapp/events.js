// Function to open the modal and display event details
let currentEventId;

function openModal(eventId, eventName) {
    document.getElementById("modal-title").textContent = `Confirm Booking for ${eventName}`;
    document.getElementById("modal-message").textContent = `Are you sure you want to book the event: ${eventName}?`;
    document.getElementById("eventId").value = eventId; // Set the event ID in the hidden input
    document.getElementById("confirmationModal").style.display = "flex"; // Show modal
    currentEventId = eventId; // Store event ID
}

// Function to close the modal
function closeModal() {
    document.getElementById("confirmationModal").style.display = "none"; // Hide modal
}

// Handle form submission and page reload
document.getElementById("bookForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission

    const eventId = document.getElementById("eventId").value;

    // Make AJAX request to book the event
    fetch('/bookevent', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `eventId=${eventId}`
    })
    .then(response => response.json()) // Parse JSON response
    .then(data => {
        if (data.success) {
            // Hide the confirmation modal after clicking "Confirm Booking"
            closeModal(); 

            // Show success message
            document.getElementById("successPopup").style.display = "block";
            
            // Hide the success message and reload page after 3 seconds
            setTimeout(() => {
                document.getElementById("successPopup").style.display = "none";
                location.reload(); // Reload page to reflect booking changes
            }, 3000);
        } else {
            alert(data.message); // Show failure message
        }
    })
    .catch(error => {
        console.error('Error:', error); // Log any error during fetch
        alert('An error occurred while booking the event.');
    });
});
