    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OptionDAO;
import dao.QuestionDAO;
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

/**
 *
 * @author nguye
 */
public class inforQuestionToEditController extends HttpServlet {

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
        
        String questionId = request.getParameter("updateId");
        
        QuestionDAO question = new QuestionDAO();
        OptionDAO option = new OptionDAO();

        HttpSession session = request.getSession();
        String quizId = session.getAttribute("quizID").toString();
        Question q = question.getQuestion(quizId,questionId);
        ArrayList<Option> optionById = option.getListOptionByID(quizId, questionId);
        
        String content = q.getContent();
        String explannation = q.getExplanation();
        String img = q.getMedia();
        int i;
        for (i = 0; i <optionById.size()-1 ; i++) {
            if (optionById.get(i).isIsCorrect() == true) {
                break;
            }
        }
        
        session.setAttribute("opId",optionById.get(0).getOptionId());
        session.setAttribute("questionId", questionId);
//        request.setAttribute("id", questionId);
        request.setAttribute("Question", content);
        request.setAttribute("explanation", explannation);
        request.setAttribute("img", img);
        request.setAttribute("op1", optionById.get(0).getContent());
        request.setAttribute("op2", optionById.get(1).getContent());
        request.setAttribute("op3", optionById.get(2).getContent());
        request.setAttribute("op4", optionById.get(3).getContent());
        request.setAttribute("answerCorrect",i+1);
        request.setAttribute("optionId", optionById);
        
        request.getRequestDispatcher("view/editQuestion.jsp").forward(request, response);
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
