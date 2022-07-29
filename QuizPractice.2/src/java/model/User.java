/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class User {

    private int userId;
    private String userName;
    private String email;
    private String password;
    private String avatar;
    private boolean gender;
    private Date dob;
    private int roleId;
    private int status;
    private String code;

    public User() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    public User(int userId, String userName, String email, String password, String avatar, boolean gender, Date dob, int roleId, int status) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.gender = gender;
        this.dob = dob;
        this.roleId = roleId;
        this.status = status;
    }

    public User(int userId, String userName, String email, String password, String avatar, boolean gender, Date dob, int roleId, int status, String code) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.gender = gender;
        this.dob = dob;
        this.roleId = roleId;
        this.status = status;
        this.code = code;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
