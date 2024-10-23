package co.edu.uco.ucobet.generales.init;
import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.uco.ucobet.generales.application.secondaryports.entity" })
@ComponentScan(basePackages = {"co.edu.uco.ucobet" })
@EnableJpaRepositories(basePackages = {"co.edu.uco.ucobet" })

public class UcobetGeneralesMsApplication implements CommandLineRunner {

	private final SecretClient secretClient;

    public UcobetGeneralesMsApplication(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    public static void main(String[] args) {
		SpringApplication.run(UcobetGeneralesMsApplication.class, args);
	}

	@Bean
	public ServletWebServerFactory servletContainer() {

		return new TomcatServletWebServerFactory();

	}

	@Override
	public void run(String... args) throws Exception {
		String passwordUrl = secretClient.getSecret("password").getValue();
		String usernameUrl = secretClient.getSecret("username").getValue();
		System.setProperty("password", passwordUrl);
		System.setProperty("username", passwordUrl);
		System.out.println("password: " + passwordUrl);
		System.out.println("username: " + usernameUrl);
	}
}

