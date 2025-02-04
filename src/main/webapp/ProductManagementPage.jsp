<%@ page import="java.util.List" %>
<%@ page import="org.tebogomkhize.projects.dataaccess.entity.Product" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Product Management Tool">
    <meta name="author" content="Tebogo Mkhize">
    <title>Admin Product Management Tool | Home</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/styles.css">
  </head>
  <body>
    <header class="d-flex align-items-center p-3">
        <img src="assets/img/logo.png" alt="logo" class="me-2">
        <h6 class="poppins-semibold">Product Management Tool</h6>
        <a href="index.jsp" class="btn btn-dark btn-sm ms-auto">Logout</a>
    </header>

    <div class="container mt-4">

      <a href="product" class="mb-3 fs-4 text-dark fw-bold">Manage Products</a>

      <!-- Add Product Form -->
      <h5 class="poppins-light text-muted">Please enter product details to add to stock</h5>

      <!-- enctype = "multipart/form-data" required to process images, etc. Converts into bytes. -->
      <form action="product" method="post" enctype="multipart/form-data" class="mb-4">
          <div class="row">
              <div class="col-md-3">
                  <input type="text" name="title" class="form-control" placeholder="Product Title" required>
              </div>
              <div class="col-md-2">
                  <input type="number" name="quantity" class="form-control" placeholder="Quantity" required>
              </div>
              <div class="col-md-2">
                  <input type="text" name="size" class="form-control" placeholder="Size (e.g., M, L, XL)" required>
              </div>
              <div class="col-md-3">
                  <input type="file" name="image" class="form-control" required>
              </div>
              <div class="col-md-2">
                  <button type="submit" class="btn btn-dark w-100">Add Product</button>
              </div>
          </div>
      </form>

      <!-- Product List Table -->
      <table class="table table-bordered">
          <thead class="table-dark">
              <tr>
                  <th>ID</th>
                  <th>Title</th>
                  <th>Quantity</th>
                  <th>Size</th>
                  <th>Image</th>
                  <th>Actions</th>
              </tr>
          </thead>
          <tbody>
              <%
                  List<Product> products = (List<Product>) request.getAttribute("products");
                  if (products != null && !products.isEmpty()) {
                      for (Product product : products) {
              %>
                          <tr>
                              <td><%= product.getId() %></td>
                              <td><%= product.getTitle() %></td>
                              <td><%= product.getQuantity() %></td>
                              <td><%= product.getSize() %></td>
                              <td><img src="image?id=<%= product.getId() %>" width="50"></td>
                              <td>
                                  <a href="product?action=edit&id=<%= product.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                                  <a href="product?action=delete&id=<%= product.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                              </td>
                          </tr>
              <%
                      }
                  } else {
              %>
                  <tr><td colspan="6" class="text-center">No products available</td></tr>
              <% } %>
          </tbody>

      </table>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>