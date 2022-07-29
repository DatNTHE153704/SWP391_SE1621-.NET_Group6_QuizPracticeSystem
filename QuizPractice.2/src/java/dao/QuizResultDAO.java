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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.QuizResult;

/**
 *
 * @author ASUS
 */
public class QuizResultDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        QuizResultDAO dao = new QuizResultDAO();
        System.out.println(dao.getQuizResultById(1));
    }

    public void setQuizResult(QuizResult quizResult) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = formatter.format(quizResult.getSubmitAt());
        String query = "INSERT INTO [dbo].[QuizResult]\n"
                + "           ([userId]\n"
                + "           ,[quizId]\n"
                + "           ,[score]\n"
                + "           ,[time]\n"
                + "           ,[submitAt])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            ps.setInt(1, quizResult.getUserId());
            ps.setInt(2, quizResult.getQuizId());
            ps.setFloat(3, (float) quizResult.getScore());
            ps.setTime(4, quizResult.getTime());
            ps.setString(5, day);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public QuizResult getQuizResultByUserIdAndSubmitAt(QuizResult quizResult) {
        String query = "select top(1) quizResultId, userId from QuizResult where submitAt = ? and userId = ? order by quizResultId desc";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day = formatter.format(quizResult.getSubmitAt());
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, day);
            ps.setInt(2, quizResult.getUserId());

            rs = ps.executeQuery();
            while (rs.next()) {
                QuizResult newQuizResult = new QuizResult(rs.getInt(1), rs.getInt(2));
                return newQuizResult;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public QuizResult getQuizResultById(int quizResultId) {
        String query = "SELECT QR.quizResultId, QR.userId, QR.quizId,\n"
                + "QR.score, QR.[time], QR.submitAt\n"
                + "FROM QuizResult QR\n"
                + "WHERE QR.quizResultId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, quizResultId);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizResult quizResult = new QuizResult(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getTime(5), rs.getTimestamp(6));
                return quizResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<QuizResult> getAllQuizResultByUserId(int userId, int subjectId) {
        ArrayList<QuizResult> list = new ArrayList<>();
        String query = "WITH TrueOption AS\n"
                + "(\n"
                + "	SELECT SW.studentWorkId, SW.optionId, o.isCorrect\n"
                + "	FROM StudentWork SW \n"
                + "	LEFT JOIN [Option] O\n"
                + "	ON SW.optionId = O.optionId\n"
                + "	WHERE O.isCorrect = 1\n"
                + ")\n"
                + "\n"
                + "SELECT QR.quizResultId, QR.userId, QR.quizId, QR.score, QR.[time], QR.submitAt,\n"
                + "Q.quizName, Q.quizDuration, Q.numberQuestion , S.subjectId,S.subjectName, \n"
                + "COUNT(SW.optionId) as optionAnswered,COUNT(T.studentWorkId) as numberTrueAnswered\n"
                + "FROM QuizResult QR JOIN Quiz Q\n"
                + "ON QR.quizId = Q.quizId\n"
                + "LEFT JOIN [Subject] S\n"
                + "ON Q.subjectId = S.subjectId\n"
                + "LEFT JOIN StudentWork SW\n"
                + "ON QR.quizResultId = SW.quizResultId\n"
                + "LEFT JOIN TrueOption T\n"
                + "ON SW.studentWorkId = T.studentWorkId\n"
                + "GROUP BY QR.quizResultId, QR.userId, QR.quizId, QR.score, QR.[time], QR.submitAt,\n"
                + "Q.quizName, Q.quizDuration, Q.numberQuestion ,S.subjectId, S.subjectName \n"
                + "HAVING QR.userId = ?\n";

        if (subjectId != 0) {
            query += " AND S.subjectId = ?";
        }
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            if (subjectId != 0) {
                ps.setInt(2, subjectId);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                QuizResult quizResult = new QuizResult(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getTime(5), rs.getTimestamp(6),
                        rs.getString(7), rs.getTime(8), rs.getInt(9),
                        rs.getString(11), rs.getInt(12), rs.getInt(13));
                list.add(quizResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteQuizResultByQuizId(int quizId) {
        String query = "DELETE FROM [dbo].[QuizResult]\n"
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

}
