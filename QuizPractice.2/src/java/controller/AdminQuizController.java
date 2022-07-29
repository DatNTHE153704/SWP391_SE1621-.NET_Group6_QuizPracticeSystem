/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class AdminQuizController extends HttpServlet {

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
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        ArrayList<Quiz> list = quizDao.getAllQuiz();
        UserDAO userDao = new UserDAO();

        ArrayList<User> listExpert = userDao.getAllExpert();

        ArrayList<Subject> listS = subjectDao.getAllSubjcet();
        ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();

        ArrayList<Quiz> listSortName = quizDao.getAllQuizSortName();

        request.setAttribute("listQuizSortName", listSortName);
        request.setAttribute("listOwner", listExpert);
        request.setAttribute("typeSort", 1);
        request.setAttribute("listSubject", listS);
        request.setAttribute("quizLevel", listL);
        request.getRequestDispatcher("view/adminQuiz.jsp").forward(request, response);

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

        QuizDAO quizDao = new QuizDAO();
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        ArrayList<Quiz> list = quizDao.getAllQuiz();
        UserDAO userDao = new UserDAO();

        ArrayList<Subject> listS = subjectDao.getAllSubjcet();
        ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();

        String type = request.getParameter("Sort");
        int number = 1;
        if (type != null) {
            if (type.equals("number")) {
                number = 2;
            }
            if (type.equals("duration")) {
                number = 3;
            }
        }

        ArrayList<Quiz> listSortName = quizDao.getAllQuizSortName();
        ArrayList<Quiz> listSortNumber = quizDao.getAllQuizSortNumberQuestion();
        ArrayList<Quiz> listSortDuration = quizDao.getAllQuizSortDuration();
        ArrayList<User> listExpert = userDao.getAllExpert();

        request.setAttribute("listQuizSortName", listSortName);
        request.setAttribute("listQuizSortNumber", listSortNumber);
        request.setAttribute("listQuizSortDuration", listSortDuration);
        request.setAttribute("listOwner", listExpert);

        request.setAttribute("typeSort", number);
        request.setAttribute("listSubject", listS);
        request.setAttribute("quizLevel", listL);
        request.getRequestDispatcher("view/adminQuiz.jsp").forward(request, response);
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
