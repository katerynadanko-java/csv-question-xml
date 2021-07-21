package dao;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;
import domain.Survey;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SurveyMappingCSV implements SurveyDao {
    private static final String[] FIELD_MAPPING = new String[]{
            "number",
            "question",
            "answers[0]",
            "answers[1]",
            "answers[2]",
            "rightNumber"
    };
    private static final CellProcessor[] processors = new CellProcessor[]{
            new Optional(new ParseInt()),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new ParseInt()
    };

    @Override
    public List<Survey> readQuestionsFromSource() throws Exception {
        List<Survey> questions = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("question-source.csv").getFile());
        try (ICsvDozerBeanReader pojoReader = new CsvDozerBeanReader(new FileReader(source),
                CsvPreference.STANDARD_PREFERENCE)) {
            pojoReader.getHeader(true);
            pojoReader.configureBeanMapping(Survey.class, FIELD_MAPPING);
            Survey question;
            while ((question = pojoReader.read(Survey.class, processors)) != null) {
                questions.add(question);
            }
        }
        return questions;
    }
}
