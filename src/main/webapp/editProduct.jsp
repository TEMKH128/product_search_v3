<%@ page import="org.tebogomkhize.projects.dataaccess.entity.Product" %>
<%
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        response.sendRedirect("product");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Edit Product">
    <meta name="author" content="Tebogo Mkhize">
    <title>Admin Product Management Tool | Edit Product</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>

    <header class="d-flex align-items-center p-3 bg-dark text-white">
        <h5 class="poppins-semibold">Edit Product</h5>
    </header>

    <div class="container mt-4">
        <h2 class="mb-3">Update Product</h2>

        <!-- Edit Product Form -->
        <form action="product?action=update" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= product.getId() %>"> <!-- Hidden ID Field -->

            <!-- Existing Image Preview -->
            <div class="mb-3">
                <label class="form-label">Current Image:</label><br>
                <img src="image?id=<%= product.getId() %>" width="100">
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" name="title" class="form-control" value="<%= product.getTitle() %>" required>
                </div>
                <div class="col-md-3 mb-3">
                    <label class="form-label">Quantity</label>
                    <input type="number" name="quantity" class="form-control" value="<%= product.getQuantity() %>" required>
                </div>
                <div class="col-md-3 mb-3">
                    <label class="form-label">Size</label>
                    <input type="text" name="size" class="form-control" value="<%= product.getSize() %>" required>
                </div>
            </div>

            <!-- Upload New Image -->
            <div class="mb-3">
                <label class="form-label">Upload New Image (Optional)</label>
                <input type="file" name="image" class="form-control">
            </div>

            <button type="submit" class="btn btn-success">Update Product</button>
            <a href="product" class="btn btn-secondary">Cancel</a>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>