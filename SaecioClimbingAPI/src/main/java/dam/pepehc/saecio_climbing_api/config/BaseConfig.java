package dam.pepehc.saecio_climbing_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * El tipo Base Config, para definir una serie de beans genéricos.
 */
@Configuration
public class BaseConfig {

    /**
     * Java mail sender java mail sender.
     *
     * @return the java mail sender
     */
    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }
}
