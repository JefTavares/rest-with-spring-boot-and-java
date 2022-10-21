package br.com.jeftavares.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jeftavares.model.Person;

/**
 * extends JpaRepository, disponibiliza um crud de forma facil. Tipando o objeto
 * e o Id do objeto <Person, Long>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	/** Só com essa anotação eu consigo fazer um crud básico */
}
