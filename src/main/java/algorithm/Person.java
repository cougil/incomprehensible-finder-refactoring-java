package algorithm;

import java.util.Date;

public class Person {

	private Date birthDate;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

    boolean isYoungThan(Person secondPerson) {
        return getBirthDate().getTime() < secondPerson.getBirthDate().getTime();
    }
}

