<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Product Management Tool">
    <meta name="author" content="Tebogo Mkhize">
    <title>Admin Product Management Tool | Login</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/styles.css">
  </head>
  <body>
    <header class="d-flex align-items-center p-3">
      <img src="assets/img/logo.png" alt="logo" class="me-2">
      <h6 class="poppins-semibold">Product Management Tool</h6>
    </header>

    <!-- Login Form Section -->
    <div class="container d-flex justify-content-center align-items-center ">
        <div class="col-md-6">
            <div class="card p-4 mt-3">
                <div class="text-center">
                    <h2 class="poppins-semibold">Hi, Welcome Back</h2>
                    <h5 class="poppins-light text-muted">Please enter your details</h5>
                </div>

                <!-- Login Form -->
                <form id="login-form" action="login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label poppins-medium">Username <span class="required">*</span></label>
                        <input type="text" class="form-control" name="username" placeholder="Enter Username" required>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label poppins-medium">Password <span class="required">*</span></label>
                        <input type="password" class="form-control" name="password" placeholder="Enter Password" required>
                    </div>

                    <button type="submit" class="btn btn-dark w-100">Login</button>

                    <div class="text-center mt-2">
                        <a href="#">Forgot Password?</a>
                    </div>

                    <div class="text-center mt-2">
                        <a href="signup.jsp">Don't Have an Account? Sign Up</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>