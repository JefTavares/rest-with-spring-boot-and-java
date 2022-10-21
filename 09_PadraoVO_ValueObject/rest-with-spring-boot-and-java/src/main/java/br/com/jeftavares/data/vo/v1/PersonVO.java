package br.com.jeftavares.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstName;
	private String lastName;
	private String adrress;
	private String gender;

	public PersonVO() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(adrress, firstName, gender, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(adrress, other.adrress) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
