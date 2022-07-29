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
import model.Quiz;

/**
 *
 * @author nguye
 */
public class inforQuestionOfExpertController extends HttpServlet {

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
        String questionId = request.getParameter("inforQ");
        String quizId = request.getParameter("quizID");

        QuestionDAO question = new QuestionDAO();
        OptionDAO option = new OptionDAO();
        QuizDAO dao = new QuizDAO();

        Quiz quiz = dao.getQuizByID(quizId);
        Question q = question.getQuestion(quizId, questionId);
        ArrayList<Option> optionById = option.getListOptionByID(quizId, questionId);

        String content = q.getContent();
        String Explanation = q.getExplanation();
        String img = q.getMedia();
        session.setAttribute("mediaa", img);

        int i;
        for (i = 0; i < optionById.size() - 1; i++) {
            if (optionById.get(i).isIsCorrect() == true) {
                break;
            }
        }
        session.setAttribute("opId", optionById.get(0).getOptionId());
        session.setAttribute("questionId", questionId);

        request.setAttribute("Question", content);
        request.setAttribute("explanation", Explanation);
        request.setAttribute("infor", quiz);
        request.setAttribute("img", img);
        request.setAttribute("op1", optionById.get(0).getContent());
        request.setAttribute("op2", optionById.get(1).getContent());
        request.setAttribute("op3", optionById.get(2).getContent());
        request.setAttribute("op4", optionById.get(3).getContent());
        request.setAttribute("answerCorrect", i + 1);
        request.setAttribute("optionId", optionById);

        String status = session.getAttribute("status").toString();
        if (status == "admin") {
            request.setAttribute("status", 1);
            request.getRequestDispatcher("view/informationQuestion.jsp").forward(request, response);
        } else if (status == "search") {
            request.setAttribute("status", 2);
            request.getRequestDispatcher("view/informationQuestion.jsp").forward(request, response);
        } else if (status == "filter") {
            request.setAttribute("status", 3);
            request.getRequestDispatcher("view/informationQuestion.jsp").forward(request, response);
        }
//        request.getRequestDispatcher("view/informationQuestion.jsp").forward(request, response);
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
