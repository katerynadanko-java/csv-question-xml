package dao;

import domain.Survey;

import java.util.List;

public interface SurveyDao {

    List<Survey> readQuestionsFromSource() throws Exception;
}