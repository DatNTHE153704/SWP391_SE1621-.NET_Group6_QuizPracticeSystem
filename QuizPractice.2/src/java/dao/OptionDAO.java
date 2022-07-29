/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.*;

/**
 *
 * @author ASUS
 */
public class OptionDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Option> getListOption(int quizId) {
        ArrayList<Option> listOption = new ArrayList<>();
        String query = "select o.*  from [Option] as o\n"
                + "left outer join Question as q\n"
                + "on q.questionId=o.questionId\n"
                + "where q.quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Option option = new Option(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4));
                listOption.add(option);
            }
        } catch (Exception e) {

        }
        return listOption;
    }

    public Option getOptionById(String string) {
        int quizId = Integer.parseInt(string);
        Option option = new Option();
        String query = "select *  from [Option]  where optionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                option = new Option(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception e) {

        }
        return option;

    }

    public ArrayList<Option> getAllOptionsByQuestionId(int questionId) {
        ArrayList<Option> list = new ArrayList<>();
        String query = "SELECT optionId, questionId, content, isCorrect\n"
                + "FROM [Option]\n"
                + "WHERE questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Option option = new Option(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4));
                list.add(option);
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return list;
    }

    public void deleteOptionByQuestionId(int questionId) {
        String query = "DELETE FROM [dbo].[Option]\n"
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

    public void addNewOption(int questionID, String content, String isCorrect) {
        String sql = "insert into [dbo].[Option]\n"
                + "([questionId],[content],[isCorrect])\n"
                + "values(?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, questionID);
            ps.setString(2, content);
            ps.setString(3, isCorrect);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteOptionById(String deleteId) {
        String sql = "delete from [Option]\n"
                + "where questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, deleteId);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Option> getListOptionByID(String quizId, String questionId) {
        ArrayList<Option> listOption = new ArrayList<>();
        String query = "select o.*  from [Option] as o\n"
                + "left outer join Question as q\n"
                + "on q.questionId=o.questionId\n"
                + "where q.quizId = ? and q.questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizId);
            ps.setString(2, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Option option = new Option(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getBoolean(4));
                listOption.add(option);
            }
        } catch (Exception e) {

        }
        return listOption;
    }

    public void updateOption(String questionID, int optionId, String content, String isCorrect) {
        String sql = "update [dbo].[Option]\n"
                + "      set [content] = ?,\n"
                + "          [isCorrect] = ?\n"
                + "     where questionId = ?\n"
                + "	 and optionId = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, content);
            ps.setString(2, isCorrect);
            ps.setString(3, questionID);
            ps.setInt(4, optionId);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
