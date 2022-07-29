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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class addQuestionController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        QuestionDAO q = new QuestionDAO();
        OptionDAO op = new OptionDAO();

        HttpSession session = request.getSession();
        String nameQuestion = request.getParameter("nameQ");
        int quizId = Integer.parseInt(session.getAttribute("quizID").toString());
        String explanation = request.getParameter("exp");
        String img = request.getParameter("img");
         if(img.length() != 0){
            img = request.getParameter("img");
        }else{
            img = null;
        }

        q.addNewQuestion(quizId, nameQuestion, img, explanation);
        int questionId = q.getLastIdQuestion();

        String[] option = {request.getParameter("op1"), request.getParameter("op2"), request.getParameter("op3"),
            request.getParameter("op4")};
        String correctAnswer = request.getParameter("ca");
        int selectCorrectAnswer = Integer.parseInt(correctAnswer);
        boolean a = false;

        for (int i = 0; i < option.length; i++) {
            if (i == (selectCorrectAnswer - 1)) {
                op.addNewOption(questionId, option[i], "True");
            } else {
                op.addNewOption(questionId, option[i], "False");
            }
        }

        String QuizId = session.getAttribute("quizID").toString();
        int numberQ = q.getTotalQuestion(QuizId);
        q.updateNumberQuestion(numberQ, QuizId);
        response.sendRedirect("ManagerQuestion");
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
