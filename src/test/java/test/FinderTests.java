package test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FinderTests {

    private Person sue = new Person("Sue", new Date(50, 0, 1));
    private Person greg = new Person("Greg", new Date(52, 5, 1));
    private Person sarah = new Person("Sarah", new Date(82, 0, 1));
    private Person mike = new Person("Mike", new Date(79, 0, 1));
    private List<Person> list;
    private Finder finder;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Person>();
        finder = new Finder(list);
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {

        Couple couple = finder.find(Criteria.CLOSEST);
        assertNull(couple.youngest);

        assertNull(couple.oldest);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        list.add(sue);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertNull(couple.youngest);
        assertNull(couple.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        list.add(sue);
        list.add(greg);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.youngest);
        assertEquals(greg, couple.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        list.add(mike);
        list.add(greg);

        Couple couple = finder.find(Criteria.FARTHEST);

        assertEquals(greg, couple.youngest);
        assertEquals(mike, couple.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = finder.find(Criteria.FARTHEST);

        assertEquals(sue, couple.youngest);
        assertEquals(sarah, couple.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.youngest);
        assertEquals(greg, couple.oldest);
    }

}
