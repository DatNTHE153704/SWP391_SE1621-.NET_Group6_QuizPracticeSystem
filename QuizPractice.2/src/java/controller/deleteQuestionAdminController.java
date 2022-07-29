/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
import dao.StudentWorkDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class deleteQuestionAdminController extends HttpServlet {

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
        HttpSession session = request.getSession();

//        String index = session.getAttribute("index").toString();
//        if(index == null){
//            index = "1";
//        }
        String deleteId = request.getParameter("deleteId");
        String quizID = request.getParameter("quizID");
        String index = request.getParameter("indexP");

        QuestionDAO q = new QuestionDAO();
        OptionDAO op = new OptionDAO();
        StudentWorkDAO std = new StudentWorkDAO();

        std.deleteStudentWorkByQuestionId(deleteId);
        op.deleteOptionById(deleteId);
        q.deleteQuestionById(deleteId);

//        String QuizId = q.getQuizId(deleteId);
        int numberQ = q.getTotalQuestion(quizID);
        q.updateNumberQuestion(numberQ, quizID);

        String status = session.getAttribute("status").toString();
        if (status == "admin") {
            response.sendRedirect("ManagermentQuestion?index=" + index);
        } else if (status == "search") {
            response.sendRedirect("searchQuestion?index=" + index);
        } else if (status == "filter") {
            response.sendRedirect("FilterQuestion");
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
