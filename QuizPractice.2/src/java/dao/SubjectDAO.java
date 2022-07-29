/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import model.Subject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class SubjectDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAO();
        System.out.println(dao.getAllSubjects());
    }

    public ArrayList<Subject> getAllSubjcet() {
        ArrayList<Subject> listSubject = new ArrayList<>();
        String query = "select * from Subject";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                listSubject.add(subject);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listSubject;
    }

    public void setNewSubject(Subject subject) {
        String query = "INSERT INTO [dbo].[Subject]\n"
                + "           ([subjectName]\n"
                + "           ,[thumbnail]\n"
                + "           ,[description])\n"
                + "     VALUES (?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, subject.getSubjectName());
            ps.setString(2, subject.getImage());
            ps.setString(3, subject.getDescription());
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Subject> getAllSubjects() {
        ArrayList<Subject> list = new ArrayList<>();
        String query = "SELECT S.subjectId, S.subjectName, S.thumbnail ,S.[description]\n"
                + "FROM [Subject] S";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
