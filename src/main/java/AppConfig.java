import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    @Bean(name = "cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }
//    /**
//     * Named bean speakerService
//     * @Bean annotation can be used on method level unlike @Component
//     * demonstrates three ways of dependency injection:
//     * setter, constructor and autowired setter (which would be a hybrid)
//     * @Scope annotation:
//     * - singleton (default) One instance per Spring Container (Application Context)
//     * - prototype Unique instance per request from the bean container
//     * Web-aware spring project can recognise additional scopes:
//     * - request Bean per http request - while user request is served
//     * - session Bean per http session - as long as user session is alive
//     * - global Single bean per application - as long as application runs on the server
//     */
//    @Bean(name = "speakerService")
//    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
//    public SpeakerService getSpeakerService() {
//        return getSpeakerServiceViaConstructorInjection();
//        return getSpeakerServiceViaSetterInjection();
//        return getSpeakerServiceViaSetterAutowiring();
//    }

//    @Bean(name = "speakerRepository")
//    public SpeakerRepository getSpeakerRepository() {
//        return new HibernateSpeakerRepositoryImpl();
//    }

//    private SpeakerService getSpeakerServiceViaSetterInjection() {
//        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
//        speakerService.setSpeakerRepository(getSpeakerRepository());
//        return speakerService;
//    }
//
//    private SpeakerService getSpeakerServiceViaConstructorInjection() {
//        return new SpeakerServiceImpl(getSpeakerRepository());
//    }

//    /**
//     * First the no-args constructor is invoked, then the
//     * autowired setter is called.
//     */
//    private SpeakerService getSpeakerServiceViaSetterAutowiring() {
//        return new SpeakerServiceImpl();
//    }
}
