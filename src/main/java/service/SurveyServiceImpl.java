package service;

import dao.SurveyDao;
import domain.Survey;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyServiceImpl implements SurveyService {

    private SurveyDao dao;

    public SurveyServiceImpl(SurveyDao dao) {
        this.dao = dao;
    }

    private static int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int result = 0;
        for (int i = 0; i < studentsAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))) {
                result++;
            }
        }
        return result;
    }

    @Override
    public List<Survey> getQuestions() throws Exception {
        return dao.readQuestionsFromSource();
    }

    @Override
    public void conductInterview(User user) {
        try {
            List<Survey> questions = this.getQuestions();
            List<Integer> rightAnswers = new ArrayList<>();
            List<Integer> studentsAnswers = new ArrayList<>();
            int answer;
            Scanner inp = new Scanner(System.in);
            System.out.println("Enter your name:");
            String input = inp.nextLine();
            user.setName(input);
            System.out.println("Enter your surname:");
            input = inp.nextLine();
            user.setSurname(input);
            for (Survey question : questions) {
                System.out.println(question);
                answer = inp.nextInt();
                studentsAnswers.add(answer);
                rightAnswers.add(question.getRightNumber());
            }
            user.setResult(checkAnswers(studentsAnswers, rightAnswers));
            System.out.println(user);
        } catch (Exception e) {
            System.out.println("Problem getting the list of questions!");
        }
    }


}
