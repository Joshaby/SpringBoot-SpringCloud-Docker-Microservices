package br.com.joshaby.greetingservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
@Getter
@Setter
public class GreetingConfig {

    private String greeting;

    private String defaultValue;

}
