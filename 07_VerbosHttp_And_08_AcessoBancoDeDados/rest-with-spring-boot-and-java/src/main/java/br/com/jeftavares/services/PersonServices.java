package br.com.jeftavares.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.jeftavares.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("Finding all people!");

		List<Person> persons = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jeferon");
		person.setLastName("da Silva");
		person.setAdrress("São Cetano do Sul - Brasil");
		person.setGender("Male");

		return person;
	}

	public Person createPerson(Person person) {
		logger.info("Create one person!");

		return person;
	}

	public Person updatePerson(Person person) {
		logger.info("Update one person!");

		return person;
	}

	public void deletePerson(String id) {
		logger.info("Deleting one person!");

	}

	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAdrress("Some address in - Brasil " + i);
		person.setGender("Male");

		return person;
	}

}
