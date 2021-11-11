package net.dlm.algo.sort;

import net.dlm.domain.Person;
import net.dlm.domain.TestData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class InsertionSortTest {
    private static final Logger log = LoggerFactory.getLogger("TEST");
    private static final String LOG_CLASS = InsertionSortTest.class.getSimpleName();

    @Test
    public void testSort1() {
        String LOG_PREFIX = LOG_CLASS + ".testSort1()";
        Person[] persons = TestData.getPersonArray();
        InsertionSort<Person> peopleSorter = new InsertionSort<>(persons);
        peopleSorter.sort();
        log.info("total comparisons, {}.", peopleSorter.getComparisons());
        log.info("total switches, {}.", peopleSorter.getSwitches());
    }

    @Test
    public void testSort2() {
        String LOG_PREFIX = LOG_CLASS + ".testSort1()";
        Integer[] input = TestData.getIntegerArray();
        InsertionSort<Integer> integerSorter = new InsertionSort<>(input);
        integerSorter.sort();
        for (int i = 1; i < input.length - 1; i++) {
            assertTrue(input[i] < input[i + 1]);
        }
        log.info("total comparisons, {}.", integerSorter.getComparisons());
        log.info("total switches, {}.", integerSorter.getSwitches());
    }

    @Test
    public void testSort3() {
        String LOG_PREFIX = LOG_CLASS + ".testSort1()";
        Integer[] input = TestData.getInteger2Array();
        InsertionSort<Integer> integerSorter = new InsertionSort<>(input);
        integerSorter.sort();
        for (int i = 1; i < input.length - 1; i++) {
            assertTrue(input[i] < input[i + 1]);
        }

        log.info("total comparisons, {}.", integerSorter.getComparisons());
        log.info("total switches, {}.", integerSorter.getSwitches());
    }
}
