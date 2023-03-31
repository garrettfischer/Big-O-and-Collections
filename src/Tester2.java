import java.util.*;

//has runtime of o(n) more efficient
/**
 * The Tester class provides a static method for testing whether two lists contain the same elements,
 * regardless of their order or frequency.
 */
public class Tester2 {

    /**
     * Tests whether two lists contain the same elements, regardless of their order or frequency.
     *
     * @param a the first list to compare
     * @param b the second list to compare
     * @param <T> the type of elements in the lists, must extend Comparable
     * @return true if the two lists contain the same elements, false otherwise
     */
    public static <T extends Comparable<T>> boolean test(List<T> a, List<T> b) {
        if (a.size() != b.size()) {
            return false;
        }

        // create a map to store the frequency of elements in the first list
        Map<T, Integer> counts = new HashMap<>();
        for (T element : a) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
        }

        // check if the elements in the second list exist in the map and have the same frequency as in the first list
        for (T element : b) {
            if (!counts.containsKey(element)) {
                return false;
            }
            int count = counts.get(element);
            if (count == 0) {
                return false;
            }
            counts.put(element, count - 1);
        }

        return true;
    }

    /**
     * The main method contains several test cases for the test method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(test(l1, l2));  // true
        System.out.println(test(List.of(1), List.of())); // false
        System.out.println(test(List.of(), List.of(1))); // false
        System.out.println(test(
                List.of(1, 3, 3, 2, 1),
                List.of(1, 3, 1, 3, 2)));              // true
        System.out.println();

        System.out.println(test(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('a', 'x', 'c', 'm', 'c', 'x', 'j')));      // false

        System.out.println(test(
                List.of('a', 'x', 'c', 'm', 'c', 'c', 'x', 'j'),
                List.of('c', 'a', 'x', 'c', 'm', 'c', 'x', 'j')));  // true
    }
}
