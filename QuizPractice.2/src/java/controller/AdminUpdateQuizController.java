/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import dao.QuizDAO;
import dao.QuizLevelDAO;
import dao.SubjectDAO;
import dao.UserDAO;
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
import model.Question;
import model.Quiz;
import model.QuizLevel;
import model.Subject;
import model.User;

/**
 *
 * @author DELL
 */
public class AdminUpdateQuizController extends HttpServlet {

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
        SubjectDAO subjectDao = new SubjectDAO();
        QuizLevelDAO quizlevel = new QuizLevelDAO();
        UserDAO userDao = new UserDAO();

        ArrayList<Subject> listS = subjectDao.getAllSubjcet();
        ArrayList<QuizLevel> listL = quizlevel.getAllQuizLevel();
        request.setAttribute("listSubject", listS);
        request.setAttribute("listQuizLevel", listL);

        String quizId = request.getParameter("quizId");
        Quiz quiz = quizDao.getQuizByID(quizId);
        ArrayList<Question> listQuestion = new ArrayList<>();
        listQuestion = questionDao.getAllQuestionsByQuizId(Integer.parseInt(quizId));
        request.setAttribute("quiz", quiz);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("hour", quiz.getQuizDuration().getHours());
        request.setAttribute("minus", quiz.getQuizDuration().getMinutes());
        request.setAttribute("second", quiz.getQuizDuration().getSeconds());
        request.getRequestDispatcher("view/adminUpdateQuiz.jsp").forward(request, response);

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

        String quizName = request.getParameter("quizName");
        int subjectId = Integer.parseInt(request.getParameter("subject"));
        int quizLevelId = Integer.parseInt(request.getParameter("level"));
        int hour = Integer.parseInt(request.getParameter("hour"));
        int minus = Integer.parseInt(request.getParameter("minus"));
        int second = Integer.parseInt(request.getParameter("second"));
        Time quizDuration = new Time(hour, minus, second);
        String description = request.getParameter("description");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        int quizId = Integer.parseInt(request.getParameter("quizId"));
 HttpSession ses = request.getSession();
            User user = (User) ses.getAttribute("user");
        QuizDAO quizDao = new QuizDAO();
        quizDao.updateQuiz(quizId,user.getUserId(), quizName, quizDuration, subjectId, quizLevelId, description, date);
        request.getRequestDispatcher("AdminQuizController").forward(request, response);
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
