package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buyers")
public class BuyersServlet extends HttpServlet {
    private DatabaseHelper dbHelper;

    @Override
    public void init() throws ServletException {
        super.init();
        dbHelper = new DatabaseHelper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Buyer> buyers = dbHelper.getAllBuyers();
        request.setAttribute("buyers", buyers);
        request.getRequestDispatcher("/buyers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int buyerId = Integer.parseInt(request.getParameter("buyerId"));

        // Creating a new Buyer object
        Buyer newBuyer = new Buyer(buyerId, name, email);

        // Adding the new buyer to the database
        dbHelper.addBuyer(newBuyer);

        // Redirecting back to the buyers page
        response.sendRedirect(request.getContextPath() + "/buyers");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extracting buyer information from request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Create a Buyer object with updated information
        Buyer updatedBuyer = new Buyer(id, name, email);

        // Update the buyer in the database
        dbHelper.updateBuyer(updatedBuyer);

        // Redirect back to the buyers page
        response.sendRedirect(request.getContextPath() + "/buyers");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extracting buyer ID from request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        // Delete the buyer from the database
        dbHelper.deleteBuyer(id);

        // Redirect back to the buyers page
        response.sendRedirect(request.getContextPath() + "/buyers");
    }
}

