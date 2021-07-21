import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import domain.User;
import service.SurveyService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        SurveyService service = ctx.getBean(SurveyService.class);
        service.conductInterview(new User());
    }
}