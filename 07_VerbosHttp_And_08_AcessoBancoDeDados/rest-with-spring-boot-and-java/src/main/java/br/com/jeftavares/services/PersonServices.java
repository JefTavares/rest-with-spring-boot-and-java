package br.com.jeftavares.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeftavares.exceptions.ResourceNotFoundException;
import br.com.jeftavares.model.Person;
import br.com.jeftavares.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository; /*credo aqui só já faz a injeção de dependencia*/

	public List<Person> findAll() {
		logger.info("Finding all people!");

		return repository.findAll();

	}

	public Person findById(Long id) {
		logger.info("Finding one person!");

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
	}

	public Person createPerson(Person person) {
		logger.info("Create one person!");

		return repository.save(person);
	}

	public Person updatePerson(Person person) {
		logger.info("Update one person!");
		Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdrress(person.getAdrress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}

	public void deletePerson(Long id) {
		logger.info("Deleting one person!");

		Person entity = repository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("No records found for this id!"));
		
		repository.delete(entity);
	}

}
