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
import model.Question;

/**
 *
 * @author ASUS
 */
public class QuestionDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        QuestionDAO dao = new QuestionDAO();
        ArrayList<Question> listQuestion = new ArrayList<>();
        int a = dao.countTotalQuestionSearched("who");
        System.out.println(a);
    }
//    }

    public ArrayList<Question> getListQuestion(int quizId) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        String query = "select * from Question where quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listQuestion.add(question);
            }
        } catch (Exception e) {

        }
        return listQuestion;
    }

    public ArrayList<Question> getAllQuestionsByQuizId(int quizId) {
        ArrayList<Question> list = new ArrayList<>();
        String query = "SELECT Q.questionId, Q.quizId, Q.content,\n"
                + "Q.media, Q.explanation\n"
                + "FROM Question Q\n"
                + "WHERE Q.quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteQuestionByQuestionId(int quizId) {
        String query = "DELETE FROM [dbo].[Question]\n"
                + "      WHERE quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewQuestion(int quizID, String content, String media, String explanation) {
        String sql = "insert into [Question]\n"
                + "([quizId],[content],[media],[explanation])\n"
                + "values(?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, quizID);
            ps.setString(2, content);
            ps.setString(3, media);
            ps.setString(4, explanation);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getLastIdQuestion() {
        String sql = "Select top 1 questionId from Question\n"
                + "	order by questionId desc";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void deleteQuestionById(String deleteId) {
        String sql = "delete from [Question]\n"
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

    public Question getQuestion(String quizId, String questionId) {
        String query = "select * from Question where quizId = ? and questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizId);
            ps.setString(2, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateQuestion(String questionId, String content, String media, String explanation) {
        String sql = "update [dbo].Question\n"
                + "set [content] = ?,\n"
                + "	[media] = ?,\n"
                + "	[explanation] = ?\n"
                + "	where questionId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, content);
            ps.setString(2, media);
            ps.setString(3, explanation);
            ps.setString(4, questionId);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getTotalQuestion(String id) {
        String sql = "select COUNT (*) from Question where quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void updateNumberQuestion(int numberQuestion, String quizId) {
        String sql = "update [dbo].[Quiz]\n"
                + "set [numberQuestion] = ? \n"
                + "where quizId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberQuestion);
            ps.setString(2, quizId);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int countTotalQuestionSearched(String search) {
        String sql = "select count(*) from Question\n"
                + "where content like ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int numberOfPagesSearched(int count) {
        if (count % 10 != 0) {
            return ((count / 10) + 1);
        } else {
            return count / 10;
        }
    }

    public int countTotalQuestion() {
        String sql = "select COUNT(*) from Question";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int numberOfPages() {
        int count = countTotalQuestion();
        if (count % 10 != 0) {
            return ((count / 10) + 1);
        } else {
            return count / 10;
        }
    }

    public ArrayList<Question> getAllQuestion(int index) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        String query = "select * from Question\n"
                + "Order by questionId DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listQuestion.add(question);
            }
        } catch (Exception e) {

        }
        return listQuestion;
    }

    public ArrayList<Question> getAllSearchedQuestion(int index, String search) {
        ArrayList<Question> listQuestion = new ArrayList<>();
        String query = "select * from Question as q\n"
                + "where q.content like ?\n"
                + "order by questionId desc\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ps.setInt(2, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listQuestion.add(question);
            }
        } catch (Exception e) {

        }
        return listQuestion;
    }

}
