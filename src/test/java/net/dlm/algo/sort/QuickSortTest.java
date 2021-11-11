package net.dlm.algo.sort;

import net.dlm.domain.Person;
import net.dlm.domain.PersonComparator;
import net.dlm.domain.TestData;
import org.junit.Test;

public class QuickSortTest {

    @Test
    void sortImpl() {
        Integer[] input = TestData.getIntegerArray();
        QuickSort<Integer> integerSorter = new QuickSort<>(input);
        integerSorter.sort();
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }

        integerSorter.printStats();
    }

    @Test
    void sortImplBounded() {
    }

    @Test
    void sortWithComparator2() {
        Person[] persons = TestData.getPersonArray();
        PersonComparator pc = new PersonComparator();
        QuickSort<Person> peopleSorter = new QuickSort<>(persons);
        peopleSorter.sortWithComparator2(persons, pc);
        for (Person i : persons) {
            System.out.println(i);
        }

        peopleSorter.printStats();
    }
}
