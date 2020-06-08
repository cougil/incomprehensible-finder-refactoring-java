package test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.CoupleFinder;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CoupleFinderTests {

    private Person sue = new Person(new Date(50, 0, 1));
    private Person greg = new Person(new Date(52, 5, 1));
    private Person sarah = new Person(new Date(82, 0, 1));
    private Person mike = new Person(new Date(79, 0, 1));
    private List<Person> list;
    private CoupleFinder coupleFinder;

    @Before
    public void setup() {
        list = new ArrayList<Person>();
        coupleFinder = new CoupleFinder(list);
    }

    @Test
    public void returns_empty_results_when_given_empty_list() {

        Couple couple = coupleFinder.find(Criteria.CLOSEST);
        assertNull(couple.getYoungest());

        assertNull(couple.getOldest());
    }

    @Test
    public void returns_empty_results_when_given_one_person() {
        list.add(sue);

        Couple couple = coupleFinder.find(Criteria.CLOSEST);

        assertNull(couple.getYoungest());
        assertNull(couple.getOldest());
    }

    @Test
    public void returns_closest_two_for_two_people() {
        list.add(sue);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.getYoungest());
        assertEquals(greg, couple.getOldest());
    }

    @Test
    public void returns_furthest_two_for_two_people() {
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.FARTHEST);

        assertEquals(greg, couple.getYoungest());
        assertEquals(mike, couple.getOldest());
    }

    @Test
    public void returns_furthest_two_for_four_people() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.FARTHEST);

        assertEquals(sue, couple.getYoungest());
        assertEquals(sarah, couple.getOldest());
    }

    @Test
    public void returns_closest_two_for_four_people() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = coupleFinder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.getYoungest());
        assertEquals(greg, couple.getOldest());
    }

}
