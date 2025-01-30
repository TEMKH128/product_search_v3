<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Product Management Tool">
    <meta name="author" content="Tebogo Mkhize">
    <title>Admin | Product Management Tool</title>
    <link rel="stylesheet" href="assets/css/styles.css">
  <head>
  <body>
    <header>
      <img src="assets/img/logo.png" alt="logo">
      <h2>Product Management Tool</h2>
    </header>

    <div class="container">
      <div class="form-details">
        <h2>Hi, Welcome Back</h2>
        <h5>Please enter your details</h5>
      </div>
      <form id="login-form">
        <fieldset>
          <label for="username"><span class="required">*</span> Username</label>
          <input type="text" placeholder="Enter Username" name="usename" class="make-block" required>
        </fieldset>

        <fieldset>
          <label for="password"><span class="required">*</span> Password</label>
          <input type="password" placeholder="Enter Password" name="password" class="make-block" required>
        </fieldset>      
        
        <!-- <button class="btn-1" type="submit">Login</button> -->
        <input type="submit" id="submit" class="btn-1 make-block" value="Login">

        <div class="inline-details">
          <a href="#">Sign Up</a>
          <a href="#">Forgot Password?</a>
        </div>
      </form>
    </div>
  </body>

</html>
