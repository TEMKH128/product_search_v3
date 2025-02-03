document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("signup-form");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirm-password");

    form.addEventListener('submit', function(event) {
        // Clear previous validation.
        confirmPassword.classList.remove("is-invalid");

        if (password.value !== confirmPassword.value) {
            confirmPassword.classList.add("is-invalid");
            event.preventDefault();  // Prevents form submission.
        }
    });
});