package org.example;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private DatabaseHelper dbHelper;

    @Override
    public void init() throws ServletException {
        super.init();
        dbHelper = new DatabaseHelper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = dbHelper.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantityAvailable = Integer.parseInt(request.getParameter("quantityAvailable"));

        // Create a new Product object
        Product newProduct = new Product(name, price, description, quantityAvailable);

        // Add the new product to the database
        dbHelper.addProduct(newProduct);

        // Redirect back to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extracting product information from request parameters
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int quantityAvailable = Integer.parseInt(request.getParameter("quantityAvailable"));

        // Creating a Product object with updated information
        Product updatedProduct = new Product(productId, name, price, description, quantityAvailable);

        // Update the product in the database
        dbHelper.updateProduct(updatedProduct);

        // Redirect back to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract product ID from request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete the product from the database
        dbHelper.deleteProduct(id);

        // Redirect back to the products page
        response.sendRedirect(request.getContextPath() + "/products");
    }
}

