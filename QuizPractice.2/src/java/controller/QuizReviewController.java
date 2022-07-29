/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
import dao.QuizResultDAO;
import dao.StudentWorkDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Option;
import model.Question;
import model.QuizResult;
import model.StudentWork;

/**
 *
 * @author ASUS
 */
public class QuizReviewController extends HttpServlet {

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

        int quizResultId = Integer.parseInt(request.getParameter("quizResultId"));
        //int quizResultId = 3;

        QuizResultDAO quizResultDAO = new QuizResultDAO();
        QuizResult quizResult = quizResultDAO.getQuizResultById(quizResultId);
        //request.setAttribute("quizResult", quizResult);
        request.setAttribute("quizResultId", quizResultId);
        request.setAttribute("score", quizResult.getScore());
        request.setAttribute("time", quizResult.getTime());

        String submitAt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(quizResult.getSubmitAt());
        request.setAttribute("submitAt", submitAt);

        int questionNumber;
        //Check the position of the current question if null
        if (request.getParameter("questionNumber") == null) {
            //Set the position of the current question is 1
            questionNumber = 1;
        } else {
            questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
        }
        request.setAttribute("questionNumber", questionNumber);

        QuestionDAO questionDAO = new QuestionDAO();
        //Get all questions by quizId 
        ArrayList<Question> questions = questionDAO.getAllQuestionsByQuizId(quizResult.getQuizId());
        request.setAttribute("questions", questions);
        request.setAttribute("content", questions.get(questionNumber - 1).getContent());
        request.setAttribute("media", questions.get(questionNumber - 1).getMedia());
        request.setAttribute("explanation", questions.get(questionNumber - 1).getExplanation());
        request.setAttribute("totalQuestion", questions.size());

        OptionDAO optionDAO = new OptionDAO();
        //Get all options by questionId
        ArrayList<Option> options = optionDAO.getAllOptionsByQuestionId(questions.get(questionNumber - 1).getQuestionId());
        request.setAttribute("options", options);

        StudentWorkDAO studentWorkDAO = new StudentWorkDAO();
//        StudentWork studentWork = studentWorkDAO.getOptionSelected(quizResultId, questions.get(questionNumber - 1).getQuestionId());
//        request.setAttribute("studentWork", studentWork);
        
        //Get all studentWork by quizResultId
        ArrayList<StudentWork> allStudentWork = studentWorkDAO.getAllStudentWorkByQuizResultId(quizResultId);
        request.setAttribute("allStudentWork", allStudentWork);
        request.setAttribute("studentWork", allStudentWork.get(questionNumber-1));
        
        request.getRequestDispatcher("view/quizReview.jsp").forward(request, response);
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
