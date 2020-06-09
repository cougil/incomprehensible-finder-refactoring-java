package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CoupleFinder {

    private final List<Person> people;

    public CoupleFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<Couple> find(Criteria criteria) {
        List<Couple> results = buildCouples();
        if (results.isEmpty()) {
            return Optional.empty();
        }
        return find(criteria, results);
    }

    private Optional<Couple> find(Criteria criteria, List<Couple> results) {
        Couple answer = results.get(0);
        return Optional.of(
                results.stream()
                        .min(Comparator.comparing(couple ->
                            Criteria.CLOSEST == criteria ?
                                    (couple.getDifference() - answer.getDifference()) :
                                    (answer.getDifference() - couple.getDifference())
                            )
                        ).get());
    }

    private List<Couple> buildCouples() {
        List<Couple> results = new ArrayList<>();
        people.stream().reduce((first, second) -> {
            Couple couple = first.isYoungThan(second) ?
                    new Couple(first, second) :
                    new Couple(second, first);
            results.add(couple);
            return first;
        });
        return results;
    }

}
