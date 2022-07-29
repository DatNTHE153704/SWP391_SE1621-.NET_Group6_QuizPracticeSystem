/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.emptyType;
import dao.OptionDAO;
import dao.QuestionDAO;
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
public class UpdateQuestionAdminController extends HttpServlet {

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
        QuestionDAO question = new QuestionDAO();
        OptionDAO op = new OptionDAO();

        String nameQuesttion = request.getParameter("nameQuestion");
        String explanation = request.getParameter("exp");
        String media = request.getParameter("media");
        String oldMedia = request.getParameter("mediaa");
        String index = session.getAttribute("index").toString();
        request.setAttribute("index", index);

        String[] option = {request.getParameter("option1"), request.getParameter("option2"), request.getParameter("option3"),
            request.getParameter("option4")};

        String correctAnswer = request.getParameter("correctA");
        int selectCorrectAnswer = Integer.parseInt(correctAnswer);

        String opId = session.getAttribute("opId").toString();
        String questionId = session.getAttribute("questionId").toString();
        int opIdd = Integer.parseInt(opId);

        if (media.length() == 0 && oldMedia.length() == 0) {
            question.updateQuestion(questionId, nameQuesttion, null, explanation);
        } else if (media.length() == 0) {
            question.updateQuestion(questionId, nameQuesttion, oldMedia, explanation);
        } else {
            question.updateQuestion(questionId, nameQuesttion, media, explanation);
        }

        for (int i = 0; i <= option.length - 1; i++) {
            if (i == (selectCorrectAnswer - 1)) {
                op.updateOption(questionId, opIdd, option[i], "True");
            } else {
                op.updateOption(questionId, opIdd, option[i], "False");
            }
            opIdd++;
        }
        String status = session.getAttribute("status").toString();
        if (status == "admin") {
            response.sendRedirect("ManagermentQuestion?index=" + index);
        } else if (status == "search") {
            response.sendRedirect("searchQuestion?index=" + index);
        } else if (status == "filter") {
            response.sendRedirect("FilterQuestion");
        }
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
