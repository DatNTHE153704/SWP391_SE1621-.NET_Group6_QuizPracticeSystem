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
import model.UserRole;

/**
 *
 * @author ASUS
 */
public class UserRoleDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static void main(String[] args) {
        UserRoleDAO dao = new UserRoleDAO();
        System.out.println(dao.getAllRoles());
    }

    public ArrayList<UserRole> getAllRoles() {
        ArrayList<UserRole> list = new ArrayList<>();
        String query = "SELECT roleId, roleName FROM [UserRole]";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserRole r = new UserRole(rs.getInt(1), rs.getString(2));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
