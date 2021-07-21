package service;

import domain.Survey;
import domain.User;

import java.util.List;

public interface SurveyService {

    List<Survey> getQuestions() throws Exception;

    void conductInterview(User user);

}