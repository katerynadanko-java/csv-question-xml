package com.kate.annotation.service;

import com.kate.annotation.domain.Survey;
import com.kate.annotation.domain.Student;

import java.util.List;

public interface SurveyService {

    List<Survey> getQuestions() throws Exception;

    void conductInterview(Student student);

}
