/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
import dao.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Option;
import model.Question;

/**
 *
 * @author nguye
 */
public class ManagerQuestion extends HttpServlet {

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
        int quizId = 0;
        HttpSession session = request.getSession();
        String id = request.getParameter("quizId");
        if (id != null) {
            quizId = Integer.parseInt(id);
            session.setAttribute("quizID", quizId);
        } else {
            String a = session.getAttribute("quizID").toString();
            quizId = Integer.parseInt(a);
        }

        QuestionDAO daoQuestion = new QuestionDAO();
        OptionDAO daoOption = new OptionDAO();
        QuizDAO quiz = new QuizDAO();

        ArrayList<Question> listQuestion = daoQuestion.getListQuestion(quizId);
        ArrayList<Option> listOption = daoOption.getListOption(quizId);

//      
        request.setAttribute("alert", "1");
        request.setAttribute("quizName", quiz.getQuizByQuizId(quizId));
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listOption", listOption);
        request.getRequestDispatcher("view/managementQuestion.jsp").forward(request, response);
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
