package net.dlm.domain;

/**
 * Created by dmcreynolds on 11/7/2016.
 */
public class Person implements Comparable<Person> {
    String lastName;
    String firstName;
    String id;
    String nameDenorm;
    int personHash;

    public Person(String pLastName, String pFirstName, String pID) {
        this.lastName = pLastName;
        this.firstName = pFirstName;
        this.id = pID;
        this.nameDenorm = pLastName + pFirstName;
        this.personHash = nameDenorm.hashCode();
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int compareTo(Person other) {
        return (this.lastName + "-" +  this.firstName).compareTo(other.lastName + "-" +other.firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        boolean rVal = super.equals(obj);
        if (!rVal && obj instanceof Person) {               // if default equals
            rVal = equalsPerson((Person) obj);              // says false keep
        }                                                  // investigating
        return rVal;
    }

    private boolean equalsPerson(Person aPerson) {
        return personHash == aPerson.personHash;
    }

    @Override
    public int hashCode() {
        return personHash;
    }

    public String toString() {
        return "(" + this.id + ")" + this.lastName + ", " + this.firstName;
    }
}
