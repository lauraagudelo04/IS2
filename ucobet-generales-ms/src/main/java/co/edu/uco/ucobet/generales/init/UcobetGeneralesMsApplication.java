package co.edu.uco.ucobet.generales.init;
import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller"})
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
		String h2url = secretClient.getSecret("password").getValue();
		System.setProperty("password", h2url);
		System.out.println("h2url: " + h2url);
	}
}

