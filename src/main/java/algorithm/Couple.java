package algorithm;
public class Couple {

	private Person firstPerson;
	private Person secondPerson;

	public Couple(Person firstPerson, Person secondPerson) {
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
	}

	public long getDifference() {
		return getSecondPerson().getBirthDate().getTime() - getFirstPerson().getBirthDate().getTime();
	}

	public Person getFirstPerson() {
		return firstPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}
}
