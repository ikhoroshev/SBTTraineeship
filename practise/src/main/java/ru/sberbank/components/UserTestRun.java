package ru.sberbank.components;

import org.springframework.stereotype.Component;
import ru.sberbank.model.Question;
import ru.sberbank.model.Test;
import ru.sberbank.model.TestRun;
import ru.sberbank.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Николай on 26.05.2016.
 */
@Component
public class UserTestRun {

    private User user;
    private Test test;
    private TestRun testRun;
    private Question question;

    private List<Question> questions;
    private int size = 0;
    private int index = 0;


    public void init(){
        index = 0;
        questions = test.getQuestions();
        size = questions.size();
    }

    public Question nextQuestions (){
        if (size != 0 && index < questions.size()){
            Question question = questions.get(index);
            this.question = question;
            index++;
            size--;
            return question;
        }
        return null;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
