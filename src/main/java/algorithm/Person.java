package algorithm;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Person {

	private LocalDate birthDate;

	public Person(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

    boolean isYoungThan(Person secondPerson) {
        return getBirthDate().isBefore(secondPerson.getBirthDate());
    }

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
				.add("birthDate=" + birthDate)
				.toString();
	}
}

