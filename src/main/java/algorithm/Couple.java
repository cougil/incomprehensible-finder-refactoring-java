package algorithm;

import java.time.Duration;

public class Couple {

	private Person firstPerson;
	private Person secondPerson;

	public Couple(Person firstPerson, Person secondPerson) {
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
	}

	public long agesDifference() {
		return firstPerson.ageBetween(secondPerson).toDays();
	}

	public Person firstPerson() {
		return firstPerson;
	}

	public Person secondPerson() {
		return secondPerson;
	}
}
