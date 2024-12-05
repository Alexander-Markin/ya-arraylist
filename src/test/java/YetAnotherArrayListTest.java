import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class YetAnotherArrayListTest {

    @Test
    public void listSizeWhenAddOneIntegerShouldBeOne() {

        YetAnotherArrayList<Integer> list = new YetAnotherArrayList<>();

        list.add(1);

        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void listSizeWhenAddOneStringShouldBeOne() {

        YetAnotherArrayList<String> list = new YetAnotherArrayList<>();

        list.add("Hello world");

        assertEquals(1, list.size());
        assertEquals("Hello world", list.get(0));
    }

    @Test
    public void indexOutOfBoundWhenGetFromEmptyListShouldThrowException() {

        YetAnotherArrayList<String> list = new YetAnotherArrayList<>();

        IndexOutOfBoundsException ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(1));

        assertEquals("Index: 1, Size: 0", ex.getMessage());
    }

    @Test
    public void quickSortComparableWhenGetListOfIntegersShouldSortAsc () {

        YetAnotherArrayList<Integer> list = new YetAnotherArrayList<>();

        list.add(9);
        list.add(6);
        list.add(5);
        list.add(16);
        list.add(3);
        list.add(1);

        list.quickSort();

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(5, list.get(2));
        assertEquals(6, list.get(3));
        assertEquals(9, list.get(4));
        assertEquals(16, list.get(5));
    }

    @Test
    public void quickSortComparatorWhenGetListOfIntegersShouldSortDesc () {

        YetAnotherArrayList<Integer> list = new YetAnotherArrayList<>();

        list.add(9);
        list.add(6);
        list.add(5);
        list.add(16);
        list.add(3);
        list.add(1);

        Comparator<Integer> comparator = Comparator.reverseOrder();

        list.quickSort(comparator);

        assertEquals(1, list.get(5));
        assertEquals(3, list.get(4));
        assertEquals(5, list.get(3));
        assertEquals(6, list.get(2));
        assertEquals(9, list.get(1));
        assertEquals(16, list.get(0));
    }


}
