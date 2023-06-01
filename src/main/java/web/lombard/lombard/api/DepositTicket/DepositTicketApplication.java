package web.lombard.lombard.api.DepositTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class DepositTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepositTicketApplication.class, args);
	}

}
