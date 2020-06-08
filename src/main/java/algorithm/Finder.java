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
				Couple couple = new Couple();
				final Person firstPerson = people.get(i);
				final Person secondPerson = people.get(j);
				if (firstPerson.isOlderThan(secondPerson)) {
					couple.youngest = firstPerson;
					couple.oldest = secondPerson;
				} else {
					couple.youngest = secondPerson;
					couple.oldest = firstPerson;
				}
				couple.difference = couple.oldest.getBirthDate().getTime() - couple.youngest.getBirthDate().getTime();
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
					if (potentialResult.difference < answer.difference) {
						answer = potentialResult;
					}
					break;

				case FARTHEST:
					if (potentialResult.difference > answer.difference) {
						answer = potentialResult;
					}
					break;
			}
		}

		return answer;
	}

}
