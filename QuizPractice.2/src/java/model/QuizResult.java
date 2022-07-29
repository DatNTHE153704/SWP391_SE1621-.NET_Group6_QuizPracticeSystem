/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author ASUS
 */
public class QuizResult {
    
    private int quizResultId;
    private int userId;
    private int quizId;
    private double score;
    private Time time;
    private Timestamp submitAt;
    private String quizName;
    private Time quizDuration;
    private int numberQuestion;
    private String subjectName;
    private int numberQuestionsAnswered;
    private int numberCorrectAnswer;

    public QuizResult() {
    }

    public QuizResult(int quizResultId, int userId) {
        this.quizResultId = quizResultId;
        this.userId = userId;
    }

    public QuizResult(int userId, int quizId, double score, Time time, Timestamp submitAt) {
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.time = time;
        this.submitAt = submitAt;
    }

    public QuizResult(int quizResultId, int userId, int quizId, double score, Time time, Timestamp submitAt) {
        this.quizResultId = quizResultId;
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.time = time;
        this.submitAt = submitAt;
    }

    public QuizResult(int quizResultId, int userId, int quizId, double score, Time time, Timestamp submitAt, String quizName, Time quizDuration, int numberQuestion, String subjectName, int numberQuestionsAnswered, int numberCorrectAnswer) {
        this.quizResultId = quizResultId;
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.time = time;
        this.submitAt = submitAt;
        this.quizName = quizName;
        this.quizDuration = quizDuration;
        this.numberQuestion = numberQuestion;
        this.subjectName = subjectName;
        this.numberQuestionsAnswered = numberQuestionsAnswered;
        this.numberCorrectAnswer = numberCorrectAnswer;
    }

    
    public int getQuizResultId() {
        return quizResultId;
    }

    public void setQuizResultId(int quizResultId) {
        this.quizResultId = quizResultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timestamp getSubmitAt() {
        return submitAt;
    }

    public void setSubmitAt(Timestamp submitAt) {
        this.submitAt = submitAt;
    }
    
    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Time getQuizDuration() {
        return quizDuration;
    }

    public void setQuizDuration(Time quizDuration) {
        this.quizDuration = quizDuration;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNumberQuestionsAnswered() {
        return numberQuestionsAnswered;
    }

    public void setNumberQuestionsAnswered(int numberQuestionsAnswered) {
        this.numberQuestionsAnswered = numberQuestionsAnswered;
    }

    public int getNumberCorrectAnswer() {
        return numberCorrectAnswer;
    }

    public void setNumberCorrectAnswer(int numberCorrectAnswer) {
        this.numberCorrectAnswer = numberCorrectAnswer;
    }
    
    
}
