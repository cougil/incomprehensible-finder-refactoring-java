package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoupleFinder {

    private final List<Person> people;

    public CoupleFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<Couple> find(Criteria criteria) {
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
            return Optional.empty();
        }

        Couple answer = results.get(0);
        for (Couple potentialResult : results) {
            if (criteria == Criteria.CLOSEST) {
                if (potentialResult.getDifference() < answer.getDifference()) {
                    answer = potentialResult;
                }
            } else if (criteria == Criteria.FARTHEST) {
                if (potentialResult.getDifference() > answer.getDifference()) {
                    answer = potentialResult;
                }
            }
        }

        return Optional.of(answer);
    }

}
