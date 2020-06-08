package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Pair find(Criteria criteria) {
		List<Pair> tr = new ArrayList<Pair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Pair pair = new Pair();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					pair.firstPerson = people.get(i);
					pair.secondPerson = people.get(j);
				} else {
					pair.firstPerson = people.get(j);
					pair.secondPerson = people.get(i);
				}
				pair.difference = pair.secondPerson.birthDate.getTime() - pair.firstPerson.birthDate.getTime();
				tr.add(pair);
			}
		}

		if (tr.size() < 1) {
			return new Pair();
		}

		Pair answer = tr.get(0);
		for (Pair potentialResult : tr) {
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
