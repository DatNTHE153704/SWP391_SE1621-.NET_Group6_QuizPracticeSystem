/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class LoginController extends HttpServlet {

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
        request.getRequestDispatcher("view/login.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        //Check email doesn't exist
        if (dao.getUserByEmail(email) == null) {
            request.setAttribute("msg", "case1");
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        } else {
            //Check password incorrect
            if (dao.checkLogin(email, password) == null) {
                request.setAttribute("msg", "case2");
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            } else {
                //Check status ,not activated
                if (dao.getUserByEmail(email).getStatus() == 2) {
                    session.setAttribute("email", email);
                    response.sendRedirect("verify");
                } else if (dao.getUserByEmail(email).getStatus() == 3) {
                    request.setAttribute("msg", "case3");
                    request.getRequestDispatcher("view/login.jsp").forward(request, response);
                } else {
                    session.setAttribute("user", dao.getUserByEmail(email));
                    response.sendRedirect("home");
                }
            }
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
