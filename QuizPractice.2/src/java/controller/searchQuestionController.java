/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Question;
import model.Quiz;

/**
 *
 * @author nguye
 */
public class searchQuestionController extends HttpServlet {

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
        HttpSession session = request.getSession();
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        session.setAttribute("index", index);
        String value = request.getParameter("value");
        if (value != null) {
            session.setAttribute("valueSearch", value);
        } else {
            value = session.getAttribute("valueSearch").toString();
        }

        QuizDAO dao = new QuizDAO();
        QuestionDAO daoQuestion = new QuestionDAO();

        ArrayList<Quiz> list = dao.getAllQuiz();
        ArrayList<Question> listQuestion = daoQuestion.getAllSearchedQuestion(index, value);

        int countQuestionSearch = daoQuestion.countTotalQuestionSearched(value);
        int numberPage = daoQuestion.numberOfPagesSearched(countQuestionSearch);

        request.setAttribute("totalQuestion", listQuestion.size());
        if (listQuestion.size() == 0) {
            request.setAttribute("msg", "No results found for '" + value + "'");
        } else {
            request.setAttribute("numberP", numberPage);
        }
        request.setAttribute("check", value);
        request.setAttribute("alert", indexPage);
        request.setAttribute("lisQuiz", list);
        request.setAttribute("AllQuestion", listQuestion);
        request.setAttribute("tagP", index);

        session.setAttribute("status", "search");
        request.getRequestDispatcher("view/adminQuestion.jsp").forward(request, response);
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
