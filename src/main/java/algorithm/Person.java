package algorithm;

import java.util.Date;
import java.util.StringJoiner;

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

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
				.add("birthDate=" + birthDate)
				.toString();
	}
}

