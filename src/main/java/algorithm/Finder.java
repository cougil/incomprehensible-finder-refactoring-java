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
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					couple.youngest = people.get(i);
					couple.oldest = people.get(j);
				} else {
					couple.youngest = people.get(j);
					couple.oldest = people.get(i);
				}
				couple.difference = couple.oldest.birthDate.getTime() - couple.youngest.birthDate.getTime();
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
