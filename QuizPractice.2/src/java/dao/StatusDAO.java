/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Status;

/**
 *
 * @author ASUS
 */
public class StatusDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Status> getAllStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
