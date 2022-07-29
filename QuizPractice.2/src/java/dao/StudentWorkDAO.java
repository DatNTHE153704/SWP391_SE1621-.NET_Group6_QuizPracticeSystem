/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.StudentWork;

/**
 *
 * @author ASUS
 */
public class StudentWorkDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void setStudentWork(StudentWork studentWork) {

        if (studentWork.getOptionId() != 0) {
            String query = "INSERT INTO [dbo].[StudentWork]\n"
                    + "           ([userId]\n"
                    + "           ,[quizResultId]\n"
                    + "           ,[questionId]\n"
                    + "           ,[optionId])\n"
                    + "     VALUES (?,?,?,?)";

            try {
                con = new DBContext().getConnection();
                ps = con.prepareStatement(query);

                ps.setInt(1, studentWork.getUserId());
                ps.setInt(2, studentWork.getQuizResultId());
                ps.setInt(3, studentWork.getQuestionId());
                ps.setInt(4, studentWork.getOptionId());

                ps.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            String query = "INSERT INTO [dbo].[StudentWork]([userId],"
                    + "[quizResultId],[questionId],[optionId])"
                    + " VALUES (?,?,?,NULL)";
            try {
                con = new DBContext().getConnection();
                ps = con.prepareStatement(query);

                ps.setInt(1, studentWork.getUserId());
                ps.setInt(2, studentWork.getQuizResultId());
                ps.setInt(3, studentWork.getQuestionId());
                ps.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public StudentWork getOptionSelected(int quizResultId, int questionId) {
        String query = "SELECT SW.studentWorkId, SW.userId, SW.quizResultId,\n"
                + "SW.questionId, SW.optionId\n"
                + "FROM StudentWork SW\n"
                + "WHERE SW.quizResultId = ? and SW.questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizResultId);
            ps.setInt(2, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentWork sw = new StudentWork(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                return sw;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<StudentWork> getAllStudentWorkByQuizResultId(int quizResultId) {
        ArrayList<StudentWork> list = new ArrayList<>();
        String query = "SELECT SW.studentWorkId, SW.userId, SW.quizResultId,\n"
                + "SW.questionId, SW.optionId\n"
                + "FROM StudentWork SW\n"
                + "WHERE SW.quizResultId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizResultId);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentWork sw = new StudentWork(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                list.add(sw);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteStudentWorkByQuestionId(int questionId) {
        String query = "DELETE FROM [dbo].[StudentWork]\n"
                + "      WHERE questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, questionId);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void deleteStudentWorkByQuestionId(String questionId) {
        String query = "DELETE FROM [dbo].[StudentWork]\n"
                + "      WHERE questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, questionId);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
