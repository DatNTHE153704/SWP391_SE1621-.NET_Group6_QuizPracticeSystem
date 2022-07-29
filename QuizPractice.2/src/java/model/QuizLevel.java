/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class QuizLevel {
    
    private int quizLevelId;
    private String quizLevelName;

    public QuizLevel() {
    }

    public QuizLevel(int quizLevelId, String quizLevelName) {
        this.quizLevelId = quizLevelId;
        this.quizLevelName = quizLevelName;
    }

    public int getQuizLevelId() {
        return quizLevelId;
    }

    public void setQuizLevelId(int quizLevelId) {
        this.quizLevelId = quizLevelId;
    }

    public String getQuizLevelName() {
        return quizLevelName;
    }

    public void setQuizLevelName(String quizLevelName) {
        this.quizLevelName = quizLevelName;
    }
    
}
