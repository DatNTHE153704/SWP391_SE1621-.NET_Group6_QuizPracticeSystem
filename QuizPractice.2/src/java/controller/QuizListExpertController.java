/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import dao.QuizLevelDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;
import model.QuizLevel;
import model.Subject;
import model.User;

/**
 *
 * @author DELL
 */
public class QuizListExpertController extends HttpServlet {

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
        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("user");

        QuizDAO quizDao = new QuizDAO();
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        ArrayList<Quiz> list = quizDao.getAllQuizByOwnerId(user.getUserId());
//        ArrayList<Quiz> list = quizDao.getAllQuizByOwnerId(3);

        ArrayList<Subject> listS = subjectDao.getAllSubjcet();
        ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();

        ArrayList<Quiz> listSortName = quizDao.getAllQuizByOwnerIdAndSortName(user.getUserId());

        request.setAttribute("listQuizSortName", listSortName);

        request.setAttribute("typeSort", 1);
        request.setAttribute("listSubject", listS);
        request.setAttribute("quizLevel", listL);
        request.getRequestDispatcher("view/quizListExpert.jsp").forward(request, response);
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
        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("user");

        QuizDAO quizDao = new QuizDAO();
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        ArrayList<Quiz> list = quizDao.getAllQuizByOwnerId(user.getUserId());
//        ArrayList<Quiz> list = quizDao.getAllQuizByOwnerId(3);

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

        ArrayList<Quiz> listSortName = quizDao.getAllQuizByOwnerIdAndSortName(user.getUserId());
        ArrayList<Quiz> listSortNumber = quizDao.getAllQuizByOwnerIdAndSortNumberQuestion(user.getUserId());
        ArrayList<Quiz> listSortDuration = quizDao.getAllQuizByOwnerIdAndSortDuration(user.getUserId());

        request.setAttribute("listQuizSortName", listSortName);
        request.setAttribute("listQuizSortNumber", listSortNumber);
        request.setAttribute("listQuizSortDuration", listSortDuration);

        request.setAttribute("typeSort", number);
        request.setAttribute("listSubject", listS);
        request.setAttribute("quizLevel", listL);
        request.getRequestDispatcher("view/quizListExpert.jsp").forward(request, response);
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
