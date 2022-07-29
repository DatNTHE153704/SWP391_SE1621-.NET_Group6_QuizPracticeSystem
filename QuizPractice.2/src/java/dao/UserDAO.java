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
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.getAllUsers());
    }

    public User getUserByName(String username) {
        String query = "SELECT [userId],[userName],[email],[password],[avatar],"
                + "[gender],[dob],[roleId],[status],[code] FROM [USER] WHERE USERNAME = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmail(String email) {
        String query = "SELECT [userId],[userName],[email],[password],[avatar],"
                + "[gender],[dob],[roleId],[status],[code] FROM [USER] WHERE EMAIL = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User checkLogin(String email, String password) {
        String query = "SELECT [userId],[userName],[email],[password],[avatar],"
                + "[gender],[dob],[roleId],[status],[code] FROM [USER] WHERE EMAIL = ? AND PASSWORD = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registerAccount(String username, String email, String password, boolean gender, Date dob) {
        String query = "INSERT INTO [USER]([userName],[email],[password],[avatar],[gender],[dob],[roleId],[status],[code])"
                + " VALUES(?,?,?,NULL,?,?,3,2,NULL)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setBoolean(4, gender);
            ps.setDate(5, dob);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(String username, String email, String password, boolean gender, Date dob, int roleId) {
        String query = "INSERT INTO [USER]([userName],[email],[password],[avatar],[gender],[dob],[roleId],[status],[code])"
                + " VALUES(?,?,?,NULL,?,?,?,1,NULL)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setBoolean(4, gender);
            ps.setDate(5, dob);
            ps.setInt(6, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserStatus(int status, String email) {
        String query = "UPDATE [USER] SET [STATUS] = ? WHERE EMAIL = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword(User user) throws Exception {

        try {
            String query = " update  [QuizPracticeSystem].[dbo].[User] set password = ? where email = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }

    public User verifyCode(String email, boolean status, String code) {
        String query = "SELECT [userId],[userName],[email],[password],[avatar],"
                + "[gender],[dob],[roleId],[status],[code] FROM [USER] WHERE EMAIL = ? and STATUS = ? and CODE = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setBoolean(2, status);
            ps.setString(3, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateCode(String code, String email) {
        String query = "UPDATE [USER] SET [CODE] = ? WHERE EMAIL = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, code);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPassword(String newPassword, String email) {
        String query = "update [USER] set [password] = ? where email = ?";
        try {
            con = new DBContext().getConnection();//mo ket noi voi sql
            ps = con.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean checkEmail(String email) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from  [QuizPracticeSystem].[dbo].[User] where email  = ?";
            con = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getAllExpert() {
        ArrayList<User> listObject = new ArrayList<>();
        String query = "select * from [dbo].[User] where roleId = 2";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listObject.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT userId, userName, email, password,"
                + "avatar, gender, dob, roleId, status, code FROM [USER]";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateRoleUser(int userId, int roleId) {
        String query = "UPDATE [USER] SET [RoleId] = ? WHERE UserId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(2, userId);
            ps.setInt(1, roleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers(String value) {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT userId, userName, email, password,"
                + "avatar, gender, dob, roleId, status, code FROM [USER] ";
        if (value != null) {
            query += "WHERE userName like ?";
        }
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            if (value != null) {
                ps.setString(1, "%" + value + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getBoolean(6),
                        rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteUser(int userId) {
        String query = "DELETE FROM [USER] WHERE UserId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int userId, int status) {
        String query = "UPDATE [USER] SET [status] = ? WHERE userId = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(2, userId);
            ps.setInt(1, status);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
