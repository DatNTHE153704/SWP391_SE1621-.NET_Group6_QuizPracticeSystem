/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;

/**
 *
 * @author DELL
 */
public class AdminAddSubjectController extends HttpServlet {

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
        request.getRequestDispatcher("view/adminAddNewSubject.jsp").forward(request, response);
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
        SubjectDAO subjectDao = new SubjectDAO();
        boolean checkName = true;
        String nameSubject = request.getParameter("name");
        for (Subject s : subjectDao.getAllSubjcet()) {
            if (s.getSubjectName().equals(nameSubject)) {
                checkName = false;
            }
        }
        if (checkName) {
            String image = request.getParameter("image");
            String description = request.getParameter("description");

            Subject subject = new Subject(nameSubject, description, image);
            subjectDao.setNewSubject(subject);
            request.getRequestDispatcher("AdminSubjectController").forward(request, response);
        } else {
            request.setAttribute("mess", "Quiz name is exist");
            request.setAttribute("check", false);
            request.getRequestDispatcher("view/adminAddNewSubject.jsp").forward(request, response);

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
