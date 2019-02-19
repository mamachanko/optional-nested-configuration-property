package io.github.mamachanko.optionalconfigurationproperty;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@SpringBootApplication
public class OptionalConfigurationPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptionalConfigurationPropertyApplication.class, args);
	}

}

@Component
@Slf4j
class ConfigLogger implements CommandLineRunner {

	private Config config;

	ConfigLogger(Config config) {
		this.config = config;
	}

	@Override
	public void run(String... args) {
		log.info(config.toString());
	}
}

@Component
@ConfigurationProperties(prefix = "config")
@Data
@Validated
class Config {

	@NotBlank
	private String requiredProperty;
	private Optional<String> optionalProperty = Optional.empty();

	@NotNull
	private MoreConfig moreRequiredConfig;
	private Optional<MoreConfig> moreOptionalConfig = Optional.empty();
}

@Data
class MoreConfig {
	private String property;
}
