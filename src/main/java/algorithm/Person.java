package algorithm;

import java.time.Duration;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Person {

	private LocalDate birthDate;

	public Person(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	boolean isYoungThan(Person secondPerson) {
		return birthDate.isBefore(secondPerson.birthDate);
    }

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
				.add("birthDate=" + birthDate)
				.toString();
	}

	public Duration ageBetween(Person anotherPerson) {
		return Duration.between(birthDate.atStartOfDay(), anotherPerson.birthDate.atStartOfDay());
	}
}

