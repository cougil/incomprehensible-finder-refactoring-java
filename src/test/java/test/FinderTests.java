package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

    private Person sue = new Person();
    private Person greg = new Person();
    private Person sarah = new Person();
    private Person mike = new Person();
    private List<Person> list = Collections.emptyList();

    @Before
    public void setup() {
        sue.name = "Sue";
        sue.birthDate = new Date(50, 0, 1);
        greg.name = "Greg";
        greg.birthDate = new Date(52, 5, 1);
        sarah.name = "Sarah";
        sarah.birthDate = new Date(82, 0, 1);
        mike.name = "Mike";
        mike.birthDate = new Date(79, 0, 1);
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.CLOSEST);
        assertEquals(null, couple.firstPerson);

        assertEquals(null, couple.secondPerson);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertEquals(null, couple.firstPerson);
        assertEquals(null, couple.secondPerson);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.firstPerson);
        assertEquals(greg, couple.secondPerson);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.FARTHEST);

        assertEquals(greg, couple.firstPerson);
        assertEquals(mike, couple.secondPerson);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.FARTHEST);

        assertEquals(sue, couple.firstPerson);
        assertEquals(sarah, couple.secondPerson);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Couple couple = finder.find(Criteria.CLOSEST);

        assertEquals(sue, couple.firstPerson);
        assertEquals(greg, couple.secondPerson);
    }

}
