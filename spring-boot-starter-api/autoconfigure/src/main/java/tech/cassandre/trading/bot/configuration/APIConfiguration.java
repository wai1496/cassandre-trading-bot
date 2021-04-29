package tech.cassandre.trading.bot.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import tech.cassandre.trading.bot.util.APIParameters;

import javax.annotation.PostConstruct;

/**
 * API Configuration.
 */
@Configuration
@EnableConfigurationProperties(APIParameters.class)
@ConditionalOnClass({ExchangeAutoConfiguration.class, StrategiesAutoConfiguration.class})
public class APIConfiguration {

    /** API parameters. */
    private APIParameters apiParameters;

    /**
     * Constructor.
     *
     * @param newAPIParameters api parameters
     */
    public APIConfiguration(final APIParameters newAPIParameters) {
        this.apiParameters = newAPIParameters;
    }

    @PostConstruct
    public final void configure() {
        System.out.println("Started ! " + apiParameters);
    }

}
