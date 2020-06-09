package test;

import algorithm.Couple;
import algorithm.CoupleFinder;
import algorithm.Criteria;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CoupleFinderTests {

    private Person sue = new Person(LocalDate.of(1950, 1, 1));
    private Person greg = new Person(LocalDate.of(1952, 6, 1));
    private Person sarah = new Person(LocalDate.of(1982, 1, 1));
    private Person mike = new Person(LocalDate.of(1979, 1, 1));
    private List<Person> list;
    private CoupleFinder coupleFinder;

    @Before
    public void setup() {
        list = new ArrayList<>();
        coupleFinder = new CoupleFinder(list);
    }

    @Test
    public void returns_empty_results_when_given_empty_list() {

        Optional<Couple> couple = coupleFinder.find(Criteria.CLOSEST);

        assertEquals(Optional.empty(), couple);
    }

    @Test
    public void returns_empty_results_when_given_one_person() {
        list.add(sue);

        Optional<Couple> couple = coupleFinder.find(Criteria.CLOSEST);

        assertEquals(Optional.empty(), couple);
    }

    @Test
    public void returns_closest_two_for_two_people() {
        list.add(sue);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.CLOSEST).get();

        assertEquals(sue, couple.firstPerson());
        assertEquals(greg, couple.secondPerson());
    }

    @Test
    public void returns_furthest_two_for_two_people() {
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.FARTHEST).get();

        assertEquals(greg, couple.firstPerson());
        assertEquals(mike, couple.secondPerson());
    }

    @Test
    public void returns_furthest_two_for_four_people() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.FARTHEST).get();

        assertEquals(sue, couple.firstPerson());
        assertEquals(sarah, couple.secondPerson());
    }

    @Test
    public void returns_closest_two_for_four_people() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.CLOSEST).get();

        assertEquals(sue, couple.firstPerson());
        assertEquals(greg, couple.secondPerson());
    }

}
