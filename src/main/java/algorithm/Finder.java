package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Couple find(Criteria criteria) {
		List<Couple> results = new ArrayList<Couple>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				final Person firstPerson = people.get(i);
				final Person secondPerson = people.get(j);
				Couple couple = firstPerson.isYoungThan(secondPerson) ?
					new Couple(firstPerson, secondPerson) :
					new Couple(secondPerson, firstPerson);
				results.add(couple);
			}
		}

		if (results.size() < 1) {
			return new Couple();
		}

		Couple answer = results.get(0);
		for (Couple potentialResult : results) {
			switch (criteria) {
				case CLOSEST:
					if (potentialResult.getDifference() < answer.getDifference()) {
						answer = potentialResult;
					}
					break;

				case FARTHEST:
					if (potentialResult.getDifference() > answer.getDifference()) {
						answer = potentialResult;
					}
					break;
			}
		}

		return answer;
	}

}
