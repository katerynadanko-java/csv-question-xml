package com.kate.annotation.dao;

import com.kate.annotation.domain.Survey;

import java.util.List;

public interface SurveyDao {

    List<Survey> readQuestionsFromSource() throws Exception;
}
