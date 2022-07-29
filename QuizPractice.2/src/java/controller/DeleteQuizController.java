/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
import dao.QuizDAO;
import dao.QuizResultDAO;
import dao.StudentWorkDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
import model.StudentWork;

/**
 *
 * @author DELL
 */
public class DeleteQuizController extends HttpServlet {

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
        QuizDAO quizDao = new QuizDAO();
        QuestionDAO questionDao = new QuestionDAO();
        OptionDAO optionDao = new OptionDAO();
        StudentWorkDAO studentWorkDao = new StudentWorkDAO();
        QuizResultDAO quizResultDao = new QuizResultDAO();

        int quizId = Integer.parseInt(request.getParameter("quizId"));

        ArrayList<Question> listQuestion = questionDao.getListQuestion(quizId);

        for (Question question : listQuestion) {
             studentWorkDao.deleteStudentWorkByQuestionId(question.getQuestionId());
             optionDao.deleteOptionByQuestionId(question.getQuestionId());
             questionDao.deleteQuestionByQuestionId(quizId);
        }
        quizResultDao.deleteQuizResultByQuizId(quizId);

        
        quizDao.deleteQuizByQuizId(quizId);
        request.getRequestDispatcher("QuizListExpertController").forward(request, response);

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
