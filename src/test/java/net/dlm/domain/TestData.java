package net.dlm.domain;


import java.util.Arrays;

/**
 *
 */
public class TestData {
    private static final Integer[] input = {11, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0, 1};
    private static final Integer[] input2 = {0, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 11, 12};
    private static final Person[] persons = {
            new Person("Smyth", "John", "10"),
            new Person("Smy", "John", "20"),
            new Person("Smith", "John", "30"),
            new Person("Smith", "John", "40"),
            new Person("Smeth", "Ayrle", "50"),
            new Person("Smitt", "Bovine", "60"),
            new Person("Smith", "Bov", "70"),
            new Person("Smith", "Zerx", "80")
    };

    public static Integer[] getIntegerArray() {
        Integer[] out = Arrays.copyOf(input, input.length);

        return out;
    }

    public static Person[] getPersonArray() {
        Person[] out = Arrays.copyOf(persons, persons.length);
        return out;
    }

    public static Integer[] getInteger2Array() {
        Integer[] out = Arrays.copyOf(input2, input2.length);
        return out;
    }
}
