import java.util.Arrays;
import java.util.Comparator;

public class YetAnotherArrayList<T> {

    private Object[] objects;
    private int size;

    public YetAnotherArrayList() {
        objects = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T element) {

        if (size == objects.length) {
            objects = Arrays.copyOf(objects, objects.length * 3 / 2 + 1);
        }

        objects[size++] = element;
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return (T) objects[index];
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        for (int i = index; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }

        objects[size - 1] = null;

        size--;

    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    public void quickSort(Comparator<T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private void quickSort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high) {

        int middle = low + (high - low) / 2;
        Comparable<T> pivot = (Comparable<T>) objects[middle];

        changePlaces(middle, high);

        int indexToCompare = low - 1;

        for (int i = low; i < high; i++) {
            if (pivot.compareTo((T) objects[i]) > 0) {
                indexToCompare++;
                changePlaces(indexToCompare, i);
            }
        }

        changePlaces(indexToCompare + 1, high);

        return indexToCompare + 1;
    }

    private int partition(int low, int high, Comparator<T> comparator) {
        int middle = low + (high - low) / 2;
        T pivot = (T) objects[middle];
        changePlaces(middle, high);

        int indexToCompare = low - 1;

        for (int i = low; i < high; i++) {
            if (comparator.compare((T) objects[i], pivot) < 0) {
                indexToCompare++;
                changePlaces(indexToCompare, i);
            }
        }

        changePlaces(indexToCompare + 1, high);
        return indexToCompare + 1;
    }

    private void changePlaces(int index1, int index2) {
        Object object = objects[index1];
        objects[index1] = objects[index2];
        objects[index2] = object;
    }
}
