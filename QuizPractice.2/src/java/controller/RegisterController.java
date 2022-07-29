/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import smtp.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ASUS
 */
public class RegisterController extends HttpServlet {

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
        //processRequest(request, response);
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
        //processRequest(request, response);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        boolean gender = request.getParameter("gender").equalsIgnoreCase("Male") ? true : false;
        Date dob = Date.valueOf(request.getParameter("dob"));
        UserDAO dao = new UserDAO();
        //Check username exist
        if (dao.getUserByName(username) != null) {
            request.setAttribute("msg1", "case1");
        }
        //Check email exist
        if (dao.getUserByEmail(email) != null) {
            request.setAttribute("msg2", "case2");
        }
        //Compare password and confirm password does not match
        if (!password.equalsIgnoreCase(repassword)) {
            request.setAttribute("msg3", "case3");
        }
        if (dao.getUserByName(username) != null || dao.getUserByEmail(email) != null 
                || !password.equalsIgnoreCase(repassword)) {
            request.getRequestDispatcher("view/register.jsp").forward(request, response);
        } else {
            //Insert new user to database
            dao.registerAccount(username, email, password, gender, dob);
            Email em = new Email();
            //Generate code
            String code = em.getRandomNumber();
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            em.sendEmail(email, "Verify Your Code", "Hello !", code);
            //Update code
            dao.updateCode(code, email);
            response.sendRedirect("verify");
        }
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
