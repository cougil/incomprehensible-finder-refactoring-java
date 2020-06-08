package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Couple find(Criteria criteria) {
		List<Couple> tr = new ArrayList<Couple>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Couple couple = new Couple();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					couple.firstPerson = people.get(i);
					couple.secondPerson = people.get(j);
				} else {
					couple.firstPerson = people.get(j);
					couple.secondPerson = people.get(i);
				}
				couple.difference = couple.secondPerson.birthDate.getTime() - couple.firstPerson.birthDate.getTime();
				tr.add(couple);
			}
		}

		if (tr.size() < 1) {
			return new Couple();
		}

		Couple answer = tr.get(0);
		for (Couple potentialResult : tr) {
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
