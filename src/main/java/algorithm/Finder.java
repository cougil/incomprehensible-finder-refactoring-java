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
				Pair r = new Pair();
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					r.firstPerson = people.get(i);
					r.secondPerson = people.get(j);
				} else {
					r.firstPerson = people.get(j);
					r.secondPerson = people.get(i);
				}
				r.difference = r.secondPerson.birthDate.getTime() - r.firstPerson.birthDate.getTime();
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new Pair();
		}

		Pair answer = tr.get(0);
		for (Pair pair : tr) {
			switch (criteria) {
				case One :
					if (pair.difference < answer.difference) {
						answer = pair;
					}
					break;

				case Two :
					if (pair.difference > answer.difference) {
						answer = pair;
					}
					break;
			}
		}

		return answer;
	}
}
