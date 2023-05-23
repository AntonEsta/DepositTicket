package web.lombard.lombard.api.DepositTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.Person;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PersonRepository;

import java.util.List;

@SpringBootApplication
public class DepositTicketApplication {

	@Autowired
	static
	PersonRepository personRepository;
	//static List<Person> person = personRepository.findAll();

	public static void main(String[] args) {
		SpringApplication.run(DepositTicketApplication.class, args);
//		person.forEach((p) -> {
//			System.out.println(p.getPassport());
//		});
	}

}
