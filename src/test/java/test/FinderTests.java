package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Result;
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

        Result result = finder.find(Criteria.One);
        assertEquals(null, result.P1);

        assertEquals(null, result.P2);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        Finder finder = new Finder(list);

        Result result = finder.find(Criteria.One);

        assertEquals(null, result.P1);
        assertEquals(null, result.P2);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        Result result = finder.find(Criteria.One);

        assertEquals(sue, result.P1);
        assertEquals(greg, result.P2);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Result result = finder.find(Criteria.Two);

        assertEquals(greg, result.P1);
        assertEquals(mike, result.P2);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        Result result = finder.find(Criteria.Two);

        assertEquals(sue, result.P1);
        assertEquals(sarah, result.P2);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        Result result = finder.find(Criteria.One);

        assertEquals(sue, result.P1);
        assertEquals(greg, result.P2);
    }

}
