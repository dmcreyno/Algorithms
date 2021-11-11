package net.dlm.domain;

import java.util.Comparator;

/**
 * Created by dmcreynolds on 11/7/2016.
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return (p1.getLastName() + "-" +  p1.getFirstName()).compareTo(p2.getLastName() + "-" +p2.getFirstName());
    }
}
