package ru.sberbank.model;

import java.util.List;

/**
 * Created by Idony on 25.05.2016.
 */
public class Answers {
    private List<Answer> answerList;
    private Long idAnswerForSingle;

    public Long getIdAnswerForSingle() {
        return idAnswerForSingle;
    }

    public void setIdAnswerForSingle(Long idAnswerForSingle) {
        this.idAnswerForSingle = idAnswerForSingle;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
