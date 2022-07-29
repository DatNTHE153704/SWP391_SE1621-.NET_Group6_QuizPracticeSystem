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
import model.QuizLevel;

/**
 *
 * @author ASUS
 */
public class QuizLevelDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<QuizLevel> getAllQuizLevel() {
        ArrayList<QuizLevel> list = new ArrayList<>();
        String query = "select * from QuizLevel";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizLevel QuizLevel = new QuizLevel(rs.getInt(1),
                        rs.getString(2));
                list.add(QuizLevel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public static void main(String[] args) {
        QuizLevelDAO DAO = new QuizLevelDAO();
        ArrayList<QuizLevel> list = DAO.getAllQuizLevel();

        for (QuizLevel quizLevel : list) {
            System.out.println(quizLevel);
        }
    }
}
