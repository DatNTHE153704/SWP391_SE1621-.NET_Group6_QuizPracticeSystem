/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import dao.QuizLevelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
public class AddQuizExpertController extends HttpServlet {

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
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        ArrayList<Subject> listS = subjectDao.getAllSubjcet();
        ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();
        request.setAttribute("listSubject", listS);
        request.setAttribute("listQuizLevel", listL);
        request.setAttribute("numberQuestion", 0);
        request.getRequestDispatcher("view/addQuizDetailAndQuestion.jsp").forward(request, response);
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
        boolean checkName = true;
        QuizDAO quizDao = new QuizDAO();
        String quizName = request.getParameter("quizName");
        for (Quiz q : quizDao.getAllQuiz()) {
            if (q.getQuizName().equals(quizName)) {
                checkName = false;
                break;
            }
        }
        if (checkName) {

            HttpSession ses = request.getSession();
            User user = (User) ses.getAttribute("user");
            int subjectId = Integer.parseInt(request.getParameter("subject"));
            int quizLevelId = Integer.parseInt(request.getParameter("level"));
            int hour = Integer.parseInt(request.getParameter("hour"));
            int minus = Integer.parseInt(request.getParameter("minus"));
            int second = Integer.parseInt(request.getParameter("second"));
            Time quizDuration = new Time(hour, minus, second);
            String description = request.getParameter("description");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());

            quizDao.setNewQuiz(quizName, user.getUserId(), quizDuration, subjectId, quizLevelId, description, date);
            request.getRequestDispatcher("QuizListExpertController").forward(request, response);

//            quizDao.setNewQuiz(quizName, 3, quizDuration, subjectId, quizLevelId, description, date);
        } else {
            request.setAttribute("mess", "Quiz name is exist");
            request.setAttribute("check", false);
            SubjectDAO subjectDao = new SubjectDAO();
            QuizLevelDAO quizlevel = new QuizLevelDAO();
            UserDAO userDao = new UserDAO();
            ArrayList<Subject> listS = subjectDao.getAllSubjcet();
            ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();
            request.setAttribute("listSubject", listS);
            request.setAttribute("listQuizLevel", listL);
            request.setAttribute("numberQuestion", 0);
            request.getRequestDispatcher("view/addQuizDetailAndQuestion.jsp").forward(request, response);
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
