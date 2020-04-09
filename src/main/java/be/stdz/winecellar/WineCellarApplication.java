package be.stdz.winecellar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDatastoreRepositories
public class WineCellarApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineCellarApplication.class, args);
	}

}
