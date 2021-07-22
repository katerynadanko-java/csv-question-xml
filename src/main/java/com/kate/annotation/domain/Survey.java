package com.kate.annotation.domain;

import java.util.List;

import static java.lang.System.lineSeparator;

public class Survey {
    private int number;
    private String question;
    private List<String> answers;
    private int rightNumber;

    public Survey() {
    }

    public Survey(int number, String question, List<String> answers, int rightNumber) {
        this.number = number;
        this.question = question;
        this.answers = answers;
        this.rightNumber = rightNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public void setRightNumber(int rightNumber) {
        this.rightNumber = rightNumber;
    }

    @Override
    public String toString() {
        return "Питання №" + number + ":" + lineSeparator() + question + lineSeparator()
                + "Варианти відповідей:" + lineSeparator() + "1. " + answers.get(0) + lineSeparator()
                + "2. " + answers.get(1) + lineSeparator()
                + "3. " + answers.get(2) + lineSeparator()
                + "Введіть номер відповіді:";
    }
}
