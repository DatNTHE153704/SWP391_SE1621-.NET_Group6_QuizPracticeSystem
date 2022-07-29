/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class StudentWork {
    
    private int studentWorkId;
    private int userId;
    private int quizResultId;
    private int questionId;
    private int optionId;

    public StudentWork() {
    }

    public StudentWork(int userId, int quizResultId, int questionId, int optionId) {
        this.userId = userId;
        this.quizResultId = quizResultId;
        this.questionId = questionId;
        this.optionId = optionId;
    }

    public StudentWork(int userId, int quizResultId, int questionId) {
        this.userId = userId;
        this.quizResultId = quizResultId;
        this.questionId = questionId;
    }
    
    
    

    public StudentWork(int studentWorkId, int userId, int quizResultId, int questionId, int optionId) {
        this.studentWorkId = studentWorkId;
        this.userId = userId;
        this.quizResultId = quizResultId;
        this.questionId = questionId;
        this.optionId = optionId;
    }

    public int getStudentWorkId() {
        return studentWorkId;
    }

    public void setStudentWorkId(int studentWorkId) {
        this.studentWorkId = studentWorkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizResultId() {
        return quizResultId;
    }

    public void setQuizResultId(int quizResultId) {
        this.quizResultId = quizResultId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    
}
