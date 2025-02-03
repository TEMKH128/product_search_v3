<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Product Management Tool">
    <meta name="author" content="Tebogo Mkhize">
    <title>Admin Product Management Tool | Signup</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/styles.css">
  </head>
  <body>
    <header class="d-flex align-items-center p-3">
      <img src="assets/img/logo.png" alt="logo" class="me-2">
      <h6 class="poppins-semibold">Product Management Tool</h6>
    </header>

    <!-- Signup Form Section -->
    <div class="container d-flex justify-content-center align-items-center ">
        <div class="col-md-10">
            <div class="card p-4 mt-3">
                <div class="text-center">
                    <h2 class="poppins-semibold">Signup for our Services</h2>
                    <div class="alert alert-danger text-center" role="alert">
                        <strong>Login Unsuccessful!</strong> Admin user not yet present.
                    </div>
                    <h5 class="poppins-light text-muted">Please enter your details</h5>
                </div>

                <!-- Signup Form -->
                <form id="signup-form" action="signup" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label poppins-medium">Username <span class="required">*</span></label>
                        <input type="text" class="form-control" name="username" placeholder="Enter Username" required>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label poppins-medium">Email <span class="required">*</span></label>
                        <input type="email" class="form-control" name="email" placeholder="Enter email" required>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label poppins-medium">Password <span class="required">*</span></label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Create Password" required>
                    </div>

                    <div class="mb-3">
                        <label for="confirm-password" class="form-label poppins-medium">Confirm Password <span class="required">*</span></label>
                        <input type="password" class="form-control" name="password" id="confirm-password" placeholder="Confirm Password" required>
                        <div class="invalid-feedback">Passwords must match</div>
                    </div>

                    <button type="submit" class="btn btn-dark w-100">Signup</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="assets/js/password-validation.js"></script>
  </body>
</html>
