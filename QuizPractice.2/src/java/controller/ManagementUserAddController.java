/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class ManagementUserAddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("re-password");
        boolean gender = request.getParameter("gender").equalsIgnoreCase("Male") ? true : false;
        Date dob = Date.valueOf(request.getParameter("dob"));
        int roleId = Integer.parseInt(request.getParameter("role"));

        UserDAO userDAO = new UserDAO();

        //Check Username exist
        if (userDAO.getUserByName(userName) != null) {
            request.setAttribute("msg1", "case1");
        }
        //Check Email exist
        if (userDAO.getUserByEmail(email) != null) {
            request.setAttribute("msg2", "case2");
        }

        //Check password and confirm password match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("msg3", "case3");
        }
        if (userDAO.getUserByName(userName) != null || userDAO.getUserByEmail(email) != null || !password.equals(confirmPassword)) {
            request.getRequestDispatcher("managementUser").forward(request, response);
        } else {
            userDAO.addNewUser(userName, email, password, gender, dob, roleId);
            response.sendRedirect("managementUser");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
