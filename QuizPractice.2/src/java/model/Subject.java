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
public class Subject {

    private int subjectId;
    private String subjectName;
    private String description;
    private String image;

    public Subject() {
    }

    public Subject(int subjectId, String subjectName,  String image,String description) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.description = description;
        this.image = image;
    }

    public Subject(String subjectName, String description, String image) {
        this.subjectName = subjectName;
        this.description = description;
        this.image = image;
    }
    

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
