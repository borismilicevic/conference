import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * Named bean speakerService
     * Two demonstrates two ways of dependency injection:
     * setter and constructor
     * @Scope annotation:
     * - singleton (default) One instance per Spring Container (Application Context)
     * - prototype Unique instance per request from the bean container
     * Web-aware spring project can recognise additional scopes:
     * - request Bean per http request - while user request is served
     * - session Bean per http session - as long as user session is alive
     * - global Single bean per application - as long as application runs on the server
     */
    @Bean(name = "speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public SpeakerService getSpeakerService() {
        return getSpeakerServiceViaConstructorInjection();
//        return getSpeakerServiceViaSetterInjection();
    }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }

    private SpeakerService getSpeakerServiceViaSetterInjection() {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        speakerService.setSpeakerRepository(getSpeakerRepository());
        return speakerService;
    }

    private SpeakerService getSpeakerServiceViaConstructorInjection() {
        return new SpeakerServiceImpl(getSpeakerRepository());
    }
}
