/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author QuizPractice
 */
public class QuizDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        System.out.println(dao.getAllQuizzesByUserId(3));
    }

    public Quiz getQuizByQuizId(int quizId) {
        String query = "select * from Quiz where quizId = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(quizId, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getTime(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getDate(10));
                return quiz;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Quiz> getListLastFourQuiz() {
        String query = "select top 3 q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join [user] as u on q.ownerId=u.userId\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "order by quizId desc";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public int getTotalQuiz() {
        String sql = "select count (*) from Quiz";
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
        int count = getTotalQuiz();
        if (count % 9 != 0) {
            return ((count / 9) + 1);
        } else {
            return count;
        }
    }

    public ArrayList<Quiz> getAllQuiz(int index) {
        String query = "select q.* , u.userName , s.subjectName from Quiz as q\n"
                + "left outer join [User] as u on q.ownerId = u.userId\n"
                + "left outer join Subject as s on  q.subjectId = s.subjectId\n"
                + "order by quizId desc\n"
                + "OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizBySubject(String subjectID) {
        String query = "select q.* , u.userName , s.subjectName from Quiz as q\n"
                + "left outer join [User] as u on q.ownerId = u.userId\n"
                + "left outer join Subject as s on  q.subjectId = s.subjectId\n"
                + "where q.subjectId = ?\n"
                + "order by quizId desc";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, subjectID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizByLevel(String quizLevelId) {
        String query = "select q.* , u.userName , s.subjectName from Quiz as q\n"
                + "left outer join [User] as u on q.ownerId = u.userId\n"
                + "left outer join [Subject] as s on  q.subjectId = s.subjectId\n"
                + "where q.quizLevelId  = ?\n"
                + "order by quizId desc";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizLevelId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public Quiz getQuizByID(String id) {
        String query = "select q.* , u.userName , ql.quizLevelName , s.subjectName from Quiz as q\n"
                + "left outer join [User] as u on q.ownerId = u.userId\n"
                + "left outer join Subject as s on q.subjectId = s.subjectId\n"
                + "left outer join [QuizLevel] as ql on  q.quizLevelId = ql.quizLevelId\n"
                + "where q.quizId = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Quiz> getAllQuizByOwnerId(int ownerId) {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "where q.ownerId = ?";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, ownerId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public void setNewQuiz(String quizName, int userId, Time quizDuration, int subjectId, int quizLevelId, String description, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = formatter.format(date);
        String query = "INSERT INTO [dbo].[Quiz]\n"
                + "           ([quizName]\n"
                + "           ,[ownerId]\n"
                + "           ,[quizDuration]\n"
                + "           ,[numberQuestion]\n"
                + "           ,[subjectId]\n"
                + "           ,[quizLevelId]\n"
                + "           ,[description]\n"
                + "           ,[dateCreated])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizName);
            ps.setInt(2, userId);
            ps.setTime(3, quizDuration);
            ps.setInt(4, 0);
            ps.setInt(5, subjectId);
            ps.setInt(6, quizLevelId);
            ps.setString(7, description);
            ps.setString(8, day);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteQuizByQuizId(int quizId) {
        String query = "DELETE FROM [dbo].[Quiz]\n"
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

    public void updateQuiz(int quizId, String quizName, Time quizDuration, int subjectId, int quizLevelId, String description, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = formatter.format(date);
        String query = "UPDATE [dbo].[Quiz]\n"
                + "   SET [quizName] = ?\n"
                + "      ,[quizDuration] = ?\n"
                + "      ,[subjectId] = ?\n"
                + "      ,[quizLevelId] = ?\n"
                + "      ,[description] =?\n"
                + "      ,[dateCreated] = ?\n"
                + " WHERE [quizId] = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizName);
            ps.setTime(2, quizDuration);
            ps.setInt(3, subjectId);
            ps.setInt(4, quizLevelId);
            ps.setString(5, description);
            ps.setString(6, day);
            ps.setInt(7, quizId);
            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Quiz> getAllQuizByOwnerIdAndSortName(int ownerId) {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "where q.ownerId = ? order by q.quizName ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, ownerId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizByOwnerIdAndSortNumberQuestion(int ownerId) {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "where q.ownerId = ?  order by q.numberQuestion ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, ownerId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizByOwnerIdAndSortDuration(int ownerId) {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "where q.ownerId = ? order by q.quizDuration ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, ownerId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuiz() {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public void updateQuiz(int quizId, int ownerId, String quizName, Time quizDuration, int subjectId, int quizLevelId, String description, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = formatter.format(date);
        String query = "UPDATE [dbo].[Quiz]\n"
                + "   SET [quizName] = ?\n"
                + "      ,[quizDuration] = ?\n"
                + "      ,[subjectId] = ?\n"
                + "      ,[quizLevelId] = ?\n"
                + "      ,[description] =?\n"
                + "      ,[dateCreated] = ?\n"
                + "       ,[ownerId]=?\n"
                + " WHERE [quizId] = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quizName);
            ps.setTime(2, quizDuration);
            ps.setInt(3, subjectId);
            ps.setInt(4, quizLevelId);
            ps.setString(5, description);
            ps.setString(6, day);
            ps.setInt(7, ownerId);
            ps.setInt(8, quizId);

            ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Quiz> getAllQuizSortName() {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + " order by q.quizName ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizSortNumberQuestion() {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "  order by q.numberQuestion ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizSortDuration() {
        String query = "select q.*,u.userName,ql.quizLevelName,s.subjectName from Quiz as q\n"
                + "left outer join QuizLevel as ql\n"
                + "on ql.quizLevelId=q.quizLevelId\n"
                + "left outer join [Subject] as s\n"
                + "on s.subjectId = q.subjectId\n"
                + "left outer join [User] as u\n"
                + "on u.userId = q.ownerId\n"
                + "order by q.quizDuration ";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getQuizByQuizName(int index, String search) {
        String query = "select q.* , u.userName , s.subjectName from (select * from Quiz where quizName like ?) as q\n"
                + "                left outer join [User] as u on q.ownerId = u.userId\n"
                + "                left outer join Subject as s on  q.subjectId = s.subjectId\n"
                + "                order by quizId desc\n"
                + "                OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            ps.setInt(2, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getTime(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getDate(10),
                        rs.getString(11),
                        rs.getString(12));
                listQuiz.add(quiz);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listQuiz;
    }

    public ArrayList<Quiz> getAllQuizzesByUserId(int userId) {
        String query = "SELECT [quizId]\n"
                + "      ,[quizName]\n"
                + "      ,[ownerId]\n"
                + "      ,[thumbnail]\n"
                + "      ,[quizDuration]\n"
                + "      ,[numberQuestion]\n"
                + "      ,[subjectId]\n"
                + "      ,[quizLevelId]\n"
                + "      ,[description]\n"
                + "      ,[dateCreated]\n"
                + "  FROM [dbo].[Quiz]\n"
                + "  WHERE ownerId = ?";
        ArrayList<Quiz> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getTime(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),
                        rs.getDate(10));
                list.add(quiz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
