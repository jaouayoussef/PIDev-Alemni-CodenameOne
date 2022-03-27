/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author LEGION
 */
public class Useranswer {
   private int id_user ;
   private int id_quiz ;
   private int id_question ;
   private int rep_correct ;

    public Useranswer() {
    }

    public Useranswer(int id_user, int id_quiz, int id_question, int rep_correct) {
        this.id_user = id_user;
        this.id_quiz = id_quiz;
        this.id_question = id_question;
        this.rep_correct = rep_correct;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getRep_correct() {
        return rep_correct;
    }

    public void setRep_correct(int rep_correct) {
        this.rep_correct = rep_correct;
    }

    @Override
    public String toString() {
        return "Useranswer{" + "id_user=" + id_user + ", id_quiz=" + id_quiz + ", id_question=" + id_question + ", rep_correct=" + rep_correct + '}';
    }

   
}
