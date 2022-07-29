/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class ChangePassController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("user");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        UserDAO userDAO = new UserDAO();

        request.setAttribute("emaiil", email);
        request.setAttribute("password", password);
        request.setAttribute("rePassword", rePassword);
        if (!email.equals(user.getEmail())) {
            request.setAttribute("message", "Email incorrect!!!");
            request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
            return;
        }

        if (!userDAO.checkEmail(email)) {
            request.setAttribute("message", "Email not exist");
            request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
            return;
        }
        if (!password.equals(rePassword)) {
            request.setAttribute("message", "Re Password not match");
            request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
            return;
        }
        user.setEmail(email);
        user.setPassword(password);
        userDAO.changePassword(user);
        session.setAttribute("user", user);
        request.setAttribute("message", "Update success");
        request.getRequestDispatcher("view/changePass.jsp").forward(request, response);
        return;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangePassController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangePassController.class.getName()).log(Level.SEVERE, null, ex);
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
