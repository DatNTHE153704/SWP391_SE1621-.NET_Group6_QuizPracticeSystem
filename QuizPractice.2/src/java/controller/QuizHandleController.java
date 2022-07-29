/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.TimeLogic;
import model.*;

/**
 *
 * @author DELL
 */
//@WebServlet(name = "QuizHandleController", urlPatterns = {"/QuizHandle"})
public class QuizHandleController extends HttpServlet {

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
        int quizId = Integer.parseInt(request.getParameter("quizId").toString());
        ses.setAttribute("quizId",quizId );

        //int quizId = 1;
        QuizDAO daoQuiz = new QuizDAO();
        QuestionDAO daoQuestion = new QuestionDAO();
        OptionDAO daoOption = new OptionDAO();

        Quiz quiz = daoQuiz.getQuizByQuizId(quizId);
        ArrayList<Question> listQuestion = daoQuestion.getListQuestion(quizId);
        ArrayList<Option> listOption = daoOption.getListOption(quizId);

        Time time = quiz.getQuizDuration();

        request.setAttribute("hour", time.getHours());
        request.setAttribute("minus", time.getMinutes());
        request.setAttribute("second", time.getSeconds());

        request.setAttribute("quiz", quiz);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("listOption", listOption);
        request.setAttribute("quizId", quizId);

        request.getRequestDispatcher("view/quizHandle.jsp").forward(request, response);
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
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        QuizDAO daoQuiz = new QuizDAO();
        Quiz quiz = daoQuiz.getQuizByQuizId(quizId);

        QuestionDAO daoQuestion = new QuestionDAO();
        ArrayList<Question> listQuestion = daoQuestion.getListQuestion(quizId);
        ArrayList<Option> listOptionChoose = new ArrayList<>();
        double correctQuestion = 0;
        OptionDAO daoOption = new OptionDAO();
        Option option = new Option();

        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("user");
//        int userId = 7;

        for (Question question : listQuestion) {
            String questionId = String.valueOf(question.getQuestionId());
            String[] listOption = request.getParameterValues(questionId);
            if (listOption != null) {
                option = daoOption.getOptionById(listOption[0]);
                listOptionChoose.add(option);
                if (option.isIsCorrect()) {
                    correctQuestion++;
                }
            }
        }
        StudentWorkDAO daoStudentWork = new StudentWorkDAO();

        int hour = Integer.parseInt(request.getParameter("hour"));
        int minus = Integer.parseInt(request.getParameter("minus"));
        int second = Integer.parseInt(request.getParameter("second"));

        TimeLogic timeLogic = new TimeLogic();
        Time timeEnd = new Time(hour, minus, second);
        Time time = timeLogic.subTwoTime(quiz.getQuizDuration(), timeEnd);

        double score = correctQuestion / listQuestion.size()*100;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp date = new Timestamp(System.currentTimeMillis());
//        QuizResult quizResult = new QuizResult(userId, quizId, score,time , date);
        QuizResult quizResult = new QuizResult(user.getUserId(), quizId, score, time, date);

        QuizResultDAO daoQuizResult = new QuizResultDAO();
        daoQuizResult.setQuizResult(quizResult);
        QuizResult quizResultGet = new QuizResult();
        StudentWork studentWork = new StudentWork();
       StudentWorkDAO studentWorkDAO = new StudentWorkDAO();
        quizResultGet = daoQuizResult.getQuizResultByUserIdAndSubmitAt(quizResult);
        System.out.println("id" + quizResultGet.getQuizResultId());
        for (Question q : listQuestion) {
            boolean checkHaveChooseOption = false;

            for (Option option1 : listOptionChoose) {
                if (option1.getQuestionId() == q.getQuestionId()) {
                    studentWork = new StudentWork(user.getUserId(), quizResultGet.getQuizResultId(), option1.getQuestionId(), option1.getOptionId());
                    studentWorkDAO.setStudentWork(studentWork);
                    checkHaveChooseOption = true;
                }
            }
            if (!checkHaveChooseOption) {
                studentWork = new StudentWork(user.getUserId(), quizResultGet.getQuizResultId(), q.getQuestionId(),0);
                studentWorkDAO.setStudentWork(studentWork);

            }
        }

        response.sendRedirect("quizReview?quizResultId=" + quizResultGet.getQuizResultId());

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
