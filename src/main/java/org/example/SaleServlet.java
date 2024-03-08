package org.example;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sales")
public class SaleServlet extends HttpServlet {
    private DatabaseHelper dbHelper;
    private Date quantitySold;

    @Override
    public void init() throws ServletException {
        super.init();
        dbHelper = new DatabaseHelper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sale> sales = dbHelper.getAllSales();
        request.setAttribute("sales", sales);
        request.getRequestDispatcher("/sales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract sale information from request parameters
        int productId = Integer.parseInt(request.getParameter("productId"));
        int buyerId = Integer.parseInt(request.getParameter("buyerId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Create a new Sale object
        Sale newSale = new Sale(productId, buyerId, quantity);

        // Add the new sale to the database
        dbHelper.addSale(newSale);

        // Redirect back to the sales page
        response.sendRedirect(request.getContextPath() + "/sales");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract sale information from request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int buyerId = Integer.parseInt(request.getParameter("buyerId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Creatingg a Sale object with updated information
        Sale updatedSale = new Sale(id, productId, buyerId, quantitySold);

        // Update the sale in the database
        dbHelper.updateSale(updatedSale);

        // Redirect back to the sales page
        response.sendRedirect(request.getContextPath() + "/sales");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extracting sale ID from request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete the sale from the database
        dbHelper.deleteSale(id);

        // Redirect back to the sales page
        response.sendRedirect(request.getContextPath() + "/sales");
    }
}

