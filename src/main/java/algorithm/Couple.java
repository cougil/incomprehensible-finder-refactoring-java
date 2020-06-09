package algorithm;

import static java.time.temporal.ChronoUnit.DAYS;

public class Couple {

	private Person firstPerson;
	private Person secondPerson;

	public Couple(Person firstPerson, Person secondPerson) {
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
	}

	public long getDifference() {
		return DAYS.between(getFirstPerson().getBirthDate(), getSecondPerson().getBirthDate());
	}

	public Person getFirstPerson() {
		return firstPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}
}
